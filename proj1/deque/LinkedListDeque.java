package deque;
public class LinkedListDeque<T>  {
    public GenericNode front;
    public GenericNode back;
    int size;
    public class GenericNode {
        public GenericNode prev;
        public T item;
        public GenericNode next;
        public GenericNode(GenericNode prev, T item, GenericNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    public LinkedListDeque() {
        back = new GenericNode(null, null, null);
        front = new GenericNode(null, null, back);
        back.prev = front;
        size = 0;
    }
    public void addLast(T item) {
        GenericNode newNode = new GenericNode(back.prev, item, back);
        back.prev.next = newNode; // 首先更新现有的最后一个节点的 next 引用
        back.prev = newNode; // 然后更新 back 的 prev 引用
        size++;
    }

    public void addFirst(T item){
        GenericNode newNode=new GenericNode (front,item,front.next);
        front.next.prev=newNode;
        front.next=newNode;
        size++;
    }
    public int size(){
        return size;
    }
    public T removeFirst(){
        //remove之前需要检测是不是空表
        if(front.next==back){
            return null;
        }
        GenericNode removedNode = front.next;
        if(front.next.next!=back) {//检查链表是否只有一个元素
            front.next = front.next.next;
            front.next.prev = front;
        }else{
            back.prev=front;
            front.next=back;
        }
        size--;
        return removedNode.item;
    }
    public T removeLast(){
        //remove之前需要检测是不是空表
        if(front.next==back){
            return null;
        }
        GenericNode removedNode=back.prev;
        if(front.next.next!=back) {
            back.prev= back.prev.prev;
            back.prev.next= back;
        }else{
            back.prev=front;
            front.next=back;
        }
        size--;
        return removedNode.item;
    }
    public boolean isEmpty(){
        return front.next==back&&back.prev==front;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;  // 索引越界
        }
        //get方法不可以影响原链表,应创建一个新的指引变量
        GenericNode sentinel = front.next;
        for (int i = 0; i < index; i++) {
            sentinel = sentinel.next;
        }
        return sentinel.item;
    }
    public void printDeque(){
        //当循环到最后一个元素时，get(i)的i对应的是size-1
        for(int i=0;i<size;i++){
            if(i!=size-1) {
                System.out.print(get(i) + " ");
            }else{
                System.out.print(get(i));
            }
        }
        System.out.println();
    }
}

