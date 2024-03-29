package com.nuc.zp.datastructures.search.dac;

import java.util.Arrays;

/**
 * 背包问题
 */
public class Dp {


    public static void main(String[] args) {
        /**
         * 物品重量
         */
        int[] w = {1, 4, 3};
        /**
         * 物品价值
         */
        int[] val = {1500, 3000, 2000};
        //物品容量
        int m = 4;
        /**
         * 物品个数
         */
        int n = val.length;

        int[][] v = new int[n + 1][m + 1];

        //1、
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        Arrays.fill(v[0], 0);

        show(v);

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (j >= w[i - 1]) {
                    v[i][j] = Math.max(v[i - 1][j], val[i-1] + v[i - 1][j - w[i - 1]]);
                } else {
                    v[i][j] = v[i - 1][j];
                }
            }
        }
        //show
        show(v);
    }

    private static void show(int[][] v){
        System.out.println("-----------");
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.printf(v[i][j] + " ");
            }
            System.out.println();
        }
    }
}
