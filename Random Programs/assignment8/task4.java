import java.util.*;

public class task4
{
  public static void insert_before_larger(ArrayList<Integer> x, int a)
  {
    int position = 0;
    for (int i= 0; i < x.size(); i++)
    {
      int number = x.get(i);
      if (number >= a)
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
  }
public static void main(String[] args)
  {
    ArrayList<Integer> a = new ArrayList<Integer>();
    
    insert_before_larger(a, 40);
    System.out.println(a);
    insert_before_larger(a, 10);
    System.out.println(a);
    insert_before_larger(a, 50);
    System.out.println(a);
    insert_before_larger(a, 20);
    System.out.println(a);
    insert_before_larger(a, 30);
    System.out.println(a);
  }
}