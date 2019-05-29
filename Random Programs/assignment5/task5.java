import java.util.Scanner;

public class task5
{
  public static double sphere_volume(double r)
  {
    double volume = (4.0/3.0) * Math.PI * Math.pow(r, 3);
    return volume;
  }

  public static double user_double(String message)
  {
    Scanner in = new Scanner(System.in);
    double result;
    while (true)
    {
      System.out.printf(message);
      String s = in.next();
      try
      {
        result = Double.parseDouble(s);
      }
      catch (Exception e)
      {
        System.out.printf("%s is not a valid double.\n\n", s);
        continue;
      }
      return result;
    }
  }
  
  public static void main(String[] args)
  {
    while(true)
    {
      double r = user_double("Please enter a radius, or -1 to quit: ");
      if (r == -1)
      {
        break;
      }
      
      double volume = sphere_volume(r);
      System.out.printf("Volume = %.2f.\n\n", volume);
    }
    System.out.printf("Exiting...\n");
  }
}