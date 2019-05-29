import java.util.Scanner;

public class task6
{

  public static boolean is_leap_year(int year)
  {
    if (year % 100 == 0)
    {
        return year % 400 == 0;
    }
    else
    {
        return year % 4 == 0;
    }
  
  }
  public static int user_integer(String message)
  {
    Scanner in = new Scanner(System.in);
    int result;
    while (true)
    {
      System.out.printf(message);
      String s = in.next();
      try
      {
        result = Integer.parseInt(s);
      } catch (Exception e)
      {
        System.out.printf("%s is not a valid integer.\n\n", s);
        continue;
      }
      return result;
    }
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      int year = user_integer("Please enter a year, or -1 to quit: ");
      if (year == -1)
      {
        break;
      }

      boolean result = is_leap_year(year);
      if (result == true)
      {
        System.out.printf("Yes, %d is a leap year.\n\n", year);
      } else
      {
        System.out.printf("No, %d is not a leap year.\n\n", year);
      }
    }
    System.out.printf("Exiting...\n");
  }
}