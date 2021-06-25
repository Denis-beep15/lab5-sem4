package semestr2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixServiceTest {

    @Test
    public void testArrangeMatrices() {
        Matrix matrix = new Matrix(1,2,3,4,5,6,7,8,9); // 0
        Matrix matr = new Matrix(11,2,13,4); // 18
        DiagMatrix diag = new DiagMatrix(1,1,4,5,0.25); // 5
        UpTriangleMatrix upTM = new UpTriangleMatrix(3, 1,2,3,5,6,9); // 45

        Matrix[] matrArray = new Matrix[] {upTM, diag, matr, matrix};
        Matrix[] expected = new Matrix[] {matrix, diag, matr, upTM};
        Matrix[] actual = MatrixService.arrangeMatrices(matrArray);

        assertArrayEquals(expected, actual);

    }
}