package semestr2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMatrix {
    @Test
    public void testGetElemIndex() {
        double[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix testMatrix = new Matrix(set);
        assertEquals(1, testMatrix.getElemIndex(0, 0),1e-6);
        assertEquals(6, testMatrix.getElemIndex(1, 2),1e-6);
        assertEquals(8, testMatrix.getElemIndex(2, 1),1e-6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetElemIndexException(){
        double[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix testMatrix = new Matrix(set);
        testMatrix.getElemIndex(6,1);
        testMatrix.getElemIndex(-6,1);
        testMatrix.getElemIndex(1,-1);
        testMatrix.getElemIndex(1,6);
    }
    @Test
    public void testSetElemIndex(){
        double[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix testMatrix = new Matrix(set);
        testMatrix.setElemIndex(1,1,9);
        testMatrix.setElemIndex(2,2, 1);
        assertEquals(9, testMatrix.getElemIndex(1, 1),1e-6);
        assertEquals(1, testMatrix.getElemIndex(2, 2),1e-6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetElemIndexException(){
        double[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix testMatrix = new Matrix(set);
        testMatrix.setElemIndex(-1,1,9);
        testMatrix.setElemIndex(2,5, 1);
    }
    @Test
    public void testDeterminant(){
        double[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix testMatrix = new Matrix(set);
        assertEquals(0, testMatrix.determinant(),1e-6);
    }
    @Test
    public void testDeterminant1(){
        double[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 7, 9, 3, 6, 7, 12};
        Matrix testMatrix = new Matrix(set);
        assertEquals(-120, testMatrix.determinant(),1e-6);
    }
    @Test
    public void testDeterminant2(){
        double[] set = {0, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix testMatrix = new Matrix(set);
        assertEquals(3, testMatrix.determinant(),1e-6);
    }


}
