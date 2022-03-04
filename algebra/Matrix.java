package algebra;

import java.util.Random;

/**
 * Matrix class for neural network
 * @author Muti Kara
 * */
public class Matrix {
	Random rand = new Random();
	double[][] matrix;
	int col, row;
	
	public Matrix(int row, int col) {
		matrix = new double[row][col];
		this.col = col;
		this.row = row;		
	}
	
	public Matrix randomize() {
		for(int r = 0; r < row; r++)
			for(int c = 0; c < col; c++)
				matrix[r][c] = Math.abs(rand.nextGaussian() * HyperParameters.RANDOMIZATION);
		return this;
	}
	
	public Matrix createClone() {
		Matrix C = new Matrix(row, col);
		for(int r = 0; r < row; r++) {
			C.matrix[r] = matrix[r].clone();
		}
		return C;
	}
	
	public Matrix getVector(int c) {
		Matrix C = new Matrix(col, 1);
		for(int r = 0; r < C.row; r++) {
			C.matrix[r][0] = matrix[c][r];
		}
		return C;
	}
	
	public Matrix dot(Matrix B) {
		if(this.col != B.row) {
			System.out.println("Matrix dot error. Size Mismatch :" + col + " " + B.row);
			return null;
		}
		Matrix C = new Matrix(this.row, B.col);
		for(int crow = 0; crow < this.row; crow++) {
			for(int ccol = 0; ccol < B.col; ccol++) {
				double c = 0;
				for(int sum = 0; sum < this.col; sum++) {
					c += matrix[crow][sum] * B.matrix[sum][ccol];
				}
				C.matrix[crow][ccol] = c;
			}
		}
		return C;
	}
	
	public Matrix sum(Matrix B) {
		if(!(row == B.row && col == B.col)) {
			System.out.println("Matrix sum error. Size Mismatch.");
			return null;
		}
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				matrix[r][c] += B.matrix[r][c];
			}
		}
		return this;
	}
	
	public double[][] getMatrix() {
		return matrix;
	}

	public void set(int r, int c, double value){
		matrix[r][c] = value;
	}
	
	public double get(int r, int c){
		return matrix[r][c];
	}
	
	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public Matrix sub(Matrix B) {
		if(!(row == B.row && col == B.col)) {
			System.out.println("Matrix sub error. Size Mismatch.");
			return null;
		}
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				matrix[r][c] -= B.matrix[r][c];
			}
		}
		return this;
	}
	
	public Matrix ewProd(Matrix B) {
		if(!(row == B.row && col == B.col)) {
			System.out.println("Matrix exProd error. Size Mismatch.");
		}
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				matrix[r][c] *= B.matrix[r][c];
			}
		}
		return this;
	}
	
	public Matrix sProd(double b) {
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				matrix[r][c] *= b;
			}
		}
		return this;
	}
	
	public Matrix sSum(double b) {
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				matrix[r][c] += b;
			}
		}
		return this;
	}
	
	public Matrix ewDiv(Matrix B) {
		if(!(row == B.row && col == B.col)) {
			System.out.println("Matrix sum error. Size Mismatch.");
			return null;
		}
		Matrix C = new Matrix(row, col);
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				C.matrix[r][c] = matrix[r][c] / B.matrix[r][c];
			}
		}
		return C;
	}
	
	public Matrix T() {
		Matrix C = new Matrix(col, row);
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				C.matrix[c][r] = matrix[r][c];
			}
		}
		return C;
	}
	
	public String toString() {
		String str = "";
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++)
				str += matrix[r][c] + " ";
			str += "\n";
		}
		return str;
	}
	
}
