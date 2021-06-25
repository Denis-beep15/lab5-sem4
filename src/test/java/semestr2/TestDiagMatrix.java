package semestr2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDiagMatrix {
    @Test
    public void testGetElemIndex() {
        double[] set = {1, 2, 3};
        Matrix testMatrix = new DiagMatrix(set);
        assertEquals(1, testMatrix.getElemIndex(0, 0), 1e-6);
        assertEquals(2, testMatrix.getElemIndex(1, 1), 1e-6);
        assertEquals(0, testMatrix.getElemIndex(0, 1), 1e-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElemIndexException() {
        double[] set = {1, 2, 3};
        Matrix testMatrix = new DiagMatrix(set);
        testMatrix.getElemIndex(5, 5);
        testMatrix.getElemIndex(-2, 0);
    }

    @Test
    public void testSetElemIndex() {
        double[] set = {1, 2, 3, 4};
        Matrix testMatrix = new DiagMatrix(set);
        testMatrix.setElemIndex(1, 1, 9);
        testMatrix.setElemIndex(2, 2, 1);
        assertEquals(9, testMatrix.getElemIndex(1, 1), 1e-6);
        assertEquals(1, testMatrix.getElemIndex(2, 2), 1e-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElemIndexException() {
        double[] set = {1, 2, 3, 4};
        Matrix testMatrix = new DiagMatrix(set);
        testMatrix.setElemIndex(-1, 1, 9);
        testMatrix.setElemIndex(2, 1, 1);
    }

    @Test
    public void testDeterminant() {
        double[] set = {1, 2, 3, 4};
        Matrix testMatrix = new DiagMatrix(set);
        assertEquals(24, testMatrix.determinant(), 1e-6);
    }

    @Test
    public void testDeterminant1() {
        double[] set = {1, 2, 3, 0};
        Matrix testMatrix = new DiagMatrix(set);
        assertEquals(0, testMatrix.determinant(), 1e-6);
    }
}
