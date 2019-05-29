import java.util.*;

public class task7
{
  public static ArrayList<String> insert_before_larger(ArrayList<String> x, String a)
  {
    int position = 0;
    for (int i= 0; i < x.size(); i++)
    {
      String word = x.get(i);
      if (word.length() >= a.length())
      {
          position = i;
          break;
      }
      else 
      {
          position = x.size() ;
      }
      
    }
    x.add(position, a); 
    return x;
  }
  public static int find_minimum_length( ArrayList<String> a)
  {
      if (a.size()==0)
      {
          return -1;
      }
      ArrayList<String> Result = new ArrayList<String>();
      int position = 0;
      for (int i = 0; i < a.size(); i++)
      {
          Result = insert_before_larger(Result, a.get(i));
      }
      
      for (int i = 0; i < a.size(); i++)
      {
          if (a.get(i) == Result.get(0))
              position = i;
      }
      return position;
  }
  public static void remove_minimum_length(ArrayList<String> a)
  {
      if (a.size()==0)
      {
          return;
      }
   int position = find_minimum_length(a);
   a.remove(position);
  }
  public static void main(String[] args)
  {
    ArrayList<String> a = new ArrayList<String>();
    
    a.add("whale");
    a.add("cat");
    a.add("elephant");
    a.add("donkey");
    a.add("goat");

    System.out.println(a);
    int position = find_minimum_length(a);
    System.out.printf("minimum position = %d\n\n", position);

    remove_minimum_length(a);
    System.out.println(a);
    position = find_minimum_length(a);
    System.out.printf("minimum position = %d\n\n", position);

    remove_minimum_length(a);
    System.out.println(a);
    position = find_minimum_length(a);
    System.out.printf("minimum position = %d\n\n", position);

    remove_minimum_length(a);
    System.out.println(a);
    position = find_minimum_length(a);
    System.out.printf("minimum position = %d\n\n", position);

    remove_minimum_length(a);
    System.out.println(a);
    position = find_minimum_length(a);
    System.out.printf("minimum position = %d\n\n", position);

    remove_minimum_length(a);
    System.out.println(a);
    position = find_minimum_length(a);
    System.out.printf("minimum position = %d\n\n", position);
 }
}