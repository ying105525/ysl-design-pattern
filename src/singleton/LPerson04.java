package singleton;

/**
 * Created by Senliang-Ying on 2020/2/16.
 *
 * 懒汉式单例04
 * 在03的基础上运用了 volatile 修饰静态成员变量，阻止指令重排序。
 * 特点：volatile关键字 基本满足所有要求了。但是还是可以通过反射或者序列化的方式攻击
 *
 */
public class LPerson04 {


    //  1.私有化构造函数
    private LPerson04(){}

    //  2. 定义私有静态成员变量 ，不初始化
    private static  volatile  LPerson04 lPerson04;

    //  3.对外获取对象的接口，内部判断是否为空,双重检查锁，内部加锁
    public synchronized LPerson04 lPerson01Factory(){
        if(lPerson04 == null){
            synchronized(LPerson04.class){
                if(lPerson04 == null)
                    lPerson04 = new LPerson04();
            }
        }
        return lPerson04;
    }

}
