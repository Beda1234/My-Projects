
import java.util.Scanner;
public class PatternA{ 

	public static void main(String[] args)
     { int i,j;
		Scanner sc= new Scanner(System.in);
        System.out.println("enter the number of pattern want to print");
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        for(i=1;i<=n;i++)
        
        {
            for(j=1;j<=m;j++)
            {
                System.out.print("*");
            }
        System.out.println("");
        
	    }
    }

}
