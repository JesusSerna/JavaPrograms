import java.util.Scanner;
public class task4 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter the triangle base: ");
    double base = in.nextInt();
    System.out.printf("Enter the triangle height: ");
    double height = in.nextInt();
    double area = height * base / 2;
    System.out.println(area);
  }
}