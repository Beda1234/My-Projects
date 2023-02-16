
import java.util.Scanner;

public class PatternL{ 

	public static void main(String[] args)
    { 
		
        System.out.println("enter the number for making a pyramid print");
        Scanner sc = new Scanner(System.in)
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
           for(int j=i;j<=n;j++)
           {
            System.out.print(" ");
           }
           for(int j=i;j>=1;j--)
           {
               System.out.print(j);
           }
           for(int j=2;j<=i;j++)
           {
               System.out.print(j);
           }
        System.out.println();
           
        }
        
    }
}

