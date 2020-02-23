package singleton;

/**
 * Created by Senliang-Ying on 2020/2/16.
 *
 * 懒汉式单例05
 * 通过内部类来实现
 * 特点：线程安全，效率也高，但是可以通过序列化攻击
 * JVM在类加载的时候，是互斥的，所以可以由此保证线程安全问题
 */
public class LPerson05 {


    //  1.私有化构造函数
    private LPerson05(){}

    //  2. 定义静态内部类
    private static class LPerson05Factory{
        private static LPerson05 lPerson05 = new LPerson05();
    }

   //   3. 对外接口提供获取实例的入口。
    public  static LPerson05 getInstance(){
        return LPerson05Factory.lPerson05;
    }

}
