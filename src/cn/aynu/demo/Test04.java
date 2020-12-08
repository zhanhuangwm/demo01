package cn.aynu.demo;

public class Test04 {
    //==与equals()方法的判断
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = s1;
        String s5 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println("No1: " + (s1 == s5));//true
        System.out.println("No2: " + (s1.equals(s5)));//true
        System.out.println("No3: " + (s1 == s2));//true
        System.out.println("No4: " + s1 == s2);//false
        System.out.println("No5: " + s1.equals(s2));//true
        System.out.println("No6: " + (s3 == s4));//false
        System.out.println("No7: " + (s1.equals(s4)));//true
    }
}
