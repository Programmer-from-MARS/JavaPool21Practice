package ex02;

class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}

public class UsersArrayList implements UsersList{
    User[] usersArray= new User[10];
    private int arraySize = 10;
    private int usersCount = 0;

    public void addUser(User user) {
        if (usersCount == arraySize)
            extendArrayIfNeeded();
        for (int i = 0; i < arraySize; i++)
        {
            if (usersArray[i] == null)
            {
                usersArray[i] = user;
                usersCount++;
                break;
            }
        }
    }

    private void extendArrayIfNeeded() {
        User[] newUsersArray = new User[arraySize * 3 / 2];
        System.arraycopy(usersArray, 0, newUsersArray, 0, arraySize);
        usersArray = newUsersArray;
        arraySize = arraySize * 3 / 2;
    }

    public int getUserCount() {
        return usersCount;
    }

    public User getArrayId(int id) {
        for (int i = 0; i < usersCount; i++)
        {
            if (id == usersArray[i].getID())
                return usersArray[i];
        }
        throw new UserNotFoundException("User ID = " + id + " not found");
    }

    public User getIndex(int index) {
        return usersArray[index];
    }
}
