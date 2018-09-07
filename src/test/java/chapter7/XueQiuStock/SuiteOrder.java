package chapter7.XueQiuStock;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//运行的是一个suite的class
@RunWith(Suite.class)
@Suite.SuiteClasses({
//        前后顺序不同，执行的顺序不同
        Stocks.class,
        StocksAddDel.class
})

public class SuiteOrder {

}
