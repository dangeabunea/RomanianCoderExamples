package rc;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    // lazy singleton
    public synchronized static LazySingleton instance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
