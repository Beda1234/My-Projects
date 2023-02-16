
import java.util.Scanner;
public class EvenA{ 

	public static void main(String[] args) { int i;
		Scanner sc= new Scanner(System.in);
        System.out.println("enter a value for know the even numbers from your no. to 100");
        int n=sc.nextInt();
        for(i=n;i<=100;i++)
        {
            if(i%2==0){
                System.out.print(+i+" is a even numbers");
            }
            else{System.out.print("    ");}
        }
        
	}

}
