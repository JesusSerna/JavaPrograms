import java.util.*;

public class task9
{
public static ArrayList<String> insert_before_longer(ArrayList<String> x, String a)
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
  public static ArrayList<String> sort_by_length (ArrayList<String> a)
  {
      ArrayList<String> result = new ArrayList<String>();
      for (int i = 0; i < a.size(); i++)
      {
        String word = a.get(i);
        result = insert_before_longer(result, word);
      }
      return result;
  } 
  public static void main(String[] args)
  {
    ArrayList<String> a = new ArrayList<String>();
    
    a.add("whale");
    a.add("cat");
    a.add("elephant");
    a.add("donkey");
    a.add("goat");

    ArrayList<String> result = sort_by_length(a);
    System.out.printf("Input:  ");
    System.out.println(a);
    System.out.printf("Output: ");
    System.out.println(result);  
  }
}