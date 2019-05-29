import java.util.*;

public class task4
{
  public static ArrayList<Double> array_list_max(ArrayList<Double> a, ArrayList<Double> b)
  {
      ArrayList<Double> result= new ArrayList<Double>();
      if (a.size() != b.size())
      {
          return null;
      }
      for (int i = 0; i < a.size(); i++)
      {
          if (a.get(i) > b.get(i))
          {
              result.add(a.get(i));
          }
          else if (b.get(i) > a.get(i))
          {
              result.add(b.get(i));
          }    
      }
      return result;
  }
  
  public static void print_double_array_list(String name, ArrayList<Double> a)
  {
    System.out.printf("%7s: ", name);
    if (a == null)
    {
      System.out.printf("Null array!\n\n");
      return;
    }
    
    for (int i = 0; i < a.size(); i++)
    {
      System.out.printf("%7.1f", a.get(i));
    }
    System.out.printf("\n");
  }
  
  public static void main(String[] args)
  {
    ArrayList<Double> a = new ArrayList<Double>();
    a.add(3.2);
    a.add(2.1);  
    a.add(5.3);  
    a.add(8.0);  
    a.add(4.9);  
    a.add(5.7);  

    ArrayList<Double> b = new ArrayList<Double>();
    b.add(1.1);
    b.add(2.2);  
    b.add(3.3);  
    b.add(4.4);  
    b.add(5.5);  
    b.add(6.6);  
      
    ArrayList<Double> result = array_list_max(a, b);
    print_double_array_list("a", a);
    print_double_array_list("b", b);
    print_double_array_list("result", result);
  }

}