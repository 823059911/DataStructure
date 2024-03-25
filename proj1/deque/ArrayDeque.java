package deque;

public class ArrayDeque<T> {
    private int size = 8;
    private T[] items;
public ArrayDeque(){
    T[]items=(T[]) new Object[8];
}
    public class ArrayNode {
        int nextFirst = 3;
        int nextLast = 4;

        //创建一个可以track的节点
        //当指针到达数组末尾时，需要重置指针指向数组开头。
        public void addLast(T x) {
            //先检测arraydeque是否已经满了
            if (items.length == size) {
                resize();
            }
            if (nextLast <= size) {
                items[nextLast] = x;
                nextLast++;
            } else {//因为array是loop的，所以首尾相连，当最后一个位置也填充了元素，下一个元素将会出现在最前的位置
                nextLast = 0;
                items[0] = x;
                nextLast++;
            }
        }


        public void addFirst(T x) {
            //先检测arraydeque是否已经满了
            if (items.length == size) {
                resize();
            }
            if (nextFirst >= 0) {
                items[nextFirst] = x;
                nextFirst--;
            } else {//因为array是loop的，所以首尾相连，当第一个位置也填充了元素，下一个元素将会出现在最后的位置
                nextFirst = size;
                items[size] = x;
                nextFirst--;
            }
        }

        public void resize() {
            T[] newItems = (T[]) new Object[size * 2];
            int size = 0;
            for (T item : items) {
                newItems[size] = item;
                size++;
            }
        }

        public T getLast() {
            if (items == null || size == 0) {
                return null;
            }
            return items[nextLast - 1];
        }

        public T getFirst() {
            if (items == null || size == 0) {
                return null;
            }
            return items[nextFirst + 1];
        }

        public T get(int i) {//索引为i的元素
            return items[i];
        }

        public int size() {
            return size;
        }

        public T removeLast() {
            T removed;
            if (items == null || size == 0) {
                return null;
            } else {
                removed = getLast();
                size--;
                //删除元素后需要更新指针位置
                nextLast--;
            }
            return removed;
        }

        public T removeFirst() {
            T removed;
            if (items == null || size == 0) {
                return null;
            } else {
                removed = getFirst();
                size--;
                //删除元素后需要更新指针位置
                nextFirst++;
            }
            return removed;
        }
    }
}




