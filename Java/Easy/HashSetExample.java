import java.util.HashSet;

/*
Output:
[null, Java, Hello, World]
 */

public class HashSetExample {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
        set.add("Java");
        set.add("Hello");
        set.add(null);
        set.add(null);

        System.out.println(set);
    }
}
