import java.util.Scanner;
public class task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Please specify the number of seconds "
                + "(between 1 and 86,400): ");
        int seconds = in.nextInt();
        if (seconds < 1 || seconds > 86400){
            System.out.printf("Invalid number of seconds, must be between 1 and 86400.\n");
            System.exit(0);
            }
        double hours = seconds / 3600;
        double minutes = (seconds % 3600)/60;
        double seconds_left = ((seconds % 3600)%60);
        System.out.printf("%d seconds correspond to %.0f hours, "
                + "%.0f minutes, and %.0f seconds." ,seconds, hours, minutes, seconds_left);
        
    }
    
}
