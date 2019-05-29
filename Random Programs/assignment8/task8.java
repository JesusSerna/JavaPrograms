import java.util.*;

public class task8
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
    
  public static void main(String[] args)
  {
    ArrayList<String> a = new ArrayList<String>();
    
    insert_before_longer(a, "whale");
    System.out.println(a);
    insert_before_longer(a, "cat");
    System.out.println(a);
    insert_before_longer(a, "elephant");
    System.out.println(a);
    insert_before_longer(a, "donkey");
    System.out.println(a);
    insert_before_longer(a, "goat");
    System.out.println(a);
  }
}