package demo1;

import java.util.ArrayList;
import java.util.List;

public class Demo5 {

    static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
    }
}
