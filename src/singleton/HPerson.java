package singleton;

/**
 * Created by Senliang-Ying on 2020/2/16.
 *
 * 饿汉式单例模式
 * 特点：类初始化的时候就创建好。但是浪费内存空间，
 * 没有线程安全问题，因为JVM在类初始化的时候是互斥的。
 */
public class HPerson {

    //1. 私有化构造方法
    private HPerson(){}


    //2. 静态成员变量
    private static  HPerson hPerson = new HPerson();

    //3. 对外提供方法，获取类对象。（调用私有构造方法，获取类对象）
    public  HPerson gethPerson(){
        return hPerson;
    }

    //4. 普通类方法
    public void sayHelle(){
        System.out.println("我是饿汉式单例");
    }

}
