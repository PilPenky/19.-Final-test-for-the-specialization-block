package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Sorting {
    public ArrayList sortAscending(ArrayList arr) {
        Collections.sort(arr, new Comparator<Date>() {
                    public int compare(final Date object1, final Date object2) {
                        return Long.compare(object1.getTime(), object2.getTime());
                    }
                }
        );
        return arr;
    }
}