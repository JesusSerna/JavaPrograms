import java.util.Scanner;

public class task7
{
  
  public static int year_days(int year)
  {
    int days = 0;
    int counter = 1000;
    while (counter < year)
    {
    if (counter % 100 == 0)
    {
        if (counter % 400 == 0)
        {
            days+= 366;
            counter++;
        }
        else
        {
            days+= 365;
            counter++;
        }
    }
    else
    {
        if (counter % 4 == 0)
        {
            days+= 366;
            counter++;
        }
        else
        {
            days+= 365;
            counter++;
        }
    }
    }
    return days;
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
  public static int days_passed(int year, int month, int day)
  {
   int days = year_days(year);
   int counter = 1;
   while (counter < month)
    {
    if (year % 100 == 0)
    {
        if (year % 400 == 0)
        {
            int[] month_lengths = {31, 29, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            days += (month_lengths[counter-1]);
            counter++;
        }
        else
        {
            int[] month_lengths = {31, 28, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            days += (month_lengths[counter-1]);
            counter++;
        }
    }
    else
    {
        if (year % 4 == 0)
        {
           int[] month_lengths = {31, 29, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            days += (month_lengths[counter-1]);
            counter++;
        }
        else
        {
            int[] month_lengths = {31, 28, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
            days += (month_lengths[counter-1]);
            counter++;
        }
    }
    }
   days += day;
   return days;
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
  public static String day_of_week(int year, int month, int day)
  {
    String[] day_ofthe_week = {"Tuesday","Wednesday","Thursday",
                                 "Friday","Saturday", "Sunday","Monday"};
    int result = days_passed(year, month, day);
    int position = result % 7;
   
    
    String result_day = day_ofthe_week[position] ;
    return result_day;
  }
  
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    
    while (true)
    {
      int year = user_integer("Enter a year (must be >= 1000): ");      
      if (year < 1000)
      {
        System.out.printf("Invalid year.\n\n");
        continue;
      }

      int month = user_integer("Enter a month(must be between 1 and 12): ");
      if (month > 12)
      {
        System.out.printf("Invalid month.\n\n");
        continue;
      }
      
      int day = user_integer("Enter a day: ");
      if (day > month_days(year, month))
      {
        System.out.printf("Invalid day.\n\n");
        continue;
      }
      
      int result = days_passed(year, month, day);
      System.out.printf("%d days have passed from 12/31/999 to %d/%d/%d.\n", 
                        result, month, day, year);
      
      String day_name = day_of_week(year, month, day);
      System.out.printf("%d/%d/%d is a %s.\n\n", month, day, year, day_name);
    }
  }
}