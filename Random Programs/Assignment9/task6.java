import java.util.*;
import java.io.File;

public class task6
{
    public static int get_month(String date)
  {
     int position = 0;
     int end_position = 0;
     String numbers = "0123456789";
     for (int i = 0; i < date.length();i++)
     {
         char character = date.charAt(i);
         if (numbers.indexOf(character) != -1)
         {
            position = i;
            break;
         }
    
     }
     for (int j = 0; j < date.length();j++)
     {
             if (date.charAt(j) == '/')
             {
                 end_position = j;
                 break;
             }
     }
     int month = Integer.parseInt(date.substring(position,end_position));
     return month;
  }
  public static ArrayList<String> read_file(String filename)
  {
    File temp = new File(filename);
    Scanner input_file;
    try
    {
      input_file = new Scanner(temp);
    }
    catch (Exception e)
    {
      System.out.printf("Failed to open file %s\n",
                        filename);
      return null;
    }

    ArrayList<String> result = new ArrayList<String>();
    while(input_file.hasNextLine())
    {
      String line = input_file.nextLine();
      result.add(line);
    }
    
    input_file.close();
    return result;
  } 


  public static void print_months(String filename)
  {
    ArrayList<String> lines = read_file(filename);
    for (int i = 1; i < lines.size(); i++)
    {    
      String line = lines.get(i);
      String[] columns = line.split(",");

      String date = columns[0];
      int line_month = get_month(date);
      System.out.printf("row %d, month = %d\n", i, line_month);
    }
  }
  
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("Enter a filename (or q to quit): ");
      String filename = in.next();
      if (filename.equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      print_months(filename);
      System.out.printf("\n");
    }
  }
}