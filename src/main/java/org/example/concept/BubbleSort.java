package org.example.concept;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        boolean change = false;
        int[] a = {42, 32, 24, 60, 15};
        int size = a.length;
        for(int i = 1; i <= size; i++) {
            change = false;
            for(int j = 0; j < size - i; j++) {
                if(a[j] > a[j + 1]){
                    change = true;
                    a = swap(a, j);
                }
            }
            // swap
            if(!change) {
                System.out.println("i = " + i);
                break; }
        }
        for(int num:a){
            System.out.print(num+" ");
        }
    }
    private static int[] swap(int[] a, int j) {
        int temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
        return a;
    }
}
