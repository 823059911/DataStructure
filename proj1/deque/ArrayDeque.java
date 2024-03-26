package deque;

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public void addLast(T x) {
        if (size == items.length) {
            return;
        }
        items[nextLast]=x;
        size++;
        if(nextLast<items.length-1){
            nextLast++;
        }else {
            nextLast=0;
        }
    }
    public void addFirst(T x) {
        if (size == items.length) {
            return;
        }
        items[nextFirst]=x;
        size++;
        if(nextFirst>0){
            nextFirst--;
        }else {
            nextFirst=items.length-1;
        }
    }
    public T get(int num) {
        return items[num];
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> items = new ArrayDeque<>();
        items.addLast(1);
        items.addLast(2);
        items.addLast(3);
        items.addLast(4);
        items.addLast(5);
        items.addLast(6);
        items.addLast(7);
        items.addLast(8);
        for(int i=0;i<8;i++){
            System.out.println(items.get(i));
        }
    }
}