import java.util.Scanner;

public class task5
{
  
  public static void repeat_letters(String text, int times)
  {
      int position = 0;
      char letter;
      int length = text.length();
      
      while (position < length)
      {
          int counter = 0;
          while (counter < times)
          {
          letter = text.charAt(position);
          System.out.printf("%c", letter);
          counter++;
          }
        position++; 
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
      System.out.printf("Enter some text, or q to quit: ");
      String text = in.nextLine();
      if (text.equals("q"))
      {
        System.out.printf("Exiting...\n");
        break;
      }
      
      int times = user_integer("Enter number of times (must be > 0): ");
      
      repeat_letters(text, times);
      System.out.printf("\n\n");
    }
  }
}