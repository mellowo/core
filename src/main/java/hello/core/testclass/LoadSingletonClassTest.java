package hello.core.testclass;

public class LoadSingletonClassTest {
    public static void main(String[] args) {

        SingletonClassTest instance = SingletonClassTest.getInstance();

        System.out.println("instance  = " + instance);

        SingletonClassTest instance1 = SingletonClassTest.getInstance();

        System.out.println("instance1 = " + instance1);
    }
}
