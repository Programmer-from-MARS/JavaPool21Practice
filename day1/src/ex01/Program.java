package ex01;

public class Program {
    enum    Operation   {debit, credit};

    public static void main(String[] args) {
	    User Max = new User("Max", 21000);
        Max.printNewUserInfo();
        User Igor = new User("Igor", 42000);
        Igor.printNewUserInfo();
        User Max2 = new User("MAX", 50);
        Max2.printNewUserInfo();
    }
}
