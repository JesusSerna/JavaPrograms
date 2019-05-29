import java.util.Scanner;
public class task7
 {
 public static void main(String[] args)
  {
  Scanner in = new Scanner(System.in);
  System.out.printf("Please indicate a month as an integer from 1 to 12: ");
  int month = in.nextInt();
  if (month == 1)
   {
    System.out.printf("January\n");
   }
  else if (month == 2)
   {
    System.out.printf("Febuary\n");
   }
  else if (month == 3)
   {
    System.out.printf("March\n");
   }
  else if (month == 4)
   {
    System.out.printf("April\n");
   }
  else if (month == 5)
   {
    System.out.printf("May\n");
   }
  else if (month == 6)
   {
    System.out.printf("June\n");
   }
  else if (month == 7)
   {
    System.out.printf("July\n");
   }
  else if (month == 8)
   {
    System.out.printf("August\n");
   }
  else if (month == 9)
   {
    System.out.printf("September\n");
   }
  else if (month == 10)
   {
    System.out.printf("October\n");
   }
  else if (month == 11)
   {
    System.out.printf("November\n");
   }
  else if (month == 12)
   {
    System.out.printf("December\n");
   }
  else 
   {
    System.out.printf("Invalid month\n");
    System.exit(0);
   }
  }
 }
