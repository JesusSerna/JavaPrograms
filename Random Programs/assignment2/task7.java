import java.util.Scanner;
public class task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Please enter a string, at least 3 letters long: ");
        String s = in.next();
        int length = s.length();
        String ending = s.substring(length-3,length);
        System.out.printf("The last three letters are %s.",ending);
    }    
}
