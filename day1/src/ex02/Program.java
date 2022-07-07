package ex02;

public class Program {
    enum    Operation   {debit, credit};

    public static void main(String[] args) {
	    User Max = new User("Max", 21000);
        User Igor = new User("Igor", 42000);
        User Max2 = new User("MAX", 50);
        User Bob = new User("Bob", 100000);
        UsersArrayList userList = new UsersArrayList();
        userList.addUser(Max);
        userList.addUser(Igor);
        userList.addUser(Max2);
        userList.addUser(Bob);
        for (int i = 0; i < userList.getUserCount(); i++)
            userList.usersArray[i]. printNewUserInfo();
        userList.getIndex(1).printNewUserInfo();
        userList.getArrayId(3).printNewUserInfo();
        try
        {
            userList.getArrayId(6);
        }
        catch (UserNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
