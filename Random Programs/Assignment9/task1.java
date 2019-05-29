import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class task1
{
    public static Boolean prime(String number)
  {
    int N = Integer.parseInt(number);
    Boolean N_is_prime= true;
    for (int i = 2; i < N; i++)
    {
      if (N % i == 0)
      {
        N_is_prime = false;
      }
    }
    return N_is_prime;
  }
  public static void check_primes(String input, String outfile)
  {
    
    Boolean prime;
    ArrayList<String> a = new ArrayList<String>();
    File temp = new File(input);
    Scanner input_file;
    try
    {
        input_file = new Scanner(temp);
    }
    catch (Exception e)
    {
        System.out.printf("Failed to open file.\n");
        return;
    }
     String output = outfile;
      PrintWriter out = null;
      try
      {
          out = new PrintWriter(output);
      }
      catch (Exception e)
      {
         System.out.printf("Could not write to file");
         return;
      }
    while (input_file.hasNextLine())
    {
       String number = input_file.nextLine();  
       prime = prime(number);
       if (prime)
      {
          out.printf("%s is prime\r\n", number);
      }
      else
      {
          out.printf("%s is not prime\r\n", number);
      }
    }
    input_file.close();
    out.close();
  }
  public static void main(String[] args)
  {
    check_primes("in1.txt", "out1.txt");
    System.out.printf("Exiting...\n");
  }
}  