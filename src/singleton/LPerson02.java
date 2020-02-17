package singleton;

/**
 * Created by Senliang-Ying on 2020/2/16.
 *
 * 懒汉式单例02
 * 在01的基础上在方法上进行了加锁
 * 特点：线程安全，但是除首次创建以外，都进行了多余的加锁，性能不好
 *
 */
public class LPerson02 {


    //  1.私有化构造函数
    private LPerson02(){}

    //  2. 定义私有静态成员变量 ，不初始化
    private static LPerson02 lPerson02;

    //  3.对外获取对象的接口，内部判断是否为空,加锁
    public synchronized  LPerson02 lPerson01Factory(){
        if(lPerson02 == null){
            lPerson02 = new LPerson02();
        }
        return lPerson02;
    }

}
