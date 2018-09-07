package chapter7.BaseSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//运行的是一个suite的class
@RunWith(Suite.class)
@Suite.SuiteClasses({
//        前后顺序不同，执行的顺序不同
        Children.class,
        Children2.class
})

public class SuiteOrder {

}
