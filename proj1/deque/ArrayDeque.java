package deque;

public class ArrayDeque<T> implements Deque<T>{
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

    @Override
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
    @Override
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
    @Override
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
    @Override
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

    @Override
    public int size () {
            return size;
        }
    @Override
    public T get(int index) {
        return items[index];
    }
    @Override
    public void printDeque(){
        for(int i = 0;i <items.length;i++){
            if(items[i]!=null){
                System.out.println(items[i]);
            }
        }
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> items = new ArrayDeque<>();
        items.addFirst(1);
        items.addFirst(2);
        items.addFirst(3);
        items.addFirst(4);
        items.printDeque();
        System.out.println(items.isEmpty());
    }
}