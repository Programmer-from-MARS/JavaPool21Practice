package ex00;

public class User {
    private static int idSetter = 1;
    private String name;
    private final int ID;
    private int balance;

    public  User (String name, int balance) {
        ID = idSetter++;
        this.name = name;
        this.balance = (balance >= 0) ? balance : 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printNewUserInfo() {
        System.out.format("User name: %s balance: %d, ID -> %d\n",
                getName(), getBalance(), getID());
    }
}

