import java.util.*;

public class Test {
    public static void main(String[] args){
        People p1 = new People("Mark");
        List<People> list = new ArrayList<>();
        list.add(p1);
        System.out.println(list.get(0).getName());
        p1.setName("Mike");
        System.out.println(list.get(0).getName());
        p1 = null;
        System.out.println(list.get(0).getName());
    }
    
}