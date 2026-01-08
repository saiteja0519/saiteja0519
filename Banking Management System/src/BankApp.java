import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        while (true) {
            System.out.println("\n--- BANKING MANAGEMENT SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    dao.createAccount(name, bal);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int acc1 = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amt1 = sc.nextDouble();
                    dao.deposit(acc1, amt1);
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    int acc2 = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amt2 = sc.nextDouble();
                    dao.withdraw(acc2, amt2);
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    int acc3 = sc.nextInt();
                    dao.checkBalance(acc3);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}
