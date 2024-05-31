package assn01;

public class Part2 {
    public static void main(String[] args) {
        short sh = Short.MAX_VALUE; // 32,767 = 2^15 - 1
        method2();
    }

    public static void method2() {
        int n2 = 0xABC; // 10 * 256 + 11 * 16 + 12 = 2748
        System.out.println(n2);
        method3();
    }

    public static void method3() {
        int[] a3 = {'a', 'z'}; // = 0x61 = 6 * 16 + 1 = 97, 0x7A = 7 * 16 + 10 = 122
        System.out.println(a3[0] + " " + a3[1]);
    }
}
