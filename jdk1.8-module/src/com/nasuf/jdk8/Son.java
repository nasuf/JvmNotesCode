package com.nasuf.jdk8;

class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father普通方法");
    }
}

public class Son extends Father {
    public Son() {
        // invokespecial 非虚方法
        super();
    }

    public Son (int age) {
        // invokespecial 非虚方法
        this();
    }

    /**
     * 静态方法不能被重写，尽管此处的方法签名跟父类方法完全一致
     * @param str
     */
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    public void show() {
        // invokestatic 非虚方法
        showStatic("nasuf");

        // invokestatic 非虚方法
        super.showStatic("good");

        // invokespecial 非虚方法
        showPrivate("hello");

        // invokespecial 非虚方法
        super.showCommon();

        // invokevirtual 因为showFinal()方法为父类的final方法，不能被子类重写，
        // 所以此处依然是非虚方法
        showFinal();
        // 如果明确引用父类的showFinal()方法，则此处对应的字节码指令则变为invokespecial
        // super.showFinal()

        // invokevirtual 因为没有明确指定super.showCommon()，该方法可能被子类重写，在编译期无法确定
        // 因此为虚方法
        showCommon();

        // invokevirtual
        info();

        MethodInterface methodInterface = null;
        // invokeinterface 虚方法，在执行时必须被实现类实现
        methodInterface.methodA();
    }

    public void info() { }

    public void display(Father f) {
        f.showCommon();
    }

    public static void main(String[] args) {
        Son son =  new Son();
        son.show();
    }

}

interface MethodInterface {
    void methodA();
}

