import java.util.Scanner;
public class task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter low: ");
        int low = in.nextInt();
        System.out.printf("Enter high: ");
        int high = in.nextInt();
        while (low <= high)
        {
            if (low%4 != 0)
            {
                System.out.printf("%d\n", low);
                low++;
            }
            else 
                low++;
        }     
    }
}
