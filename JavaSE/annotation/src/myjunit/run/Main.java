package myjunit.run;

import myjunit.framework.MyJunitFramework;

import java.lang.reflect.InvocationTargetException;

/**
 * @desc: 启动入口
 * @author: AarynLu
 * @date: 2024-03-09 21:10
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MyJunitFramework myJunit = new MyJunitFramework();
        myJunit.run();

        /* 输出：
        初始化...
        save...
        销毁...
        初始化...
        update...
        销毁...
         */
    }
}
