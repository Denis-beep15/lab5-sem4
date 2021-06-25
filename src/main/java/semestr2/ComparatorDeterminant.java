package semestr2;
import java.util.Comparator;

public class ComparatorDeterminant implements Comparator<Matrix> {

    @Override
    public int compare(Matrix firstMatrix, Matrix secondMatrix) {
        return Double.compare(firstMatrix.determinant(), secondMatrix.determinant());
    }
}
