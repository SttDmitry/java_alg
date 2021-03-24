package lesson4;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("one");
        mll.insertFirst("two");
        mll.insertFirst("three");

//        System.out.println(mll.removeFirst());
//
//        System.out.println(mll.removeLast());
//        System.out.println(mll.removeLast());
        System.out.println(mll);
//        mll.insertLast("four");
//        System.out.println(mll);

        mll.insert(1, "four");
        System.out.println(mll);
//
        mll.remove("one");
        System.out.println(mll);

//        for (String s : mll) {
//            System.out.println(s);
//        }

        ListIterator<String> li = mll.listiterator();
//        while(li.hasNext()){
//            System.out.println(li.next());
//        }
        while(li.hasPrevious()){
            System.out.println(li.previous());
        }

        System.out.println();
        MyLinkedQueue<Integer> mlq = new MyLinkedQueue<>();
        mlq.insert(1);
        mlq.insert(2);
        mlq.insert(3);
        System.out.println(mlq);
        System.out.println(mlq.remove());
        System.out.println(mlq);
        System.out.println(mlq.peekFront());

    }
}
