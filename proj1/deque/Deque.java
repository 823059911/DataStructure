package deque;

public interface Deque<T> {
    public void addLast(T item);
    public void addFirst(T item);
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public int size();
    default boolean isEmpty(){
      return size()==0?true:false;
    }
    public void printDeque();
}

