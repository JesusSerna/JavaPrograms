public class task10
{
  public static double matrix_region_average(double[][]a, int top, int bottom, int left, int right)
  {
    double result = 0;
    int counter = 0;
    for (int i = top; i <= bottom; i++)
    {
      for (int j = left; j <= right; j++)
      {
        result = result + a[i][j];
        counter++;
      }
    }
    result = result/counter;
   return result; 
  }
  public static void print_double_matrix(String name, double[][] a)
  {
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
                     {8.0, 4.9, 5.7},
                     {18.0, 14.9, 15.7},
                     {28.0, 24.9, 25.7},
                     {38.0, 34.9, 35.7} };
      
    print_double_matrix("a", a);
    double result = matrix_region_average(a, 0, 3, 1, 2);
    System.out.printf("matrix_region_average(a, 0, 3, 1, 2) returned %.2f.\n", result);
    result = matrix_region_average(a, 1, 4, 0, 1);
    System.out.printf("matrix_region_average(a, 1, 4, 0, 1) returned %.2f.\n", result);
  }
}