import java.util.*;

public class task6
{

  public static ArrayList<Integer> insert_before_larger(ArrayList<Integer> x, int a)
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
    return x;
  }
  public static void sort_array2 (ArrayList<Integer> a)
  {
      ArrayList<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < a.size(); i++)
      {
        int number = a.get(i);
        result = insert_before_larger(result, number);
      }
      for (int i = 0; i < a.size(); i++)
      {
          a.set(i,result.get(i));
      }
  }
  public static void main(String[] args)
  {
    ArrayList<Integer> a = new ArrayList<Integer>();
    
    a.add(40);
    a.add(10);
    a.add(50);
    a.add(20);
    a.add(30);

    System.out.printf("Before: ");
    System.out.println(a);
    sort_array2(a);
    System.out.printf("After:  ");
    System.out.println(a);
  }
}