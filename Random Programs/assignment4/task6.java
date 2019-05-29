import java.util.Scanner;
public class task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("When is the first Sunday this March? ");
        int date = in.nextInt();
        if (date < 1 || date > 7)
        {
            System.out.printf("invalid entry\n");
            System.exit(0);               
         }
        System.out.printf("This March, Sundays fall on:\n");
        while (date < 31)
        {
            System.out.printf("March %d\n", date);
            date = date + 7;
        }
        
    }
    
}
