package com.nasuf.jdk8;

/**
 * 测试对象finalization
 */
public class CanReliveObj {

    public static CanReliveObj obj; // 类变量，属于GC Root

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类重写的finalize()方法");
        obj = this;
    }

    public static void main(String[] args) {
        try {
            obj = new CanReliveObj();
            obj = null;
            System.gc();    // 调用垃圾回收器
            System.out.println("第一次 GC");
            // 因为Finalizer线程优先级很低，暂停2秒，以等待它
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }

            obj = null;
            System.gc();
            System.out.println("第二次 GC");
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
