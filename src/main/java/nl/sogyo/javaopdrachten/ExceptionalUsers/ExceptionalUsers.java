package nl.sogyo.javaopdrachten.ExceptionalUsers;

import java.util.Scanner;

public class ExceptionalUsers {
    static boolean passwordCheckRequirements(String password){
        if (password.matches("^([^0-9]*|[^A-Z]*|[^a-z]*)$")){
            return false;
        } else {
            return true;
        }
    }
    
    static void registerUser(String username, String password) throws Exception {
        if (passwordCheckRequirements(password)){
            // Here you would expect to see some actual registering functionality.
            System.out.println("You are registered as \"" + username + "\".");
        } else {
            // throwException();  // part 4
            // withCatchClause(); // part 5
            tellUserWhatsWrong(); // part 6
        }
    }

    static void throwException() throws Exception{
        throw new Exception();
    }

    static void withCatchClause(){
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try again.");
        } 
    }

    static void tellUserWhatsWrong(){
        System.out.println("The password you entered is invalid. Please try again.");
    }
    
    public static void main(String[] args) throws Exception{
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter a username.");
        String userNameInput = keyboard.nextLine();
        System.out.println("Enter a password that consists of at least one uppercase letter, one lowercase letter and one number.");
        String passwordInput = keyboard.nextLine();
        registerUser(userNameInput, passwordInput);
     }
}
