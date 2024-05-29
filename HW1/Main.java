package HW1;

import HW1.BinaryNumber;

import java.util.Arrays;

//testing file

public class Main {
    public static void main(String[] args){
        System.out.println("constructor test");
        BinaryNumber bn1 = new BinaryNumber(5);
        BinaryNumber bn2 = new BinaryNumber("100011010");

        // print bn1 and bn2
        System.out.println(bn1);
        System.out.println(bn2);

        //test getLength()
        System.out.println(bn1.getLength());
        System.out.println(bn2.getLength());

        //test getDigit
        bn2 = new BinaryNumber("1111");
        System.out.println(bn2.getDigit(0));

        //array test
        //bn1 = new HW1.BinaryNumber("011011");
        //bn2 = new HW1.BinaryNumber("100011");
        //System.out.println(Arrays.toString(bn1.getInnerArray()));

        //test bitShift
        bn2 = new BinaryNumber("1001");
        bn2.bitShift(-1, 4);
        System.out.println("New binary number: " + Arrays.toString(bn2.getInnerArray()));

        //test toDecimal
        bn2 = new BinaryNumber("1111");
        System.out.println("1111 to decimal: " + bn2.toDecimal());

        //test bwor
        bn1 = new BinaryNumber("1010");
        bn2 = new BinaryNumber("1100");
        System.out.println(Arrays.toString(BinaryNumber.bwor(bn1, bn2)));

        //test bwand
        bn1 = new BinaryNumber("1010");
        bn2 = new BinaryNumber("1100");
        System.out.println(Arrays.toString(BinaryNumber.bwand(bn1, bn2)));

        //test add
        BinaryNumber binary1 = new BinaryNumber("1011");
        BinaryNumber binary2 = new BinaryNumber("101");

        System.out.println("Before addition:");
        System.out.println("Binary 1: " + binary1);
        System.out.println("Binary 2: " + binary2);

        binary1.add(binary2);

        System.out.println(binary1);
    }

}
