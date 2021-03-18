package lesson3;


public class Main {
    public static void main(String[] args) {
//        MyStack<String> myStack = new MyStack<>();
//
//        myStack.push("asd");
//        myStack.push("bnm");
//        myStack.push("cdfg");
//        myStack.push("dffghfghfg");
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(myStack.pop());
//        }

//        Expression expression = new Expression("(( [7] + {-8*a} + t ])");
//        System.out.println(expression.checkBracket());

//        MyQueue<Integer> myQueue = new MyQueue<>();
//        for (int i = 0; i < 5; i++) {
//            myQueue.insert(i*10);
//        }
//        System.out.println(myQueue);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.print(myQueue.remove());
//        }
//        System.out.println(myQueue);

//        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>();
//        mpq.insert(5);
//        mpq.insert(1);
//        mpq.insert(3);
//        mpq.insert(4);
//        mpq.insert(7);
//        mpq.insert(2);
//
//        System.out.println(mpq);
//        System.out.println(mpq.remove());
//        System.out.println(mpq);
//        mpq.insert(6);
//        System.out.println(mpq);

        reverseWriting("Hello world!");

        MyDeque<Integer> md = new MyDeque<>();
        md.insertLeft(1);
        md.insertLeft(2);
        md.insertLeft(3);
        md.insertLeft(4);
        md.insertLeft(5);
        System.out.println("\n"+md);
        md.insertRight(6);
        md.insertRight(7);
        md.insertRight(8);
        md.insertRight(9);
        System.out.println(md);

        System.out.println(md.removeLeft());
        System.out.println(md.removeRight());
        System.out.println(md);

    }

    public static void reverseWriting (String str) {
        char[] arr;
        arr = str.toCharArray();
        MyStack<Character> ms = new MyStack<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            ms.push(arr[i]);
        }
        for (int j = ms.size(); j > 0; j--) {
            System.out.print(ms.pop());
        }
    }
}
