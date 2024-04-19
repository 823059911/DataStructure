package timingtest;

public class MyLink {
    //链表初始化时有一个为null的头节点
    Node head = null;

    class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
    //增加一个新的结点
    public void addNode(int d) {
        Node newNode = new Node(d);
        //如果单列表为空，则直接将新的节点添加到头节点后面
        if (head == null) {
            head = newNode;
            return;
        }
        //否则创建一个新的节点指向头节点
        Node tmp = head;
        //循环直到节点temp指向单链表的尾节点
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }
    //删除节点
    public boolean deleteNode(int index) {
        //下标小于1或者大于链表长度时属于无效下标，直接返回false
        if (index < 1 || index > length()) {
            return false;
        }
        //下标为1时，直接返回头节点
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        //利用两个节点循环直到找到需要删除的节点，然后修改指针指向实现删除
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    public int length() {
        //循环整个列表，若节点不为空，则长度加1
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public boolean deleteNode11(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        System.out.println("ɾ���ɹ���");
        return true;
    }

    public void printList() {
        //创建一个新的节点指向头节点，循环链表每一个元素
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public Node ReverseIteratively(Node head) {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
        return this.head;
    }

    public Node SearchMid(Node head) {
        Node p = this.head, q = this.head;
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        System.out.println("Mid:" + q.data);
        return q;
    }


    public Node findElem(Node head, int k) {
        if (k < 1 || k > this.length()) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++)// ǰ��k��
            p1 = p1.next;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public Node orderList() {
        Node nextNode = null;
        int tmp = 0;
        Node curNode = head;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    tmp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public void deleteDuplecate(Node head) {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (p.data == q.next.data) {
                    q.next = q.next.next;
                } else
                    q = q.next;
            }
            p = p.next;
        }

    }

    public void printListReversely(Node pListHead) {
        if (pListHead != null) {
            printListReversely(pListHead.next);
            System.out.println("printListReversely:" + pListHead.data);
        }
    }

    public boolean IsLoop(Node head) {
        Node fast = head, slow = head;
        if (fast == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("�������л�");
                return true;
            }
        }
        return !(fast == null || fast.next == null);
    }

    public Node FindLoopPort(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();
    }
}