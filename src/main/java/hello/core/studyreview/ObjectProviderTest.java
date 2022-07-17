package hello.core.studyreview;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ObjectProviderTest {

    @Autowired
    public ObjectProvider<BeanTest> testObjectProvider;

    void init() {
        BeanTest object = testObjectProvider.getObject();
    }
}
