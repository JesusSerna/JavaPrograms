import java.util.*;

public class task10
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
  public static void sort_by_length2 (ArrayList<String> a)
  {
      ArrayList<String> result = new ArrayList<String>();
      for (int i = 0; i < a.size(); i++)
      {
        String word = a.get(i);
        result = insert_before_longer(result, word);
      }
      for (int i = 0; i < a.size(); i++)
      {
          a.set(i,result.get(i));
      }
  }  
  public static void main(String[] args)
  {
    ArrayList<String> a = new ArrayList<String>();
    
    a.add("whale");
    a.add("cat");
    a.add("elephant");
    a.add("donkey");
    a.add("goat");

    System.out.printf("Before: ");
    System.out.println(a);
    sort_by_length2(a);
    System.out.printf("After:  ");
    System.out.println(a);
  }
}