package deque;
import java.util.Set;
import java.util.HashSet;

public class ArraySet<T> {
int size;
T[]items;
    public ArraySet() {
        items=(T[])new object[100];
        size=0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i=0;i<size;i++ ){
            if(items[i]!=null&&items[i].equals(x)){
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if(x==null){
            throw new IllegalArgumentException("can't add null");
        }
        if(!contains(x)){
            items[size]=x;
            size++;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}