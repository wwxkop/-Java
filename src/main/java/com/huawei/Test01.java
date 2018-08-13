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
	 * @param m ��ʾ�������������
	 * @param n ��ʾ��Ʒ����
	 * @param w ��ʾ��Ʒ��������
	 * @param p ��ʾ��Ʒ��ֵ����
	 */
	public static int[][] BackPack_Solution(int m, int n, int[] w, int[] v) {
		// c[i][v]��ʾǰi����Ʒǡ����һ������Ϊm�ı������Ի�õ�����ֵ
		int c[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
			c[i][0] = 0;
		for (int j = 0; j < m + 1; j++)
			c[0][j] = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				// ����ƷΪi������Ϊjʱ�������i��������(w[i-1])С������jʱ��c[i][j]Ϊ�����������֮һ��
				// (1)��Ʒi�����뱳���У�����c[i][j]Ϊc[i-1][j]��ֵ
				// (2)��Ʒi���뱳���У��򱳰�ʣ������Ϊj-w[i-1],����c[i][j]Ϊc[i-1][j-w[i-1]]��ֵ���ϵ�ǰ��Ʒi�ļ�ֵ
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