import java.util.*;
import java.io.File;

public class task7
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
  public static String column_name(String filename, int column)
  {
    ArrayList<String> lines = read_file(filename); 
      String line = lines.get(0);
      String[] columns = line.split(",");
      return columns[column];
  }
  public static double monthly_average(String filename, int column, int month)
  {
    ArrayList<String> lines = read_file(filename);
    double sum = 0;
    int number_of_numbers = 0;
    for (int i = 1; i < lines.size(); i++)
    {   
      String line = lines.get(i);
      String[] columns = line.split(",");
      String date = columns[0];
      int line_month = get_month(date);
      if (line_month == month)
      {
        String number = columns[column];
        sum += Double.parseDouble(number); 
        number_of_numbers++;
      }
    }
    if (sum == 0)
    {
        return -1;
    }
    double average = sum / number_of_numbers;
    return average;
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
      System.out.printf("Enter a column: ");
      int column = in.nextInt();
      String name = column_name(filename, column);
      
      System.out.printf("Enter a month: ");
      int month = in.nextInt();
      
      double average = monthly_average(filename, column, month);
      if (average == -1.00)
      {
        System.out.printf("In file %s, there is no data for %s for month %d.\n\n",
                          filename, name, month);
      }
      else
      {
        System.out.printf("In file %s, the average %s for month %d is %.2f.\n\n",
                          filename, name, month, average);
      }
    }
  }
}