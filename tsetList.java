import java.security.SecureRandom;
import java.util.*;

public class tsetList {
    public static void main(String[] args) {
        Vector<String> all = new Vector<String>();
        all.add("hello");
        all.add("_");
        all.add("world");
        Enumeration<String> enu = all.elements();
//        while (enu.hasMoreElements()){
//            System.out.print(enu.nextElement()+',');
//        }
        hashdmeo1();
    }
    public static void hashdemo(){
        Map<String,String> map  = new HashMap<String, String>();
        map.put("mldn","www.mdldn.cn");
        map.put("tom","hello");
        if(map.containsKey("mldn")){
            System.out.print("cunzai");
        }else {
            System.out.print("no");
        }
        if(map.containsValue("www.mdldn.cn")){
            System.out.print("yes");
        }

    }
    public static void hashdmeo1(){
        Map<Person,String> map = new HashMap<Person,String>();
        map.put(new Person("张三",30),"zhangsan");
        map.put(new Person("李四",30),"lisi");
        map.put(new Person("张三",30),"zangsan");
        Set<Map.Entry<Person,String>> allset = map.entrySet();  //map实例转化为set实例
        Iterator<Map.Entry<Person,String>> iter = allset.iterator(); //实例化一个迭代器
        while (iter.hasNext()) {
            Map.Entry<Person,String> me = iter.next();
            System.out.println(me.getKey()+"->"+me.getValue());
        }
    }
}


// 自定义类
class Person{
    private String name;
    private int age ;
    public  Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object obj){
        // 判断是否是同一对象
        if(this == obj){
            return  true;
        }
        else if (!(obj instanceof Person)){
            return false;
        }
        Person p = (Person)obj;
        if(p.name.equals(this.name)&&p.age==this.age){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()*this.age;       //新hash值
    }
    public String toString(){
        return "姓名"+this.name+"年龄"+this.age;
    }
}
