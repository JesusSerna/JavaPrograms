import java.util.Scanner;
public class task11 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.printf("Please enter a word: ");
        String word = in.next();
        String First_letter = word.substring(0,1);
        First_letter = First_letter.toLowerCase();
        String vowels = "aeiou";
        String consonant = "bcdfghjklmnpqrstvwxyz";
        
        if (vowels.indexOf(First_letter) > -1)
        {
            System.out.printf("%s starts with a vowel.\n", word);
        }
        else if (consonant.indexOf(First_letter) > -1)
        {
            System.out.printf("%s starts with a consonant.\n", word);
        }
        else
        {
            System.out.printf("%s starts with neither a vowel nor a consonant.\n", word);
        }
            
     
        
    }
    
}
