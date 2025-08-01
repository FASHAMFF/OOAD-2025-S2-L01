import java.util.Scanner;
public class Welcome{
  public static void main (String[]args){
    Scanner fName = new Scanner (System.in);
    System.out.println("Enter your First Name");
    String firstName = fName.nextLine(); 
    Scanner lName = new Scanner (System.in);
    System.out.println("Enter your Last Name");
    String lastName = lName.nextLine(); 
    System.out.println("Welcome to the second year " + firstName + " " + lastName);
}
}