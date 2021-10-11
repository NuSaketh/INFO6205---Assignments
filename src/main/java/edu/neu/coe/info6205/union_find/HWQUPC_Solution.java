package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {


    public static int count(int n) {
        int pairCounter = 0;
        UF uf = new UF_HWQUPC(n);

        Random randGenerator = new Random();

        while(uf.components()>1) {
            pairCounter++;
            int a = randGenerator.nextInt(n);
            int b = randGenerator.nextInt(n);
            uf.connect(a, b);
        }

        return pairCounter;


    }

    public static void main(String[] args) {

//		int n = 2000;

        int[] in = {2000,4000,6000,8000,10000};

        for(int i : in) {



            System.out.format("For the given number of objects (n) - [%d], the number of pairs generated are [%d]\n", i , count(i));

        }
    }
}








