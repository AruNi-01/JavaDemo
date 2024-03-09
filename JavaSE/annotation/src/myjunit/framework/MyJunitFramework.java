package myjunit.framework;

import com.sun.tools.javac.Main;
import myjunit.anno.MyAfter;
import myjunit.anno.MyBefore;
import myjunit.anno.MyTest;
import myjunit.useage.DAOTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 3. 读取注解，实现逻辑功能
 * @author: AarynLu
 * @date: 2024-03-09 20:44
 */
public class MyJunitFramework {
    public void run() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 找到/获取 测试类 DAOTest 的字节码文件
        Class<DAOTest> clazz = DAOTest.class;
        Constructor<DAOTest> constructor = clazz.getConstructor();
        DAOTest instance = constructor.newInstance();
        // 2. 获取测试类的所有 public 方法
        Method[] methods = clazz.getMethods();
        // 3. 遍历方法，找到有相关注解的所有方法
        List<Method> myBeforeMethods = new ArrayList<>();
        List<Method> myAfterMethods = new ArrayList<>();
        List<Method> myTestMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                myBeforeMethods.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                myAfterMethods.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                myTestMethods.add(method);
            }
        }

        // 4. 实现逻辑：执行 @MyTest 的方法前先执行 @MyBefore 的方法，最后再执行 @MyAfter 的方法
        for (Method testMethod : myTestMethods) {
            for (Method beforeMethod : myBeforeMethods) {
                beforeMethod.invoke(instance);
            }
            testMethod.invoke(instance);
            for (Method afterMethod : myAfterMethods) {
                afterMethod.invoke(instance);
            }
        }
    }
}
