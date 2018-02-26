package rc;

// if you have java 1.5 or above
public class LazyFastSingleton {
    private volatile static LazyFastSingleton instance;

    private LazyFastSingleton() {
    }

    public static LazyFastSingleton instance() {
        // first check
        if (instance == null) {
            synchronized (LazyFastSingleton.class) {
                // second check
                if (instance == null) {
                    instance = new LazyFastSingleton();
                }
            }
        }

        return instance;
    }
}
