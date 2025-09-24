import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        list.add("ArrayList");

        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
