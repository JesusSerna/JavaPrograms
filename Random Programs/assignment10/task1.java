import java.io.PrintWriter;
import java.util.*;
import java.io.File;

public class task1
{
public static void print_player_info(String [][] data, String player)
{
  String playername;
  for (int i = 0; i < data.length; i++) 
  {
      playername = data[i][0];
      playername = playername.toLowerCase();
      if (playername.indexOf(player.toLowerCase()) != -1)
      {
          System.out.printf("\n");
          for (int j = 0; j < data[0].length;j++)
          {
              String a = data[0][j];
              String b = data[i][j];
              System.out.printf("%20s: %s\n", a, b);
          }
          System.out.printf("\n");
      }
      
}
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

public static String[][] read_spreadsheet(String filename) {
    ArrayList<String> lines = read_file(filename); 
    int rows = lines.size();
    String[][] result = new String[rows][];
     for (int i = 0; i < lines.size(); i++)
    {
    String line = lines.get(i);
    String [] values = line.split(","); result[i] = values;
    }
     return result;
} 
 
public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    String[][] data = read_spreadsheet("nba.txt");
    while (true)
    {
      System.out.printf("\nEnter part of a player's name (or q to quit): ");
      String player = in.next();
      if (player.equals("q"))
      {
        System.out.printf("Exiting...");
        System.exit(0);
      }
      print_player_info(data, player);
    }
      
  }
}