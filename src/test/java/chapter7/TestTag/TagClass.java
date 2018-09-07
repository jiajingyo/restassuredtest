package chapter7.TestTag;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//基于Categories分组的套件
@RunWith(Categories.class)

//运行带有Prod.class标签的方法,Prod是新创建的
@Categories.IncludeCategory(Prod.class)
//@Categories.IncludeCategory(Children.class)

//不运行带有Stage.class标签的方法,Stage是新创建的
//@Categories.ExcludeCategory(Stage.class)

@Suite.SuiteClasses({
        Children3.class,
        Children.class
})

public class TagClass {

}
