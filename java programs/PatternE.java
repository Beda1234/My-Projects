
import java.util.Scanner;
public class PatternE{ 

	public static void main(String[] args)
     { 
		Scanner sc= new Scanner(System.in);
        System.out.println("enter the number of row want to print");
        int n=sc.nextInt();
        for(int i=n;i>=1;i--)
        {
          for(int j=1;j<=i;j++)
          {System.out.print(".");}
          for(int j=0;j<=n-i;j++)
          {System.out.print("*");}
          System.out.println("");

        }
     }
    

}
