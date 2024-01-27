package org.example.concept;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {42, 32, 24, 60, 15};
        int size = a.length;
        for(int i = 1; i < size; i++) {
            int target = a[i];

            int j = i - 1;

            while(j >= 0 && target < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = target;
        }

        for(int num:a){
            System.out.print(num+" ");
        }
    }
}
