import java.util.Scanner;
public class task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Please enter a string: ");
        String s1 = in.next();
        System.out.printf("Please enter a second string: ");
        String s2 = in.next();
        int length1 = s1.length();
        int length2 = s2.length();
        System.out.printf("The first string has length %d.\n", length1);
        System.out.printf("The second string has length %d.\n", length2);
        System.out.printf("The sum of the two lengths is %d.\n", length1+length2);
    }  
}
