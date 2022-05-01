public class Account {
    private String Name;
    private double Balance;

    public Account(String name, double balance) {
        this.Name = name;
        this.Balance = balance;
        System.out.println("Account's Name: " + this.Name + ", Balance: " + this.Balance + "$");
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public double getBalance() {
        return this.Balance;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }

    public void deposit(double money) {
        this.Balance += money;
        System.out.println("You deposited " + money + "$");
    }

    public void withdraw(double money) {
        if(this.Balance < money) {
            System.out.println("You don't have enough money to withdraw.");
            return;
        }
        this.Balance -= money;
        System.out.println("You withdrew " + money + "$");
    }
}
