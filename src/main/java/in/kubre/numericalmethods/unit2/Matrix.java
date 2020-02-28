package in.kubre.numericalmethods.unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Matrix
 */
public class Matrix<T> {

    private List<List<T>> data;

    public Matrix(List<List<T>> data) {
        this.data = data;
    }

    public T get(int i, int j) {
        return data.get(i).get(j);
    }

    public T set(int i, int j, T d) {
        return data.get(i).set(j, d);
    }

    public int size() {
        return data.size();
    }

    public int rowSize() {
        return data.get(0).size();
    }
}