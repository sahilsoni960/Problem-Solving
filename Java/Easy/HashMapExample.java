import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "Hello");
        map.put(1, "World");
        map.put(3, "Java");
        map.put(null, null);

        System.out.println(map);
        System.out.println(map.get(2));
    }
}
