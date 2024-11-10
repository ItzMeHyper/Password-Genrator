package Password_Generator;

import java.util.Scanner;
import java.util.Random;

class PasswordGenerator {
    public String generate_password(int length, boolean hasNumbers, boolean hasSpecialChars) {
        String password = "";
        String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special_chars = "!@#$%^&*_=+-/.?<>)";
        String values = capital + small;
        
        if (hasNumbers) {
            values += numbers;
        }
        
        if (hasSpecialChars) {
            values += special_chars;
        }
        
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            password += values.charAt(random.nextInt(values.length()));
        }
        return password;
    }
}

public class Pswd_Generator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the password: ");
        int length = sc.nextInt();
        
        System.out.print("Do you want numbers in the password? (y/n): ");
        sc.nextLine(); 
        String numbersChoice = sc.nextLine().toLowerCase();
        boolean hasNumbers = numbersChoice.equals("y");

        System.out.print("Do you want special characters in the password? (y/n): ");
        String specialChoice = sc.nextLine().toLowerCase();
        boolean hasSpecialChars = specialChoice.equals("y");

        System.out.print("Enter the number of passwords you want: ");
        int num = sc.nextInt();

        PasswordGenerator Pass = new PasswordGenerator();

        System.out.println("Generated Passwords: ");
        for (int i = 0; i < num; i++) {
            String pwd = Pass.generate_password(length, hasNumbers, hasSpecialChars);

            System.out.println(pwd);
        }

        sc.close();
    }
}
