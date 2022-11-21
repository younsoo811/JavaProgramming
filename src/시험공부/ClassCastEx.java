package 시험공부;

class A{
    int i;
    int j;
}

class B extends A{
    int k;
    int l;
}

public class ClassCastEx {
    public static void main(String[] args){
        A a = new B();
        B b = (B)a;

        if (a instanceof B)
            System.out.print("GO");
        if (b instanceof A)
            System.out.print("STOP");
    }
}
