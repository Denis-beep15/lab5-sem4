package semestr2;

import java.util.Arrays;

public class MatrixService {
    public static Matrix[] arrangeMatrices(Matrix[] array){
        Arrays.sort(array, new ComparatorDeterminant());
        return array;
    }
}
