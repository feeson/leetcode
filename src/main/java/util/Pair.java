package util;

public class Pair<T1,T2> {
    public T1 key;
    public T2 value;
    Pair(T1 t1,T2 t2){
        key=t1;
        value=t2;
    }
    public T1 getKey(){
        return key;
    }
    public T2 getValue(){
        return value;
    }
    public void setKey(T1 key1){
        key=key1;
    }
    public void setValue(T2 value1){
        value=value1;
    }
}
