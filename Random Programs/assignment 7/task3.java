public class task3
{
  public static double[] array_max(double [] a, double[] b)
  {
      double[] result= new double[a.length];
      if (a.length != b.length)
      {
          return null;
      }
      for (int i = 0; i < a.length; i++)
      {
          if (a[i] > b[i])
          {
              result[i]= a[i];
          }
          else if (b[i] > a[i])
          {
              result[i] = b[i];
          }    
      }
      return result;
  }  

  public static void print_double_array(String name, double[] a)
  {
    System.out.printf("%7s: ", name);
    if (a == null)
    {
      System.out.printf("Null array!\n\n");
      return;
    }
    
    for (int i = 0; i < a.length; i++)
    {
      System.out.printf("%7.1f", a[i]);
    }
    System.out.printf("\n");
  }

  public static void main(String[] args)
  {
    double[] a = {3.2, 2.1, 5.3, 8.0, 4.9, 5.7};
    double[] b = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
      
    double[] result = array_max(a, b);
    print_double_array("a", a);
    print_double_array("b", b);
    print_double_array("result", result);
  }
}

