import java.util.*;
import java.io.File;

public class task4
{
  public static double add_column(int number_columns, String row, int column)
  {
      int letter_position = 0;
      ArrayList<String> row_number = new ArrayList<String>();
      for (int i=letter_position; i< number_columns+1;i++)
        {
        String array = "";
        for (int j=letter_position; j < row.length();j++)
          {
            if (row.charAt(j) == ',')
            {
                letter_position++;
                break;
            }
            letter_position++;
            array +=  row.charAt(j);
          }
        row_number.add(array);
        }
      double result = Double.parseDouble(row_number.get(column));
      return result;
  }
  public static double column_sum(String filename, int column)
  {
    File temp = new File(filename);
    Scanner input_file = null;
    try
    {
      input_file = new Scanner(temp);
    }
    catch (Exception e)
    {
      System.out.printf("Failed to open %s\n",filename);
      System.exit(0);
    }
    int number_columns = 0;
    String row1 = input_file.nextLine();
        for (int i = 0; i< row1.length();i++)
        {
            if (row1.charAt(i)==',')
            {
                number_columns++;
            }
            
        }
    if (column < 0|| column > number_columns)
    {
       System.out.printf("There are only %d columns.\n", number_columns);
       System.exit(0);
    }
    row1 = "";
    double result = 0;
    while(input_file.hasNextLine())
    {
      row1 = input_file.nextLine();
      result += add_column(number_columns, row1, column);
    }
    input_file.close();
    return result;
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
      
      double sum = column_sum(filename, column);
      System.out.printf("In file %s, column %d has sum %.2f\n\n",
                        filename, column, sum);
    }
  }
}