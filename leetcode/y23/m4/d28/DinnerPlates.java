package y23.m4.d28;

import java.util.*;

class DinnerPlates {
    List<Stack<Integer>> Cap=new ArrayList<>();
    int capacity;
    TreeSet<Integer> underfilled=new TreeSet<>();
    TreeSet<Integer> underempty=new TreeSet<>();
    public DinnerPlates(int capacity) {
        this.capacity=capacity;
        Cap.add(new Stack<>());
        underfilled.add(0);
        underempty.add(0);
    }

    public void push(int val) {
        if (underfilled.size()==0){
            underfilled.add(Cap.size());
            Cap.add(new Stack<>());
        }
        Integer first = underfilled.first();
        Stack<Integer> stack = Cap.get(first);
        if (stack.size()==capacity-1){
            underfilled.remove(first);
        }
        if (stack.size()==0){
            underempty.add(first);
        }
        stack.push(val);
    }

    public int pop () {
        if (underempty.size()==0)
            return -1;
        Integer last = underempty.last();
        return fun1(last);
    }

    public int popAtStack(int index) {
        if (underempty.contains(index)){
            return fun1(index);
        }else {
            return -1;
        }
    }

    private int fun1(int index) {
        Stack<Integer> stack = Cap.get(index);
        if (stack.size()==1){
            underempty.remove(index);
        }
        if (stack.size()==capacity){
            underfilled.add(index);
        }
        return stack.pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */