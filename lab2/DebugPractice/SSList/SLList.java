package SSList;
/*这个size 已经被该进程使用内存的模式 随时更新 速度更快*/
public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size;

    public SLList() {
        first = null;
        size = 0;
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size += 1;
        if (first == null){
            first = new IntNode(x,null) ;
            return ;
        }
        IntNode p = first;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Crashes when you call addLast on an empty SLList. Fix it. */
    public static void main(String[] args) {
        SLList u = new SLList();
        u.addLast(5);
        u.addFirst( 8 );
        System.out.println(u.size);
    }
}
