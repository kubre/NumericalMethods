package in.kubre.numericalmethods.utils;

import java.util.List;

/**
 * Matrix
 */
public class Matrix<T> {

    private List<List<T>> data;

    public Matrix(List<List<T>> data) {
        this.data = data;
    }

    public List<T> get(int i) {
        return data.get(i);
    }

    public T get(int i, int j) {
        return data.get(i).get(j);
    }

    public T set(int i, int j, T d) {
        return data.get(i).set(j, d);
    }

    public boolean add(int i, T d) {
        return data.get(i).add(d);
    }

    public boolean add(List<T> l) {
        return data.add(l);
    }

    public int size() {
        return data.size();
    }

    public int columnCount() {
        return data.get(0).size();
    }
}