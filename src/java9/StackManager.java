package java9;

import java.util.Vector;

interface IStack<T> {
    T pop();
    boolean push(T ob);
}

class MyStack<T> implements IStack<T> {
    Vector<T> v = new Vector();
    @Override
    public T pop() {
        if (v.size() == 0)
            return null;
        else
            return v.remove(v.size()-1);
    }
    @Override
    public boolean push(T ob){
        return v.add(ob);
    }
}

public class StackManager {
    public static void main (String[] args) {
        IStack<Integer> stack = new MyStack<Integer>();
        for (int i=0; i<10; i++) stack.push(i);
        while (true) {
            Integer n = stack.pop();
            if(n == null) break;
            System.out.print(n + " ");
        }
    }
}
