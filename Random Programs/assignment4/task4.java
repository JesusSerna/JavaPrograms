import java.util.Scanner;
public class task4 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.printf("Enter an integer N: ");
       int N = in.nextInt();
       int i = 1;
       while (i != N)
           if (i*i+i == N)
           {
            System.out.printf("%d is a holy number in Numerion.\nExiting...\n", N);
            System.exit(0);
           }
           else
               i++;
       System.out.printf("%d is not a holy number in Numerion.\nExiting...\n", N);
          
               
               
    }
    
}
