package myjunit.useage;

import myjunit.anno.MyAfter;
import myjunit.anno.MyBefore;
import myjunit.anno.MyTest;

/**
 * @desc: 2. 使用注解
 * @author: AarynLu
 * @date: 2024-03-09 20:37
 */
public class DAOTest {
    @MyBefore
    public void init() {
        System.out.println("初始化...");
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }

    @MyTest
    public void testUpdate() {
        System.out.println("update...");
    }
}
