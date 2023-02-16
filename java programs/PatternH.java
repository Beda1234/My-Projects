
import java.util.Scanner;

public class PatternH{ 

	public static void main(String[] args)
    { int max=1;
		Scanner sc= new Scanner(System.in);
        System.out.println("enter the number of you want to print");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
           for(int j=1;j<=i;j++)
           {
             System.out.print("  "+max);
             max++;
           }
           System.out.println();
           
        }
        
    }
}

