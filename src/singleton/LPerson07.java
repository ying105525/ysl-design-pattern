package singleton;

/**
 * Created by Senliang-Ying on 2020/2/16.
 *
 * 懒汉式单例05
 * 枚举方法实现
 * 特点：基本满足所有要求，而且还不容易被攻击。
 *
 */
public enum LPerson07 {
    //    1. 类声明
    LPerson07("枚举单例");

    private String name;

    private LPerson07(String name){
       this.name = name;
    }

    //    2. 类的内部方法
    public void sayHello() {
        System.out.println("这是通过枚举实现的单例");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
