import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    @Test
    public void test(){
        LinkedList<String> strings = new LinkedList<>();
        strings.add("A");
        strings.add("B");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
