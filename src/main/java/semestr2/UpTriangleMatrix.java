package semestr2;

public class UpTriangleMatrix extends Matrix {
    UpTriangleMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть больше 0");
        }
        this.size = size;
        this.matrix = new double[(size * size + size) / 2];

    }

    UpTriangleMatrix(int size, double... set) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("Задан неккоректный размер матрицы");
        }
        this.size = size;
        this.matrix = new double[(size * size + size) / 2];
        this.matrix = set;
    }

    @Override
    public double getElemIndex(int index1, int index2) {
        if (index1 >= size || index2 >= size || index1 < 0 || index2 < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        if (index1 > index2) {
            return 0.0;
        } else {
            int k = 0;
            for (int j = 1; j <= index1; j++) {
                k += j;
            }
            return matrix[size * index1 + index2 - k];
        }
    }

    @Override
    public void setElemIndex(int index1, int index2, double newElem) {
        if (index1 >= size || index2 >= size || index1 < 0 || index2 < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        if (index1 > index2 && newElem != 0) {
            throw new IllegalArgumentException("Нельзя записать ненулевое значение под главной диагональю");
        } else {
            matrix[(size - index1) * index1 + index2] = newElem;
            flag = false;
        }
    }

    @Override
    public double determinant() {
        int k = 0;
        double determinant = 1;
        if (flag) {
            return determinantCache;
        }
        for (int i = 0; i < size; i++) {
            determinant *= getElemIndex(i,i);
        }
        determinantCache = determinant;
        flag = true;
        return determinant;
    }
}
