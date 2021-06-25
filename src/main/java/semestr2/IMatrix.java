package semestr2;

public interface IMatrix {
    double getElemIndex(int index1,int index2);
    void setElemIndex(int index1,int index2, double newElem);
    double determinant();
}
