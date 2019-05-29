import java.util.Scanner;
public class task4 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.printf("Enter the first noun: ");
        String noun = in.next();
        System.out.printf("Enter the second noun: ");
        String noun2 = in.next();
        System.out.printf("Enter a verb: ");
        String verb = in.next();
        System.out.printf("The %s %s over the %s.\n", noun, verb, noun2);
    }   
}
