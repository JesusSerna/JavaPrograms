import java.util.Scanner;
public class task10 
{
    public static void main(String[] args) 
    {
      Scanner in = new Scanner(System.in);
      System.out.printf("Please enter an integer: ");
      int integer = in.nextInt();
      if (integer%2 < 1 && integer%3 <1)
      {
          System.out.printf("The number is even and divisible by 3.\n");
      }
      else if (integer%2 <1)
      {
          System.out.printf("The number is even and not divisible by 3.\n");
      }
      else if (integer%3 < 1)
      {
          System.out.printf("The number is odd and divisible by 3.\n");
      }
      else
      {
          System.out.printf("The number is odd and not divisible by 3.\n");
      }
          
    }
    
}
