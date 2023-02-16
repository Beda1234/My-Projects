
import java.util.Scanner;
public class PatternB{ 

	public static void main(String[] args)
     { int i,j;
		Scanner sc= new Scanner(System.in);
        System.out.println("enter the number of row want to print");
        int n=sc.nextInt();
        System.out.println("enter the number of column want to print");
        int m=sc.nextInt();
        
        for(i=1;i<=n;i++)
        {
            
            for(j=1;j<=m;j++)
            {
                if(i==1||i==n||j==1||j==m)
                {System.out.print("*");}
                else{System.out.print(" ");};
            }
        System.out.println("");
        
	    }
    }

}
