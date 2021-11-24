package View;

import transactions.TransactionSystem;
import uses.UserManager;

import java.util.Scanner;

public class textUI {
    public static void main(String[] args){
        UserManager manage = new TransactionSystem();

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println(" Please enter 1 to register, 2 to login, and 0 to exist");
            int option = in.nextInt();
            if (option == 1) {
                System.out.println("Please enter username:");
                in.nextLine();
                String username = in.nextLine();
                System.out.println("Please enter password:");
                String pw = in.nextLine();
                manage.createCustomer(username, pw);
            }

            else if (option == 2) {
                System.out.println("Please enter username:");
                in.nextLine();
                String username = in.nextLine();
                System.out.println("Please enter password:");
                String pw = in.nextLine();
                if (manage.login(username, pw)) {
                    System.out.println("login successful");
            }

        }
    }
}
