package util;

import javax.xml.transform.Templates;
import java.util.*;

public class SortedByValMap<K,V>{
    Map<K,Map.Entry<K,V>> map=null;
    TreeSet<Map.Entry<K,V>> set=null;
    public SortedByValMap(Comparator comparator){
        map=new HashMap<K,Map.Entry<K,V>>();
        set=new TreeSet<Map.Entry<K,V>>(comparator);
    }
    public void put(K key,V val){
//        Map.Entry<K, V> entry = Map.entry(key,val);
//        map.put(key,entry);
//        set.add(Map.entry(key, val));
    }
    public void delete(K key){
        Map.Entry<K, V> remove = map.remove(key);
        set.remove(remove);
    }
    public V get(K key){
        return map.get(key).getValue();
    }
    public Map.Entry<K,V> getFirst(){
        return set.first();
    }
    public Map.Entry<K,V> getLast(){
        return set.last();
    }
    public Map.Entry<K,V> pollFirst(){
        Map.Entry<K, V> entry = set.pollFirst();
        map.remove(entry.getKey());
        return entry;
    }
    public Map.Entry<K,V> pollLast(){
        Map.Entry<K, V> entry = set.pollLast();
        map.remove(entry.getKey());
        return entry;
    }
    public int size(){
        return map.size();
    }
    public boolean contain(K key){
        return map.containsKey(key);
    }
}
