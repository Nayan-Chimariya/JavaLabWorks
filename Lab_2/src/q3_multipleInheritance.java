interface A {
    default void display() {
        System.out.println("Hello form interface A");
    }
}

interface B extends A {
    default void display() {
        System.out.println("Hello form interface B");
    }
}

interface C extends A {
    default void display() {
        System.out.println("Hello form interface C");
    }
}

class D implements B, C {
    @Override
    public void display() {
        B.super.display();
        C.super.display();
        System.out.println("Hello form Class D");
    }
}

public class q3_multipleInheritance {
    public static void main(String[] args) {
        D obj = new D();
        obj.display();
    }
}
