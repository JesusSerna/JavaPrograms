import java.util.*;

public class task8
{
  
  public static ArrayList<String> array_list_merge (ArrayList<String> a, ArrayList<String> b)
  {
   ArrayList<String> result = new ArrayList<String>();
   for (int i = 0; i < a.size(); i++)
   {
       result.add(a.get(i)); 
   }
   for (int i = 0; i < b.size(); i++)
   {
       result.add(b.get(i));
   }
   return result;
  }
  
  public static void print_string_array_list(String name, ArrayList<String> a)
  {
    System.out.printf("%7s: ", name);
    if (a == null)
    {
      System.out.printf("Null array!\n\n");
      return;
    }
    
    for (int i = 0; i < a.size(); i++)
    {
      System.out.printf("%12s", a.get(i));
    }
    System.out.printf("\n");
  }
  
  public static void main(String[] args)
  {
    ArrayList<String> a = new ArrayList<String>();
    a.add("Chicago");
    a.add("New York");
    a.add("Dallas");
    
    ArrayList<String> b = new ArrayList<String>();
    b.add("Berlin");
    b.add("London");
    b.add("Paris");
    b.add("Rome");
      
    ArrayList<String> result = array_list_merge(a, b);
    print_string_array_list("a", a);
    print_string_array_list("b", b);
    print_string_array_list("result", result);
  }
}