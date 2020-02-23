package singleton;

/**
 * Created by Senliang-Ying on 2020/2/16.
 *
 * 懒汉式单例03
 * 在02的基础上进行了双重检查
 * 特点：似乎解决了之前提到的问题，将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，
 * 只有在instance为null，并创建对象的时候才需要加锁，性能有一定的提升。
 *
 * 但是，由于指令重排序的存在，这样的情况，还是有可能有问题的。看下面的情况：
 * 	在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();语句是分两步执行的。
 *  但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，
 *  然后再去初始化这个Singleton实例。 1.分配空间。2.初始化
 *
 *  这样就可能出错了，我们以A、B两个线程为例：
 *
 * 		a> A、B线程同时进入了第一个if判断
 *
 * 		b> A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
 *
 * 		c> 由于JVM内部的优化机制(指令重排序)，JVM先分配出了一些分配给Singleton实例的空白内存，
 * 	     	并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
 *
 * 		d> B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
 *
 * 		e> 此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
 *
 *
 */
public class LPerson03 {


    //  1.私有化构造函数
    private LPerson03(){}

    //  2. 定义私有静态成员变量 ，不初始化
    private static LPerson03 lPerson03;

    //  3.对外获取对象的接口，内部判断是否为空,双重检查锁，内部加锁
    public  LPerson03 lPerson01Factory(){
        if(lPerson03 == null){
            synchronized(LPerson03.class){
                if(lPerson03 == null)
                    lPerson03 = new LPerson03();
            }
        }
        return lPerson03;
    }

}
