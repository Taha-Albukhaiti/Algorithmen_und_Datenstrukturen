package datastructure.hashing;

import java.util.List;

public class Entry {
    private int key;
    private Object value;
    protected Entry next;

    public Entry getNext() {
        return next;
    }

    public Entry(int key, Object value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
    public Entry(){
        this.next = null;
    }

    public Object getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }
}
