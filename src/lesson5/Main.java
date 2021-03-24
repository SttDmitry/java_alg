package lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(fact(5));
//        System.out.println(recFact(5));

//        System.out.println(fibo(47));
//        System.out.println(recFibo(10));

//        System.out.println(triangleNum(5));
//        System.out.println(recTriangleNum(5));

//        System.out.println(multiply(3,8));
//        System.out.println(recMultiply(3,8));

        System.out.println(recExponentiation(5,3));

        ArrayList<Item> arr = new ArrayList<>();

        Item i1 = new Item (3,5);
        Item i2 = new Item (5,10);
        Item i3 = new Item (1,1);
        Item i4 = new Item (1,2);
        Item i5 = new Item (8,4);

        arr.add(i1);
        arr.add(i2);
        arr.add(i3);
        arr.add(i4);
        arr.add(i5);

        System.out.println(recPack(arr,15,0, true));

    }

    public static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static int recFact(int n) {
        if (n == 1) {
            return 1;
        }
        return recFact(n - 1) * n;
    }

    public static long fibo(long n) {
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    public static long recFibo(long n) {
        System.out.print(n + " ");
        if (n < 3) {
            return 1;
        }

        return recFibo(n - 1) + recFibo(n - 2);
    }

    public static long triangleNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long recTriangleNum(int n) {
        if (n == 1) {
            return 1;
        }
        return recTriangleNum(n - 1) + n;
    }

    public static int multiply(int a, int b) {
        int value = 0;
        for (int i = 0; i < b; i++) {
            value += a;
        }
        return value;
    }

    public static int recMultiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return recMultiply(a, b - 1) + a;
    }

    public static long recExponentiation (int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return recExponentiation(a, b-1) * a;
        }
    }

    public static long recPack (ArrayList<Item> arr, int cap, int sum, boolean idCheck){
        if (cap == 0 || !idCheck) {
            return sum;
        }
        boolean checkForSums = false;
        double maxPrice=0;
        int id=-1;
        int tempSum = sum;
        int tempCap = cap;
        for (int j = 0; j < arr.size(); j++) {
            if (sumCheck(arr,j) && cap - arr.get(j).getWeight() >=0) {
                id = j;
//                maxPrice = arr.get(j).getCostRelToWeight()+0.15;
                checkForSums = true;
            }
        }
        if (!checkForSums) {
        for (int i=0; i< arr.size(); i++ ) {
            if ( maxPrice < arr.get(i).getCostRelToWeight() && cap - arr.get(i).getWeight() >=0) {
                maxPrice = arr.get(i).getCostRelToWeight();
                id = i;
            }
        }
        }
        if (id >= 0){
            tempSum += arr.get(id).getCost();
            tempCap -= arr.get(id).getWeight();
            arr.remove(id);
        }
        return recPack(arr,tempCap, tempSum, id >=0);
    }

    public static class Item {
        private int cost;
        private int weight;

        Item (int a, int b) {
            cost = a;
            weight = b;
        }

        public int getWeight() {
            return weight;
        }

        public int getCost() {
            return cost;
        }

        public double getCostRelToWeight () {
            double w = weight;
            return cost/w;
        }
    }

    public static boolean sumCheck (ArrayList<Item> arr, int id) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i != id) {
                sum+=arr.get(i).getCost();
            }
        }
        return arr.get(id).getCost() > sum;
    }

}
