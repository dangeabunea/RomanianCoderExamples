package rc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EagerSingleton es1 = EagerSingleton.instance();
        EagerSingleton es2 = EagerSingleton.instance();
        boolean areEagerEqual = es1 == es2;
        System.out.println("Eager singleton comparison " + areEagerEqual);

        LazySingleton ls1 = LazySingleton.instance();
        LazySingleton ls2 = LazySingleton.instance();
        boolean areLazyImplEqual = ls1 == ls2;
        System.out.println("Lazy singleton comparison " + areLazyImplEqual);

        // reflection can bypass the standard singleton implementation
        Constructor constructor = EagerSingleton.class.getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
        EagerSingleton es3 = (EagerSingleton) constructor.newInstance();
        boolean areReflectionEqual = es1 == es3;
        System.out.println("Reflection comparison " + areReflectionEqual);

        // enum
        EnumSingleton s1 = EnumSingleton.INSTANCE;
        EnumSingleton s2 = EnumSingleton.INSTANCE;
        boolean enumSingletonEqual = s1 == s2;
        System.out.println("Enum singleton comparison " + enumSingletonEqual);
    }
}
