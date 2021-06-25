package semestr2;

public class DiagMatrix extends Matrix {
    DiagMatrix(int size) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть больше 0");
        } else {
            this.size = size;
            this.matrix = new double[size];
        }
    }

    DiagMatrix(double... set) throws IllegalArgumentException {
        if (set.length <= 0) {
            throw new IllegalArgumentException("Задан неккоректный размер матрицы");
        } else {
            this.size = set.length;
            this.matrix = new double[size];
            System.arraycopy(set, 0, this.matrix, 0, matrix.length);
        }
    }

    @Override
    public double getElemIndex(int index1, int index2) throws IllegalArgumentException {
        if (index1 >= size || index2 >= size || index1 < 0 || index2 < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        return (index1 != index2) ? 0.0 : matrix[index1];
    }

    @Override
    public void setElemIndex(int index1, int index2, double newElem) {
        if (index1 >= size || index2 >= size || index1 < 0 || index2 < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        if (index1 != index2 && newElem != 0) {
            throw new IllegalArgumentException("Нельзя записать ненулевое значение вне главной диагонали");
        } else {
            matrix[index1] = newElem;
            flag = false;
        }
    }

    @Override
    public double determinant() {
        double determinant = 1;
        if (flag) {
            return determinantCache;
        }
        for (double i : matrix) {
            determinant *= i;
        }
        determinantCache = determinant;
        flag = true;
        return determinant;
    }
}
