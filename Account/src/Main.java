public class Main {
    public static void main(String[] args) {
        Account my_account = new Account("Tran Duc Manh", 201946.16);
        System.out.println("Your balance: " + my_account.getBalance());
        my_account.deposit(100000);
        System.out.println("Your balance: " + my_account.getBalance());
        my_account.withdraw(200000);
        System.out.println("Your balance: " + my_account.getBalance());
    }
}
