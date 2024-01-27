package org.example.concept;

public class Main {
    public static void main(String[] args) {
        int num = 3, val;
        val = factorial(num);
        System.out.println("factorial = "+val);
    }
    private static int factorial(int n){
        if(n==0) return 1;
        else return factorial(n-1)*n;
    }
}