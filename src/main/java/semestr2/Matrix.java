package semestr2;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    protected double[] matrix;
    protected int size;
    protected double determinantCache;
    protected boolean flag = false;


    Matrix(int size) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть больше 0");
        } else {
            this.size = size;
            matrix = new double[size * size];
        }
    }

    public Matrix(double... set) {
        this.size = (int) Math.sqrt(set.length);
        this.matrix = new double[size * size];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = set[i];
        }
    }

    public double[] getMatrix() {
        return matrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return size == matrix1.size &&
                Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public double getElemIndex(int index1, int index2) throws IllegalArgumentException {
        if (index1 >= size || index2 >= size || index1 < 0 || index2 < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        return matrix[index1 * size + index2];
    }

    @Override
    public void setElemIndex(int index1, int index2, double newElem) {
        if (index1 >= size || index2 >= size || index1 < 0 || index2 < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        matrix[index1 * size + index2] = newElem;
        flag = false;
    }

    @Override
    public double determinant() {
        double maxElem = 0;
        int rowElem = 0;
        double elem = 0;
        double elem1 = 0;
        double determinant = 1;
        int resize = 1;
        boolean check = true;
        if (flag) {
            return determinantCache;
        }
       for (int j = 0; j < size - 1; j++) {
           maxElem = -1000000000;
           for (int i = j; i < size; i++) { // ищем максимальный элемент в столбце
               if (matrix[i * size + j] > maxElem && matrix[i * size + j] != 0) {
                   maxElem = matrix[i * size + j];
                   rowElem = i;
               }
           }
           if (matrix[j * size + j] == 0) {// при необходимости меняем строки местами
               resize *= -resize;
               for (int m = 0; m < size; m++) {
                   elem = matrix[j * size + m];
                   matrix[j * size + m] = matrix[rowElem * size + m];
                   matrix[rowElem * size + m] = elem;
               }
           }
           for (int i = j + 1; i < size; i++) {
               elem1 = 0;
               check = true;
               for (int k = j; k < size; k++) {
                   if (check) {
                       elem1 = matrix[i * size + k];
                       check = false;
                   }
                   matrix[i * size + k] = matrix[i * size + k] - matrix[j * size + k] / matrix[j * size + j] * elem1;
               }
           }
       }
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (i == k) {
                    determinant *= matrix[i * size + k];
                }
            }
        }
        determinantCache = determinant * resize;
        flag = true;
        return determinant * resize;
    }


}
