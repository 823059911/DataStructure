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
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return removedItem;
    }
    public T removeLast(){
        if (size == 0) {
            return null;
        }
    if(nextLast==0){
        nextLast = items.length-1;
    } else {
        nextLast--;
        }
    T removedItem = items[nextLast];
    items[nextLast]=null;
    size--;
    return removedItem;
    }

    public int size () {
            return size;
        }
        public boolean isEmpty () {
            return size == 0 ? true : false;
        }
    public T get(int num) {
        return items[num];
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> items = new ArrayDeque<>();
        items.addFirst(1);
        items.addFirst(2);
        items.addFirst(3);
        items.addFirst(4);
        items.addLast(5);
        items.removeFirst();
        items.removeLast();
        for(int i=0;i<8;i++){
            System.out.println(items.get(i));
        }
    }
}