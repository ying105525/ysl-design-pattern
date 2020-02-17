package singleton;

/**
 * Created by Senliang-Ying on 2020/2/16.
 *
 * 懒汉式单例01 （非线程安全的）
 *
 * 饿汉式单例精髓就是延迟加载，当你需要的时候再创建这个类对象。
 *
 * 懒汉式设计模式，有一种叫法：延迟加载
 *
 *
 * 懒汉式单例模式步骤：
 * 		1：构造私有
 * 		2：定义私有静态成员变量，先不初始化
 * 		3：定义公开静态方法，获取本身对象
 * 			有对象就返回已有对象
 * 			没有对象，再去创建
 *
 * 线程安全问题，判断依据：
 * 		1：是否存在多线程	是
 * 		2：是否有共享数据	是
 * 		3：是否存在非原子性操作
 *
 *
 */
public class LPerson01 {


    //  1.私有化构造函数
    private LPerson01(){}

    //  2. 定义私有静态成员变量 ，不初始化
    private static LPerson01 lPerson01;

    //  3.对外获取对象的接口，内部判断是否为空
    public LPerson01 lPerson01Factory(){
        if(lPerson01 == null){
            lPerson01 = new LPerson01();
        }
        return lPerson01;
    }

}
