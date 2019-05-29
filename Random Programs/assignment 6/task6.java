import java.util.Scanner;

public class task6
{
  
  public static int year_days(int year)
  {
       if (year % 100 == 0)
    {
        if (year % 400 == 0)
        {
            return 366;
        }
        else
        {
            return 365;
        }
    }
    else
    {
        if (year % 4 == 0)
        {
            return 366;
        }
        else
        {
            return 365;
        }
    }
    
  }
  public static int month_days(int year, int month)
  {
      if (year % 100 == 0)
    {
        if (year % 400 == 0)
        {
            int[] month_lengths = {31, 29, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            return (month_lengths[month-1]);
        }
        else
        {
            int[] month_lengths = {31, 28, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            return (month_lengths[month-1]);
        }
    }
    else
    {
        if (year % 4 == 0)
        {
           int[] month_lengths = {31, 29, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            return (month_lengths[month-1]);
        }
        else
        {
            int[] month_lengths = {31, 28, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            return (month_lengths[month-1]);
        }
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
      if (s.equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      
      try
      {
        result = Integer.parseInt(s);
      } 
      catch (Exception e)
      {
        System.out.printf("%s is not a valid number, try again.\n\n", s);
        continue;
      }
      
      if (result <= 0)
      {
        System.out.printf("%s is <= 0, try again.\n\n", s);
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
      int year = user_integer("Enter a year (must be > 0): ");      
      int result = year_days(year);
      System.out.printf("Year %d has %d days.\n\n", year, result);
      
      int month = user_integer("Enter a month(must be between 1 and 12): ");
      if (month > 12)
      {
        System.out.printf("Invalid month.\n\n");
        continue;
      }
      int result2 = month_days(year, month);
      System.out.printf("Month %d, %d has %d days.\n\n", month, year, result2);
      
      
    }
  }
}