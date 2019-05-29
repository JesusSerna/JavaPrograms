import java.util.Scanner;

public class task7
{
  public static double pick_middle(double first, double second, double third)
  {
    if ((first >= second && first <= third)||(first <= second && first >= third))
        return first;
    else if ((second >= first && second <= third)||(second <= first && second >= third))
        return second;
    else if ((third >= second && third <= first)||(third <= second && third >= first))
        return third;
   return 0;
  }
  public static double user_double(String message)
  {
    Scanner in = new Scanner(System.in);
    double result;
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
        result = Double.parseDouble(s);
      } catch (Exception e)
      {
        System.out.printf("%s is not a valid number.\n\n", s);
        continue;
      }
      return result;
    }
  }

  public static void main(String[] args)
  {
    while (true)
    {
      double first = user_double("please enter the first number: ");
      double second = user_double("please enter the second number: ");
      double third = user_double("please enter the third number: ");
      double middle = pick_middle(first, second, third);
      System.out.printf("the middle value is %.1f\n\n", middle);
    }
  }
}