package com.cb.graph;

import java.util.ArrayList;


public class Permutation {
    public ArrayList<int[]> combs = new ArrayList<>();

    static void combinationUtil(ArrayList<int[]> combs,int arr[], int data[], int start,
                                int end, int index, int r){
        int[] comb = new int[r];
        int[] combr = new int[r];

        if (index == r){
            for (int j=0;j<r;j++){
                comb[j] = data[j];
                combr[r-j-1] = data[j];
//                System.out.println(r-j-1);
//                System.out.println(data[j]);
            }
            combs.add(comb);
            combs.add(combr);


            return;

        }
        for (int i = start; i <= end && end-i+1 >= r-index; i++){
            data[index] = arr[i];
            combinationUtil(combs,arr, data, i+1, end, index+1, r);
        }


    }


    static void generateCombination(ArrayList<int[]> combs,int arr[], int n, int r){
        int data[] = new int[r];
        combinationUtil(combs,arr, data, 0, n-1, 0,r);
    }

    public static void main(String[] args) {
        ArrayList<int[]> combs = new ArrayList<>();
        int arr [] = {1,2};
        int r =2;
        int n = arr.length;
        generateCombination(combs,arr,n,r);
//        System.out.println(combs.size());
        for (int[] c : combs) {
            System.out.printf("%d \t %d%n",c[0],c[1]);
//            System.out.println(c[0]);
//
//            System.out.printf("p %d d %d%n",c[0],c[0]);
//            System.out.printf("p %d d %d%n",c[0],c[1]);
//            System.out.printf("p %d d %d%n",c[1],c[0]);
//            System.out.printf("p %d d %d%n",c[0],c[1]);
//            System.out.printf("p %d d %d%n",c[1],c[0]);
//            System.out.printf("p %d d %d%n",c[1],c[1]);
//            System.out.printf("d %d d %d%n",c[0],c[1]);
//            System.out.printf("d %d d %d%n",c[1],c[0]);

        }
//        System.out.println(combs.size());
    }
}
