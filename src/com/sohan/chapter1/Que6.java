package com.sohan.chapter1;

public class Que6 {

	public static void main(String[] args) {
		int[][] mat = createMatrix(6);
		print(mat);
		rotateMatrix(mat);
		print(mat);
	}

	private static void rotateMatrix(int[][] mat) {
		if (mat == null || mat.length == 1) {
			return;
		}
		int len = mat.length;
		int end = len - 1;
		int temp;
		for (int i = 0; i < len / 2; i++) {
			for (int j = i; j < (end - i); j++) {
				temp = mat[i][j];
				mat[i][j] = mat[j][end - i];
				mat[j][end - i] = mat[end - i][end - j];
				mat[end - i][end - j] = mat[end - j][i];
				mat[end - j][i] = temp;
			}
		}
	}

	private static int[][] createMatrix(int size) {
		int cnt = 0;
		int[][] mat = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				mat[i][j] = cnt++;
			}
		}
		return mat;
	}

	private static void print(int[][] mat) {
		int len = mat.length;
		String del = ",";
		System.out.println("-------");
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (j == len - 1) {
					del = "";
				}
				System.out.print(String.format("%3d", mat[i][j]) + del);
			}
			del = ",";
			System.out.println();
		}
	}
}
