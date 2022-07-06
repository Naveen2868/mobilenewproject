package javaprac;

import org.testng.annotations.Test;

import java.util.*;

public class Abc {

    String format ="acb";
    String text = "abcdfedefhijhji";

    @Test
    public void abc(){

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("one",text);
        map.put("two","naveen");
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

    }

    @Test
    public  void main1() {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(100);
        list1.add(200);
        list1.add(300);
        list1.add(400);
        list1.add(400);
        list1.add(500);
        list1.add(600);
        list1.add(600);
        list1.add(700);
        list1.add(400);
        list1.add(500);
        HashSet<Integer>set = new HashSet<Integer>(list1);
        List<Integer>list2 = new ArrayList<Integer>(set);
        System.out.println("List after removing duplicate elements:");
        for (Object ob: list2)
            System.out.println(ob);
    }

}
