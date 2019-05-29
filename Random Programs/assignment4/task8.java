import java.util.Scanner;
public class task8 {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.printf("Enter a positive integer N > 1: ");
      int number = in.nextInt();
      int power = 0;
      int result = number;
      if (number <= 1)
      {
          System.out.printf("Exiting...\n");
          System.exit(0);
      }
      while (result <= 40000)
      {
          result = (int) Math.pow(number,power);
          if (result <= 40000)
          {
          System.out.printf("%d\n", result);
          }
          power++;  
      }
      System.out.printf("Exiting...\n");
    }  
}
