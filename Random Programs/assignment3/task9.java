import java.util.Scanner;
public class task9 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.printf("Please enter an integer: ");
        int integer = in.nextInt();
        
        if (integer < 0)
        {
            System.out.printf("%d is negative.\n", integer);
        }
        else if (integer < 10)
        {
            System.out.printf("%d has one digit.\n", integer);
        }
        else if (integer < 100)
        {
            System.out.printf("%d has two digits.\n", integer);
        }
        else if (integer < 1000)
        {
            System.out.printf("%d has three digits.\n", integer);         
        }
        else if (integer < 10000)
        {
            System.out.printf("%d has four digits.\n", integer);
        }
        else if (integer < 100000)
        {
            System.out.printf("%d has five digits.\n", integer);
        }
        else if (integer < 1000000)
        {
            System.out.printf("%d has six digits.\n", integer);
        }
        else
        {
            System.out.printf("%d has more than six digits.\n", integer);
        }
    }
    
}
