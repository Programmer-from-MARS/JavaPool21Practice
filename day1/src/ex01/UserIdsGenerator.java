package ex01;

public class UserIdsGenerator {
    private static UserIdsGenerator instance = null;
    private int                     ID;

    private UserIdsGenerator() {
        ID = 1;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }

    public int generateId() {
        return ID++;
    }
}
