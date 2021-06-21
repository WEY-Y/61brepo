package Exercise2;

public class SLList {
    public class IntNode {//IntNode变成了内部类
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;


    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        /* Your Code Here! */
        IntNode last;
        last = first;
        while(last.next!= null){//移动last 指针知道指向空
            last = last.next;
        }
        last.next = new IntNode(x, null);
    }

    /** Returns the number of items in the list using recursion. */
    //递归用的是if 初始条件 然后关联关系
    public int size() {//调用一个新的method
        return size(first);
    }//这个的method的 size 是没有参数的
     // 但是实际上想要计算size 我们想要个带参数的method方法

        /* Your Code Here! */
    private int size(IntNode p){  //新的函数是private的

        if (p.next  == null ){
            return 1;
        }
        return 1 + size(p.next);

    }

}


