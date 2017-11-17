package com.tt;

/**
 * 1.子类总要调父类无参构造方法，但遇到子父中有重名方法时，则走子方法，因子要覆盖父方法；
 * 2.当进入某个类的构造方法时，会先走成员变量，child调到你类无参构造方法时，会先实例化name=“base”；
 * 3.当父类无参构造方法走完时，因子类的构造方法还没走，所以还没有实例化成员变量name=“dervied”，所以会打null；
 * 4.当你类无参走完后，子类的实例化才开始，即走子类的成员变量name=“dervied”，接着走子类的构造方法；
 * @author liutao
 *liutao2017年6月27日
 */
public class Dervied extends Base {

    private String name = "dervied";

    public Dervied() {
        tellName();
        printName();
    }
    
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }
    
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }

    public static void main(String[] args){
        
        new Dervied();    
    }
}
