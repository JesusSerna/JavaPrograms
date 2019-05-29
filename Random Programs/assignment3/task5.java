import java.util.Scanner;
public class task5 {
   public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.printf("Please enter real number N1: ");
    double N1 = in.nextDouble();
    System.out.printf("Please enter real number N2: ");
    double N2 = in.nextDouble();
    System.out.printf("%.6f * %.6f = %.2f\n", N1, N2, N1*N2);
    System.out.printf("%.6f / %.6f = %.2f\n", N1, N2, N1/N2);
    System.out.printf("%.6f raised to the power of %.6f = %.2f\n", N1, N2,
            Math.pow(N1,N2));
    }
    
}
