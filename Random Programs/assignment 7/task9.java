public class task9
{
  public static double[][] matrix_min(double[][] a, double[][] b)
  {
    double [][] result = new double[a.length][];
    
    for (int i = 0; i < a.length; i++)
    {
      if (b.length != a.length) 
      {
          return null;  
      }
      else if (b[i].length != a[i].length)
      {
          return null;
      }  
    }
        
    for (int i = 0; i < a.length; i++)
    {
        result[i] = new double[a[i].length];

        for (int j = 0; j < a[i].length; j++)
        {
            if (a[i][j] < b[i][j])
            {
             result [i][j] = a[i][j]; 
            }
            
            if (b[i][j] < a[i][j])
            {
             result [i][j] = b[i][j]; 
            }
        }
            
    }
    return result;
  }
  public static void print_double_matrix(String name, double[][] a)
  {
    if (a == null)
    {
      System.out.printf("%s: null\n", name);    
      return;
    }
    System.out.printf("%s:\n", name);    
    for (int i = 0; i < a.length; i++)
    {
      for (int j = 0; j < a[i].length; j++)
      {
        System.out.printf("%7.1f", a[i][j]);
      }
      System.out.printf("\n");
    }
    System.out.printf("\n");
  }
  
  
  public static void main(String[] args)
  {
    double[][] a = { {3.2, 2.1, 5.3},
                     {8.0, 4.9, 5.7} };
    double[][] b = { {1.1, 2.2, 3.3}, 
                     {4.4, 5.5, 6.6} };
      
    double[][] result = matrix_min(a, b);
    print_double_matrix("a", a);
    print_double_matrix("b", b);
    print_double_matrix("result", result);
  }
}