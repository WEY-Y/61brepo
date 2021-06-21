//T是为了多类型任意的名字 需要占位符<>
public class LinkedListDeque<T> {
    private Naked sentinel;
    private int size;
    private Naked sentinelcopy;

    public class Naked {
        private  Naked prev; //类的属性
        private T item;
        private Naked next;
        //构造器
        public Naked(Naked p, T i, Naked n) {
            prev = p;
            item = i;
            next = n;
        }
    }


    public LinkedListDeque() {
        sentinel = new Naked(null, null, null);
        size = 0;
    }
    public LinkedListDeque(T i) {
        sentinel = new Naked(null, null, null);
        sentinel.next = new Naked(null, i, null);
        size = 1;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinelcopy = new Naked(null, null, null);
        Naked a = other.sentinel;
        for (int i = 0; i < other.size; i++) {
            sentinelcopy.prev  = new Naked(sentinelcopy.prev,a.item ,sentinelcopy);
            a = a.next;
        }

    }

    public void addFirst(T item) {
        sentinel.next = new Naked(sentinel, item , sentinel.next);
        size = size + 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Naked(sentinel.prev, item , sentinel);
        size = size + 1;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Naked a = sentinel;
         for (int i = 0; i < size; i++) {
             System.out.println(a.next.item+" ");
             a = a.next;
         }
         System.out.println("换行");
    }


    public T removeFirst() {
        if(size == 0) {
            return null;
        } else {
            T a = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return a;
        }
    }
    public T removeLast() {
        if(size == 0) {
            return null;
        } else {
            T a = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return a;
        }
    }

    public T get(int index) {
        if(size == 0) {
            return null;
        } else {
            Naked a = sentinel;
            for (int i = 0; i < index; i++) {
                a = a.next;
            }
            return a.item;
        }

    }
//    public T getRecursive(int index){//不太会呀
//        if(size == 0){
//            return null;
//        }else if(size == 1){
//            return sentinel.next.item;
//        }
//        return getRecursive(index-1);
//
//    }
}

//    public static void main(String[] args) {
//        LinkedListDeque< > d1 = new LinkedListDeque<>(T) ;
//    }