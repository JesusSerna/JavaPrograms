import java.util.Scanner;
public class task8 {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.printf("Please enter the name of the month: ");
      String month = in.next();
      
      if (month.equals("january") || month.equals("January"))
      {
          System.out.printf("January is the first month.\n");
      }
      else if (month.equals("febuary") || month.equals("Febuary"))
      {
          System.out.printf("Febuary is the second month.\n");
      }
      else if (month.equals("march") || month.equals("March"))
      {
          System.out.printf("March is the third month.\n");
      }
      else if (month.equals("april") || month.equals("April")) 
      {
          System.out.printf("April is the fourth month.\n");
      }
      else if (month.equals("may") || month.equals("May"))
      {
          System.out.printf("May is the fifth month.\n");
      }
      else if (month.equals("june") || month.equals("June"))
      {
          System.out.printf("June is the sixth month.\n");
      }
      else if (month.equals("july") || month.equals("July")) 
      {
          System.out.printf("July is the seventh month.\n");
      }
      else if (month.equals("august") || month.equals("August"))
      {
          System.out.printf("August is the eighth month.\n");
      }
      else if (month.equals("september") || month.equals("September"))
      {
          System.out.printf("September is the ninth month.\n");
      }
      else if (month.equals("october") || month.equals("October"))
      {
          System.out.printf("October if the tenth month\n");
      }
      else if (month.equals("november") || month.equals("November"))
      {
          System.out.printf("November if the eleventh month\n");
      }
      else if (month.equals("december") || month.equals("December"))
      {
          System.out.printf("December if the twelfth month\n");
      }
      else
      {
          System.out.printf("invalid month\n");
          System.exit(0);
      }   
    }
    
}
