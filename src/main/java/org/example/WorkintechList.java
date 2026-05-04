package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class WorkintechList<E> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        if(!this.contains(e)){
            return super.add(e);
        }
        return false;
    }

    public void sort() {
        if(this.isEmpty()) return;

        if(this.get(0) instanceof String){
            Collections.sort((ArrayList<String>)this);
        }

        else if(this.get(0) instanceof Integer){
            Collections.sort((ArrayList<Number>)this, (a,b)->Double.compare(a.doubleValue(),b.doubleValue()));
        }
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        if(removed) {
            this.sort();
        }
        return removed;
    }
}
