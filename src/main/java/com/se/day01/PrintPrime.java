package com.se.day01;

import java.util.Scanner;

/** ����:����һ�������������մ�С�����˳����������������������ӣ���180����������Ϊ2 2 3 3 5 �����һ��������ҲҪ�пո�
	��ϸ������
	�����ӿ�˵����
	public String getResult(long ulDataInput)
	���������
	long ulDataInput�������������
	����ֵ��
	String 
 */
public class PrintPrime {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long num = scanner.nextLong();
		int k = 2;
		while(num>1) {
			if(num%k==0) {
				System.out.println(k+" ");
				num = num / k;
			}else {
				k++;
			}
		}
	}
}
