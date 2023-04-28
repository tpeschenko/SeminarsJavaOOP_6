package org.example.Warehouse;

import java.util.List;

public class View {
    public String viewAll(List<?> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(n -> sb.append(n).append("\n"));
        return sb.toString();
    }
    public String viewOne(Object obj) {
        return obj.toString();
    }
}
