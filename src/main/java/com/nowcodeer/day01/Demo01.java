package com.nowcodeer.day01;

/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ
 * ���������ж��������Ƿ��и�������
 **/
/*
 * ˼·
 * 
 * ����������ģ������½��������������ֵݼ����������ֵ�����
 * 
 * ��˴����½ǿ�ʼ���ң���Ҫ�������ֱ����½����ִ�ʱ������
 * 
 * Ҫ�������ֱ����½�����Сʱ������
 * 
 */
public class Demo01 {
	public static boolean Find(int target, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(array.length);
		System.out.println(array[1].length);
		System.out.println(Find(7, array));
	}
}
