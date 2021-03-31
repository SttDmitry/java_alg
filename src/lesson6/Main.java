package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(5, "five");
        map.put(4, "four");
        map.put(3, "three");

//        System.out.println(map.minKey());
//        System.out.println(map.maxKey());

//        System.out.println(map.get(3));
//        map.put(3, "tttrrreee");
//        System.out.println(map.get(3));
//
//        map.deleteMin();

//        map.delele(4);
//        System.out.println(map.get(4));
        final int el = 20000;
        MyTreeMap<Integer, Integer> maps[]  = new MyTreeMap[el];
        Random random = new Random();
        int k = 0;
        double p;




        for (int j = 0; j < el; j++) {
            maps[j] = new MyTreeMap<>();
            while (maps[j].height() < 6) {
                int i = random.nextInt(200 + 1) - 100;
                maps[j].put(i,i);
            }
            if (maps[j].isBalanced()) {
                k++;
            }
        }

        System.out.println(k + " is balanced trees");

        p =(double) k / el * 100.0;

        System.out.println(p+" % is balanced");
    }
}
