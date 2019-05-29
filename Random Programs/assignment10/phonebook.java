import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class phonebook
{
  // returns a phonebook:
  // either reads it from the phonebook.txt file, if the file exists, 
  // or returns an empty array.
  public static String[][] read_phonebook()
  {
      File temp = new File("phonebook.txt");
    Scanner input_file;
    try
    {
      input_file = new Scanner(temp);
    }
    catch (Exception e)
    {
      System.out.printf("Failed to open file \"phonebook.txt\"\n");
      return null;
    }

    ArrayList<String> a = new ArrayList<String>();
    while(input_file.hasNextLine())
    {
      String line = input_file.nextLine();
      a.add(line);
    }
    input_file.close();
    
   
    int rows = a.size();
    String[][] result = new String[rows][];
     for (int i = 0; i < a.size(); i++)
    {
    String line = a.get(i);
    String [] values = line.split(","); result[i] = values;
    }
     return result;
  }
  
  
  public static void save_phonebook(String[][] data, String new_name, String new_number)
  {
   String filename = "phonebook.txt"; 
  
   PrintWriter out = null;
    try
    {
        out = new PrintWriter("phonebook.txt");
    }
    catch (Exception e)
    {
        System.out.printf("Error: failed to open file %s.\n", filename);
        System.exit(0);
    }
    for (int i = 0; i < data.length; i++)
    {
        out.write(data[i][0] + "," + data[i][1] + "\n");   
    }
    
    out.write(new_name + "," + new_number);
    
    out.close();
  } 
    

  public static void print_spreadsheet(String[][] data)
  {
    for (int i = 0; i < data.length; i++)
    {
        System.out.printf("%2d:%20s, %s\n", i, data[i][0], data[i][1]);   
    }  
  }
  
  
  public static void search_data(String[][] data)
  {
      Scanner in = new Scanner(System.in);
      System.out.printf("Enter part of the name: ");
      String name = in.next();
      name = name.toLowerCase();
      for (int i = 0; i < data.length; i++)
      {
          String name_in_file = data[i][0];
          name_in_file = name_in_file.toLowerCase();
          if (name_in_file.indexOf(name) != -1)
          {
              System.out.printf("%20s: %s\n", data[i][0], data[i][1]);
          }
      }
  }
  
  
  public static String[][] input_new_entry(String[][] data)
  {
    Scanner in = new Scanner(System.in);
    
    System.out.printf("\nEnter a name: ");
    String name = in.nextLine();
    System.out.printf("\nEnter a number: ");
    String number = in.nextLine();
    save_phonebook(data, name, number);
    data = read_phonebook();
    return data;
  }  
  
  
  public static String[][] process_option(String[][] data, String option)
  {
    if (option.equals("1"))
    {
      print_spreadsheet(data);
    }
    else if (option.equals("2"))
    {
      data = input_new_entry(data);
    }
    else if (option.equals("3"))
    {
      search_data(data);
    }
    else if (option.equals("q"))
    {
      System.exit(0);
    }
    else
    {
      System.out.printf("Unrecognized option %s.\n", option);
    }
    
    return data;
  }
  
  public static String ask_option()
  {
    Scanner in = new Scanner(System.in);
    
    System.out.printf("\n1: Print phonebook.\n");
    System.out.printf("2: Input a new entry.\n");
    System.out.printf("3: Search by name.\n");
    System.out.printf("q: Quit program.\n");
    System.out.printf("Please enter an option: ");
    String option = in.next();
    return option;
  }

  
  public static void main(String[] args)
  {
    String[][] data = read_phonebook();
    print_spreadsheet(data);

    while(true)
    {
      String option = ask_option();
      data = process_option(data, option);
    }
  }
  
}