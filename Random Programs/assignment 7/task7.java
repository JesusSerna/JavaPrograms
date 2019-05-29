public class task7
{
  
  public static String[] array_merge (String[] a, String[] b)
  {
   String[] result = new String[a.length+b.length];
   for (int i = 0; i < a.length; i++)
   {
       result[i] = a[i]; 
   }
   for (int i = 0; i < b.length; i++)
   {
       result[a.length+i] = b[i];
   }
   return result;
  }
  
  public static void print_string_array(String name, String[] a)
  {
    System.out.printf("%7s: ", name);
    if (a == null)
    {
      System.out.printf("Null array!\n\n");
      return;
    }
    
    for (int i = 0; i < a.length; i++)
    {
      System.out.printf("%12s", a[i]);
    }
    System.out.printf("\n");
  }
  
  public static void main(String[] args)
  {
    String[] a = {"Chicago", "New York", "Dallas"};
    String[] b = {"Berlin", "London", "Paris", "Rome"};
      
    String[] result = array_merge(a, b);
    print_string_array("a", a);
    print_string_array("b", b);
    print_string_array("result", result);
  }
}