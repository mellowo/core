package hello.core.testclass;

public class SingletonClassTest {

    private static final SingletonClassTest instance = new SingletonClassTest();

    private SingletonClassTest(){}

    public static SingletonClassTest getInstance() {
        return instance;
    }

}
