package com.company.BinarySearch;

public class Test {
    public static  void foo(int n){
        if(n==0){
            System.out.println(n);
            return;
        }
//        System.out.println(n);
        foo(n-1);
        System.out.println(n);
    }

    public static boolean isPrime(int n) {
        boolean Isprime=true;
        for (int k=2;k<=Math.sqrt(n);k++) {
            if(n%k==0) {
                Isprime= false;
                break;

            }
        }
        return Isprime;
    }

    public static int sumOfSquares(int n) {
        int sum=0;
        for(int i=0;i<n;i++){
            if(Math.sqrt(i)==(int)Math.sqrt(i)){
                sum+=i;
            }
        }
        return sum;
        // Write your solution here
    }
    public static int factorial(int n) {
        int result=1;
        while(n!=0){

            result=result*n;
            n--;
        }
        return result;
    }

    public static int power(int a, int b) {
        int result=1;
        for(int i=0;i<b;i++){
            result=result*a;
        }
        return result;
    }

    public static int min(int[] array) {
        if(array.length==0){
            return 0;
        }
        int min=array[0];
        for(int i=0;i<array.length;i++){
            if(min>array[i]){
                min=array[i];
            }
        }
        return min;
    }

    public static int sum(int[] array) {
        if(array.length==0){
            return 0;
        }
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum;
    }


    public static void swap(int[] array, int i, int j) {
        int c=array[i];
        int d=array[j];
        array[j]=c;
        array[i]=d;
    }

    public static int sum(int[][] array) {
        int sum=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                sum+=array[i][j];
            }
        }
        return sum;
    }

    public static int sumNums(int n) {
        boolean flag=n<=0||(n+=sumNums(n-1))>0;
        return n;

    }

//    public static int sum(int[] array) {
//        if (array.length == 0 || array == null) {
//            return -1;
//        }
//        int s = 0;
//        for (int i = 0; i < array.length; i++) {
//            s += array[i];
//        }
//        return s;
//    }



    public static void main(String[] args) {
//        int n=4;
//        foo(4);
        int x=10;
        int y=3;
        double z=(double)x/(double)y;
        boolean b = (Math.abs(x-y)<0.0001);;//complete the expression
        sumOfSquares(10);
        int []arr={3};

        int [][]arr1={{2,3},{4,5},{1,0}};



        System.out.println(isPrime(4));
        System.out.println((int)Math.sqrt(2)==Math.sqrt(2));
        System.out.println(sumOfSquares(10));
        System.out.println(factorial(4));
        System.out.println(power(3,4));
        System.out.println(min(arr));
        System.out.println(3);
        System.out.println(sumNums(9));
//        swap(arr,0,2);
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.println(arr[i]);
//
//        }
//        System.out.println(sum(arr1));
    }
}
