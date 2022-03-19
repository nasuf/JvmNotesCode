package com.nasuf.jdk8;

public class StringIntern1 {
    public static void main(String[] args) {
        /**
         * 此处s3变量记录的地址为new String("11")的地址
         * 而该行代码执行完毕后，字符串常量池中并不存在"11"常量（与JDK版本无关）
         */
        String s3 = new String("1") + new String("1");
        /**
         * 在字符串常量池中生成"11"字符串对象，并赋值给s4变量，与s3指向的地址不同
         */
        String s4 = "11";
        /**
         * 在字符串常量池中查找是否存在字符串对象"11"，因为已经存在，所以不做任何操作
         * 只将该字符串对象地址赋值给s5变量，与s4指向的地址相同
         */
        String s5 = s3.intern();
        System.out.println(s3 == s4);   // false
        System.out.println(s4 == s5);   // true
    }
}
