import java.util.*;
import java.io.File;

public class task3
{
  public static void make_array(String row1, int number_columns,ArrayList<String> column_name)
  {
    int letter_position = 0;
      for (int i=letter_position; i< number_columns+1;i++)
    {
        String array = "";
        for (int j=letter_position; j < row1.length();j++)
        {
            if (row1.charAt(j) == ',')
            {
                letter_position++;
                break;
            }
            letter_position++;
            array +=  row1.charAt(j);
        }
        column_name.add(array);
    }
  }
  public static String column_name(String filename, int column)
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
    int number_columns =0;
    String row1 = input_file.nextLine();
    for (int i = 0; i< row1.length();i++)
    {
        if (row1.charAt(i)==',')
        {
            number_columns++;
        }
    }
    ArrayList<String> column_name = new ArrayList<String>();
    make_array(row1, number_columns, column_name);
    if (column < 0|| column >= column_name.size())
    {
        return null;
    }
    input_file.close();
    return column_name.get(column);
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
      if (name == null)
      {
        System.out.printf("Failed to extract a valid column name for column %d of %s\n\n",
                          column, filename);
      }
      else
      {
        System.out.printf("In file %s, column %d is \"%s\"\n\n",
                          filename, column, name);
      }
    }
      
  }
}