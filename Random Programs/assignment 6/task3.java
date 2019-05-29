import java.util.Scanner;

public class task3
{
  
  
  public static void print_coded(String word, String sources, String targets)
  {
      int counter = 0;
      int Length = word.length();
      char letter;
      int target;
      char coded;
      while (counter < Length)
      {
          letter = word.charAt(counter); 
          if (sources.indexOf(letter) > -1)
          {
              target = sources.indexOf(letter);
              coded = targets.charAt(target);
              System.out.printf("%s",coded);
            
              
          }
          else 
          {
              System.out.printf("%c", letter);
          }
          counter ++;   
      }
  }
  
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    
    String sources = "abcdefghijklmnopqrstuvwxyz";
    String targets = "bcdefghijklmnopqrstuvwxyza";
    
    while (true)
    {
      System.out.printf("Enter some word, or q to quit: ");
      String word = in.next();
      if (word.equals("q"))
      {
        System.out.printf("Exiting...\n");
        break;
      }
      print_coded(word, sources, targets);
      System.out.printf("\n\n");
    }
  }
}