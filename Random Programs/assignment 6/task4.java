import java.util.Scanner;

public class task4
{
  
  public static int count_words(String text)
  {
      int counter = 0;
      int position = 0;
      int length = text.length();
      while (position < length)
      {
        if (text.charAt(position) == ' ')
        {
            if (position + 1 != length)
                if (text.charAt(position + 1) != ' ')
                    counter++;
        }
        else if (position - 1 == -1)
            counter++;
        position++;  
      }
      return counter;
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
      int result = count_words(text);
      System.out.printf("Counted %d words.\n\n", result);
    }
  }
}