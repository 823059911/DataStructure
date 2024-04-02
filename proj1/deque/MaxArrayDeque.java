package deque;
import java.util.Comparator;
public class MaxArrayDeque<T> implements Deque<T>{
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T>c) {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
        this.comparator=c;
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
    public boolean isEmpty () {
        return size == 0 ? true : false;
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
    public T max() {
        if (isEmpty()) {
            return null;
        } else {
            T maxElem = items[nextFirst+1];
            for (T elem : items) {
                if (elem != null && comparator.compare(elem, maxElem) > 0) {
                    maxElem = elem;
                }
            }
            return maxElem;
        }
    }
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        } else {
            T maxElem = items[nextFirst + 1];
            for (T elem : items) {
                if (elem != null && c.compare(elem,maxElem)> 0) {
                    maxElem = elem;
                }
            }
            return maxElem;
        }
    }
    public static void main(String[] args) {
        //这一步我也不知道为啥
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MaxArrayDeque<Integer> items = new MaxArrayDeque<>(comparator);
        items.addFirst(1);
        items.addFirst(2);
        System.out.println(items.max());
    }
}
