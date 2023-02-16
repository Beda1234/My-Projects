
import java.util.Scanner;
public class TableA{

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        System.out.println("enter a value for a");
        int a=sc.nextInt();
        System.out.println("enter a value for b");
        int b=sc.nextInt();
        System.out.println("enter a value for calculator in between 1 to 5");
        int n=sc.nextInt();
        switch(n)
        {
            case 1:System.out.println("enter value  "+a+"  and"+b+"  addition is "+(a+b));
            break;
            case 2:System.out.println("enter value"+a+"and"+b+"substraction is "+(a-b));
            break;
            case 3:System.out.println("enter value"+a+"and"+b+"multiplication is "+(a*b));
            break;
            case 4:System.out.println("enter value"+a+"and"+b+"devision is "+(a/b));
            break;
            case 5:System.out.println("enter value"+a+"and"+b+"reminder (or)modulo is "+(a%b));
            break;
            default : System.out.println("this is not a number");

        }


	}

}
