package mx.wansoft.operators;

public class ByteOperators {
    public static void main(String[] args) {
        int a = 25; // 11001
        int b = a >> 2; // 110
        System.out.println(b); // prints 6

        int a2 = 8; // 1000
        int b2 = a2 << 2; // 100000
        System.out.println(b2); // prints 32
        
        int x = 15; //  1111
        int y = 27; // 11011
        int and = x&y;
        // returns 1 only if in both variables the bit was set to 1
        //        1111
        //       11011
        // 11 -> 01011 
        System.out.println("AND Operator" + and);

        int or = x|y;
        // return 1 if one of the elements was set to one
        //        1111
        //       11011
        // 31 -> 11111
        System.out.println("OR Operator" + or);
        int xor = x^y;
        // return 1 if only one element was set to 1
        //        1111
        //       11011
        // 20 -> 10100
        System.out.println("XOR Operator" + xor);
        int oneComplement = ~x;
        System.out.println("One Complement Operator" + oneComplement);

        int i =0;
        i <<= 1;
        System.out.println(i);
    }
}
