
import java.util.Scanner;

public class PatternK{ 

	public static void main(String[] args)
    { 
		
        System.out.println("enter the number for making a pyramid print");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
           for(int j=i;j<=n;j++)
           {
            System.out.print(" ");
           }
           for(int j=1;j<=i;j--)
           {
               System.out.print(j);
               j++;
               System.out.println(j);
           }
           System.out.println();
           
        }
        
    }
}

