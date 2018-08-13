package com.huawei;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		int m = 12;
		int n = 6;
		int w[] = {4, 6, 2, 2, 5, 1};
		int v[] = {8, 10, 6, 3, 7, 2};
		int c[][] = BackPack_Solution(m, n, w, v);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(c[i][j] + "\t");
				if (j == m) {
					System.out.println();
				}
			}
		}
		System.out.println(c[n][m]);
		traceBack(c, w, n, m);
	}
	/**
	 * @param c
	 */
	private static void traceBack(int[][] c, int[] w, int n, int m) {
		int[] x = new int[n + 1];
		for(int i = n; i > 0; i--) {
			if(c[i][m] == c[i-1][m]) {
				x[i] = 0;
			}else {
				x[i] = 1;
				m = m - w[i - 1];
			}
		}
		System.out.println(Arrays.toString(x));
	}

	/**
	 * @param m 表示背包的最大容量
	 * @param n 表示商品个数
	 * @param w 表示商品重量数组
	 * @param p 表示商品价值数组
	 */
	public static int[][] BackPack_Solution(int m, int n, int[] w, int[] v) {
		// c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
		int c[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
			c[i][0] = 0;
		for (int j = 0; j < m + 1; j++)
			c[0][j] = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				// 当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
				// (1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
				// (2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
				if (w[i - 1] <= j) {
					if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + v[i - 1]))
						c[i][j] = c[i - 1][j - w[i - 1]] + v[i - 1];
					else
						c[i][j] = c[i - 1][j];
				} else
					c[i][j] = c[i - 1][j];
			}
		}
		return c;
	}
}