package com.example.MovilaApplication.Pattern;

import com.example.MovilaApplication.Models.*;

import java.util.ArrayList;
import java.util.List;

public class AdapterToList<T> {

    private T t;

    public AdapterToList(T t) {
        this.t = t;
    }

    public List<T> getListT() {
        List<T> ts = new ArrayList<>();
        ts.add(this.t);
        return ts;
    }

}
