import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class compute_grades
{
  public static String get_letter_grade(double smallest)
  {
      String result = "F";
      if (smallest >= 90)
          return "A";
      if (smallest >= 80)
          return "B";
      if (smallest >= 70)
          return "C";
      if (smallest >= 60)
          return "D";
      return result;
  }
  public static void Add_To_prettyfile(String [][] grades, String filename,
                                   double Average_test, double Average_homework,
                                   String name)
  {
    { 
   String[][] output = read_spreadsheet(filename);
   
   PrintWriter out = null;
    try
    {
        out = new PrintWriter(filename);
    }
    catch (Exception e)
    {
        System.out.printf("Error: failed to open file %s.\n", filename);
        System.exit(0);
    }
   
   if (output.length==0)
   {
    String[] firstline = {"name", "exam score", "hw score", "min score", "grade"};
    output = new String[1][firstline.length];
    out.printf("%20s: %10s, %8s, %9s, %s\n", firstline[0], firstline[1], "hw score", "min score", "grade");
   
   }
   else
   {
    for (int i = 0; i < output.length; i++)
    {
        for (int j = 0; j < output[i].length; j++)
        {
            out.printf(output[i][j]);   
            if (j+1 != output[i].length)
            {
                out.printf(",");
            }
            else if (j+1 == output[i].length)
            {
                out.printf("\n");
            }
        }
    }
   }
    double Smallest = Average_homework;
    if (Average_homework > Average_test)
    {
        Smallest = Average_test;
    }
    String letter_grade = get_letter_grade(Smallest);
    out.printf("%20s: %10.2f, %8.2f, %9.2f, %s", name, Average_test, Average_homework,
                                        Smallest, letter_grade);
    out.close();
  }    
  }
  public static void Add_To_csv(String [][] grades, String filename,
                                   double Average_test, double Average_homework,
                                   String name)
  { 
   String[][] output = read_spreadsheet(filename);
   
   PrintWriter out = null;
    try
    {
        out = new PrintWriter(filename);
    }
    catch (Exception e)
    {
        System.out.printf("Error: failed to open file %s.\n", filename);
        System.exit(0);
    }
   
   if (output.length==0)
   {
    String[] firstline = {"name", "exam score", "hw score", "min score", "grade"};
    output = new String[1][firstline.length];
    for (int i = 0; i < firstline.length; i++)
    {
    out.printf("%s", firstline[i]); 
    if (i+1 != firstline.length)
            {
                out.printf(",");
            }
    else if (i+1 == firstline.length)
            {
                out.printf("\n");
            }
    }
   }
   else
   {
    for (int i = 0; i < output.length; i++)
    {
        for (int j = 0; j < output[i].length; j++)
        {
            out.printf(output[i][j]);   
            if (j+1 != output[i].length)
            {
                out.printf(",");
            }
            else if (j+1 == output[i].length)
            {
                out.printf("\n");
            }
        }
    }
   }
    double Smallest = Average_homework;
    if (Average_homework > Average_test)
    {
        Smallest = Average_test;
    }
    String letter_grade = get_letter_grade(Smallest);
    out.printf("%s,%f,%f,%f,%s", name, Average_test, Average_homework,
                                        Smallest, letter_grade);
    out.close();
  }  
  
  public static void process_grades(String input_name, String csv_name, 
                                    String pretty_name)
  {
      String[][] grades = read_spreadsheet(input_name);
      
      int line = 1;
      while (line < grades.length)
      {
      double Average_test = Average(grades, "tests", line);
      double Average_homework = Average(grades, "homework", line);
      String name = Get_Name(grades, line);
      line ++;
      Add_To_csv(grades, csv_name, Average_test, Average_homework, name);
      Add_To_prettyfile(grades, pretty_name, Average_test, Average_homework, name);
      }
    
      
          
  } 
  
  public static String Get_Name(String[][] grades, int line)
  {
     String result = "";
     for (int j = 0; j < grades[line].length; j++)
          {
           if (grades[0][j].indexOf("First") != -1)
           {
              result = grades[line][j];   
           }
           if (grades[0][j].indexOf("Last") != -1)
           {
               result += " " +grades[line][j];
           }
          }
     return result;
  }
  
  public static double Average(String[][] grades, String a, int line)
  {
      double Average_test = 0;
      double Average_homework = 0;
      
          double tests = 0;
          double homeworks = 0;
          for (int j = 0; j < grades[line].length; j++)
          {
           if (grades[0][j].indexOf("Exam") != -1 || grades[0][j].indexOf("Final") != -1)
           {
              Average_test += Double.parseDouble(grades[line][j]);
              tests++;
              
           }
           if (grades[0][j].indexOf("H") != -1)
           {
              Average_homework += Double.parseDouble(grades[line][j]);
              homeworks++;
           }
          }
        Average_test = Average_test/tests;
        Average_homework = Average_homework/homeworks;  
      if (a == "homework")
      {
        return Average_homework;
      }
      else 
          return Average_test;
  }

  public static String[][] read_spreadsheet(String filename)
  {
    ArrayList<String> lines = read_file(filename);
    if (lines == null)
    {
      return null;
    }

    int rows = lines.size();
    String[][] result = new String[rows][];

    for (int i = 0; i < rows; i++)
    {
      String line = lines.get(i);
      String[] values = line.split(",");
      result[i] = values;
    }

    return result;
  } 
  
  public static ArrayList<String> read_file(String filename)
  {
    File temp = new File(filename);
    Scanner input_file;
    ArrayList<String> result = new ArrayList<String>();

    try
    {
      input_file = new Scanner(temp);
    }
    catch (Exception e)
    {
      return result;
    }

    while(input_file.hasNextLine())
    {
      String line = input_file.nextLine();
      result.add(line);
    }
    
    input_file.close();
    return result;
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    System.out.printf("Please enter the name of the input file: ");
    String input_name = in.next();
    System.out.printf("Please enter the name of the output CSV file: ");
    String csv_name = in.next();
    System.out.printf("Please enter the name of the output pretty-print file: ");
    String pretty_name = in.next();
    
    process_grades(input_name, csv_name, pretty_name);
    System.out.printf("\n\nExiting...\n");
  }
}