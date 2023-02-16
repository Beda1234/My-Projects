package com.example.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This Class is for import excel data to DB
 */
@SpringBootApplication
public class ExcelToDbApplication {

	public static void main(String[] args) throws SQLException {

		String excelFilePath = "C:\\Users\\RSTPL076\\Desktop\\demo.xlsx";

		int batchSize = 20;

		Connection connection = null;

		FileInputStream inputStream = null;

		try {
			Properties properties = new Properties();
			properties.load(ExcelToDbApplication.class.getClassLoader().getResourceAsStream("application.properties"));
			long start = System.currentTimeMillis();

			Class.forName("com.mysql.cj.jdbc.Driver");
			inputStream = new FileInputStream(excelFilePath);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			String tableName = firstSheet.getSheetName();
			Iterator<Row> rowIterator = firstSheet.iterator();

			String tableSchema = "excel";
			String url = "jdbc:mysql://localhost:3306/" + tableSchema + "";

			connection = DriverManager.getConnection(url, "root", "bedaprakash123@");
			connection.setAutoCommit(false);
			String createQuery = "";
			String insertQuery = "";
			String insertColumnName = "";
			String noColumns = "";
			String tableColumns = "";
			String dropTableQuery = properties.getProperty("tables.to.drop.table");
			String checkTableQuery = properties.getProperty("tables.to.check.table");
			PreparedStatement preparedStatement = null;
			Statement statement = connection.createStatement();
			// Checking the table is on DB or not
			preparedStatement = connection.prepareStatement(checkTableQuery);
			preparedStatement.setString(1, tableSchema);
			preparedStatement.setString(2, tableName);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count > 0) {
					// if table is exist
					preparedStatement = connection.prepareStatement(dropTableQuery + tableSchema + "." + tableName);
					Row roww = firstSheet.getRow(0);
					for (int i = 0; i <= roww.getLastCellNum() - 1; i++) {

						Cell cell = roww.getCell(i);
						String cellValue = cell.getStringCellValue();
						insertColumnName = (i == roww.getLastCellNum() - 1) ? insertColumnName + cellValue
								: insertColumnName + cellValue + ",";

						noColumns = (i == roww.getLastCellNum() - 1) ? noColumns + "?" : noColumns + "?,";
						tableColumns = (i == roww.getLastCellNum() - 1) ? tableColumns + cellValue + " VARCHAR(50)"
								: tableColumns + cellValue + " VARCHAR(50),";

						createQuery = "CREATE TABLE " + tableSchema + "." + tableName + "(" + tableColumns + "); ";
						if (i == roww.getLastCellNum() - 1) {

							insertQuery = "INSERT INTO " + tableName + "(" + insertColumnName + ") VALUES (" + noColumns
									+ ")";
						}
					}
				} else {
					// If the table is not exist
					Row roww = firstSheet.getRow(0);
					for (int i = 0; i <= roww.getLastCellNum() - 1; i++) {

						Cell cell = roww.getCell(i);
						String cellValue = cell.getStringCellValue();
						insertColumnName = (i == roww.getLastCellNum() - 1) ? insertColumnName + cellValue
								: insertColumnName + cellValue + ",";
						noColumns = (i == roww.getLastCellNum() - 1) ? noColumns + "?" : noColumns + "?,";
						tableColumns = (i == roww.getLastCellNum() - 1) ? tableColumns + cellValue + " VARCHAR(50)"
								: tableColumns + cellValue + " VARCHAR(50),";
						createQuery = "CREATE TABLE " + tableSchema + "." + tableName + "(" + tableColumns + "); ";
						if (i == roww.getLastCellNum() - 1) {
							insertQuery = "INSERT INTO " + tableName + "(" + insertColumnName + ") VALUES (" + noColumns
									+ ")";
						}
					}
				}
				switch (count) {
				case 0: {
					// Table is not exist
					statement.executeUpdate(createQuery);
					preparedStatement = connection.prepareStatement(insertQuery);
					break;
				}
				case 1: {
					// Table is exist
					statement.executeUpdate(dropTableQuery + tableName);
					statement.executeUpdate(createQuery);
					preparedStatement = connection.prepareStatement(insertQuery);
					break;
				}
				default:
					break;
				}
			}
			int count = 0;
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					switch (nextCell.getCellType()) {
					case NUMERIC:
						preparedStatement.setDouble(nextCell.getColumnIndex() + 1, nextCell.getNumericCellValue());
						break;
					case STRING:
						preparedStatement.setString(nextCell.getColumnIndex() + 1, nextCell.getStringCellValue());
						break;
					case BLANK:
						preparedStatement.setObject(nextCell.getColumnIndex() + 1, null);
						break;
					case _NONE:
						preparedStatement.setObject(nextCell.getColumnIndex() + 1, null);
						break;
					default:
						break;
					}
				}
				preparedStatement.addBatch();
				if (count % batchSize == 0) {
					preparedStatement.executeBatch();
				}
			}
			workbook.close();
			preparedStatement.executeBatch();
			connection.commit();
			connection.close();
			preparedStatement.close();
			long end = System.currentTimeMillis();
			System.out.printf("Import done in %d ms\n", (end - start));
		} catch (IOException ex1) {
			System.out.println("Error reading file");
			ex1.printStackTrace();
		} catch (SQLException | ClassNotFoundException ex2) {
			System.out.println("Database error");
			ex2.printStackTrace();
		}
	}
}
