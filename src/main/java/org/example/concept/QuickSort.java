package org.example.concept;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {42, 32, 24, 60, 15};
        QuickSort(a, 0, a.length - 1);
        for(int res:a){
            System.out.print(res+" ");
        }
    }
    private static void QuickSort(int[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        System.out.println("---process call---");
        int pivot = process(a, lo, hi);
        System.out.println("lo = "+lo+" hi : "+ hi+" pivot = " + pivot);
        System.out.println("---process end---");
        QuickSort(a, lo, pivot);
        QuickSort(a, pivot + 1, hi);
    }
    private static int process(int[] a, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];
        while(true) {
            do {
                lo++;
            } while(a[lo] < pivot);
            do {
                hi--;
            } while(a[hi] > pivot && lo <= hi);
            if(lo >= hi) {
                return hi;
            }
            swap(a, lo, hi);

            for(int res:a){
                System.out.print(res+" ");
            }
            System.out.println();
        }

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
