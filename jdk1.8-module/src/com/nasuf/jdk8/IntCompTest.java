package com.nasuf.jdk8;

/**
 * -Xint: 11353ms
 * -Xcomp: 2505ms
 * -Xmixed: 2003ms
 */
public class IntCompTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        testPrimeNumber(1000000);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
    }

    public static void testPrimeNumber(int count) {
        for (int i = 0; i < count; i++) {
            // 计算100以内的指数
            label: for (int j = 2; j < 100; j++) {
                        for (int k = 2; k < Math.sqrt(j); k++) {
                            if (j % k == 0) {
                                continue label;
                            }
                        }
                }
        }
    }

}
