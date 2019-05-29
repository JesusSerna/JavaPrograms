import java.util.Scanner;
public class task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the rectangle length: ");
        double length = in.nextInt();
        System.out.printf("Enter the rectangle width ");
        double width = in.nextInt();
        double area = length * width;
        double perimeter = 2*(length+width);
        System.out.println(area);
        System.out.println(perimeter);
        
    }
    
}
