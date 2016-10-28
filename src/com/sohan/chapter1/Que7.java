package com.sohan.chapter1;

public class Que7 {

	public static void main(String[] args) {
		int m = 5, n = 6;
		int[][] mat = createMatrix(m, n, 8);
		print(mat, m, n);
		setZerosUsingBitVector(mat, m, n);
		print(mat, m, n);
		System.out.println("=========");
		mat = createMatrix(m, n, 9);
		print(mat, m, n);
		setZerosUsingIntArray(mat, m, n);
		print(mat, m, n);
	}

	private static void setZerosUsingBitVector(int[][] mat, int m, int n) {
		int row = 0, col = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					row |= 1 << i;
					col |= 1 << j;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((row & (1 << i)) > 0 || (col & (1 << j)) > 0) {
					mat[i][j] = 0;
				}
			}
		}
	}

	private static void setZerosUsingIntArray(int[][] mat, int m, int n) {
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] || cols[j]) {
					mat[i][j] = 0;
				}
			}
		}
	}

	private static int[][] createMatrix(int m, int n, int factor) {
		int element = 0;
		int[][] mat = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				element = (i + j) % factor == 0 ? 0 : 1;
				mat[i][j] = element;
			}
		}
		return mat;
	}

	private static void print(int[][] mat, int m, int n) {
		String del = ",";
		System.out.println("-------");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == n - 1) {
					del = "";
				}
				System.out.print(String.format("%3d", mat[i][j]) + del);
			}
			del = ",";
			System.out.println();
		}
	}

}
