import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class task2
{

  public static void count_vowels(String InputFile)
  {
      File temp = new File(InputFile);
      Scanner input_file;
      try
      {
          input_file = new Scanner(temp);
      }
      catch (Exception e)
      {
          System.out.printf("Could not open file.\n");
          return;
      }
      String Vowels = "aAeEiIoOuU";
      String file = "";
      int a = 0;
      int e = 0;
      int i = 0;
      int o = 0;
      int u = 0;
      while (input_file.hasNextLine())
      {
         file = file + input_file.nextLine();
      }
      for (int count = 0; count < file.length(); count++)
      {
          char letter = file.charAt(count);

          if (Vowels.indexOf(letter) == 0 || Vowels.indexOf(letter) == 1 )
          {
            a++;  
          }
          else if (Vowels.indexOf(letter) == 2 || Vowels.indexOf(letter) == 3 )
          {
            e++;  
          }
          else if (Vowels.indexOf(letter) == 4 || Vowels.indexOf(letter) == 5 )
          {
            i++;  
          }
          else if (Vowels.indexOf(letter) == 6 || Vowels.indexOf(letter) == 7 )
          {
            o++;  
          }
          else if (Vowels.indexOf(letter) == 8 || Vowels.indexOf(letter) == 9 )
          {
            u++;  
          }
      }
      System.out.printf("a: %d times\ne: %d times\ni: %d times\no: %d tiems\nu: %d times\n",a,e,i,o,u);
      input_file.close();
  }
  public static void main(String[] args)
  {
    count_vowels("in2.txt");
  }
}  