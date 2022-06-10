package hello.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class TestClass {
    private String name;
    private int age;

    public static void main(String[] args) {
        TestClass t1 = new TestClass();
        t1.setAge(10);

    }
}


