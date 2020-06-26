package Advent11_2019;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class IntComputer {

    Map<Long, Long> intCode = new HashMap<>();
    ArrayList<Long> outputs = new ArrayList<Long>();

    Long i = 0L;
    Long r = 0L;
    String opCode = null;
    boolean STOP = true;
    boolean cont = true;

    int a = 0;
    int b = 0;
    int c = 0;
    int d_e = 0;

    Long m = 0L;
    Long n = 0L;
    Long temp = 0L;
    Long instruction = 0L;
    Long output = 0L;

    Long zero = 0L;
    Long one = 1L;

    public IntComputer (Map<Long, Long> intCodein) {
        intCode = intCodein;
    }

    public Long compute (Long outputIn) {

        cont = true;
        while (cont) {

            System.out.println("---------------------------------------------------------------------------");


            this.defineOpCode();

            switch (d_e) {
                case 1:

                    this.one();
                    break;
                case 2:

                    this.two();
                    break;
                case 3:

                    this.three(outputIn);
                    break;
                case 4:

                    this.four();
                    cont = false;
                    break;
                case 5:

                    this.five();
                    break;
                case 6:

                    this.six();
                    break;
                case 7:

                    this.seven();
                    break;
                case 8:

                    this.eight();
                    break;
                case 9:

                    this.nine();
                    break;
                case 99:

                    this.nineNine();
                    break;
                default:

                    System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + " , " + intCode.get(i + 2) + " , " + intCode.get(i + 3));
                    System.out.println("sorry something went wrong with your intCode");
                    cont = false;
            }
        }
        return output;
    }

    public void one() {

        //ADDS

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + " , " + intCode.get(i + 2) + " , " + intCode.get(i + 3) + "\ni: " + i);

        if (c == 0) {
            m = intCode.get(intCode.get(i + 1));
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 1) {
            m = intCode.get(i + 1);
        } else if (c == 2) {
            m = intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (b == 0) {
            n = intCode.get(intCode.get(i + 2));
            System.out.println("intCode[intCode[" + i + " + 2]] = " + n);
        } else if (b == 1) {
            n = intCode.get(i + 2);
        } else if (b == 2) {
            n = intCode.get(r + intCode.get(i + 2));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        temp = m + n;
        System.out.println("new value = " + temp);
        if (a == 0) {
            intCode.put(intCode.get(i + 3), temp);
        } else if (a == 2) {
            intCode.put(r + intCode.get(i + 3), temp);
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        i = i + 4;
    }

    public void two() {

        //MULTIPLIES

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + " , " + intCode.get(i + 2) + " , " + intCode.get(i + 3) + "\ni: " + i);

        if (c == 0) {
            m = intCode.get(intCode.get(i + 1));
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 1) {
            m = intCode.get(i + 1);
        } else if (c == 2) {
            m = intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (b == 0) {
            n = intCode.get(intCode.get(i + 2));
            System.out.println("intCode[intCode[" + i + " + 2]] = " + n);
        } else if (b == 1) {
            n = intCode.get(i + 2);
        } else if (b == 2) {
            n = intCode.get(r + intCode.get(i + 2));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        temp = m * n;
        System.out.println("new value = " + temp);
        if (a == 0) {
            intCode.put(intCode.get(i + 3), temp);
        } else if (a == 2) {
            intCode.put(r + intCode.get(i + 3), temp);
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        i = i + 4;
    }

    public void three(Long outputIn) {

        //TAKES INPUT

        Long i2 = i + 1;

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + "\ni: " + i);

        instruction = outputIn;
        System.out.print("intCode[" + i2 + "] was: " + intCode.get(i + 1) + " |");
        if (c == 0) {
            intCode.put(intCode.get(i + 1), instruction);
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 2) {
            intCode.put(r + intCode.get(i + 1), instruction);
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }
        System.out.println(" and is now " + intCode.get(i + 1));

        i = i + 2;
    }

    public void four() {

        //RETURNS OUTPUT

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + "\ni: " + i);

        if (c == 0) {
            output = intCode.get(intCode.get(i + 1));
        } else if (c == 1) {
            output = intCode.get(i + 1);
        } else if (c == 2) {
            output = intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        System.out.println("\n******* OUTPUT: " + output + " *******\n");
        outputs.add(output);

        i = i + 2;
    }

    public void five() {

        //JUMP-IF-TRUE

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + " , " + intCode.get(i + 2) + " , " + intCode.get(i + 3) + "\ni: " + i);

        if (c == 0) {
            m = intCode.get(intCode.get(i + 1));
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 1) {
            m = intCode.get(i + 1);
        } else if (c == 2) {
            m = intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (b == 0) {
            n = intCode.get(intCode.get(i + 2));
            System.out.println("intCode[intCode[" + i + " + 2]] = " + n);
        } else if (b == 1) {
            n = intCode.get(i + 2);
        } else if (b == 2) {
            n = intCode.get(r + intCode.get(i + 2));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (m != 0) {
            i = n;
        } else {
            i = i + 3;
        }
    }

    public void six() {

        //JUMP-IF-FALSE

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + " , " + intCode.get(i + 2) + " , " + intCode.get(i + 3) + "\ni: " + i);

        if (c == 0) {
            m = intCode.get(intCode.get(i + 1));
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 1) {
            m = intCode.get(i + 1);
        } else if (c == 2) {
            m = intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (b == 0) {
            n = intCode.get(intCode.get(i + 2));
            System.out.println("intCode[intCode[" + i + " + 2]] = " + n);
        } else if (b == 1) {
            n = intCode.get(i + 2);
        } else if (b == 2) {
            n = intCode.get(r + intCode.get(i + 2));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (m == 0) {
            i = n;
        } else {
            i = i + 3;
        }
    }

    public void seven() {

        //IS-IT-LESS-THAN

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + " , " + intCode.get(i + 2) + " , " + intCode.get(i + 3) + "\ni: " + i);

        if (c == 0) {
            m = intCode.get(intCode.get(i + 1));
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 1) {
            m = intCode.get(i + 1);
            //added
        } else if (c == 2) {
            m = intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (b == 0) {
            n = intCode.get(intCode.get(i + 2));
            System.out.println("intCode[intCode[" + i + " + 2]] = " + n);
        } else if (b == 1) {
            n = intCode.get(i + 2);
            //added
        } else if (b == 2) {
            n = intCode.get(r + intCode.get(i + 2));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (m < n) {
            temp = one;
        } else {
            temp = zero;
        }

        if (a == 0) {
            intCode.put(intCode.get(i + 3), temp);
        } else if (a == 2) {
            intCode.put(r + intCode.get(i + 3), temp);
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        i = i + 4;
    }

    public void eight() {

        //IS-IT-GREATER-THAN

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + " , " + intCode.get(i + 2) + " , " + intCode.get(i + 3) + "\ni: " + i);

        if (c == 0) {
            m = intCode.get(intCode.get(i + 1));
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 1) {
            m = intCode.get(i + 1);
            //added
        } else if (c == 2) {
            m = intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (b == 0) {
            n = intCode.get(intCode.get(i + 2));
            System.out.println("intCode[intCode[" + i + " + 2]] = " + n);
        } else if (b == 1) {
            n = intCode.get(i + 2);
            //added
        } else if (b == 2) {
            n = intCode.get(r + intCode.get(i + 2));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        if (m == n) {
            temp = one;
        } else {
            temp = zero;
        }

        if (a == 0) {
            intCode.put(intCode.get(i + 3), temp);
        } else if (a == 2) {
            intCode.put(r + intCode.get(i + 3), temp);
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        i = i + 4;
    }

    public void nine() {

        //ADJUSTS RELATIVE BASE

        System.out.println("opCode: " + opCode + " , " + intCode.get(i + 1) + "\ni: " + i);

        if (c == 0) {
            r = r + intCode.get(intCode.get(i + 1));
            System.out.println("intCode[intCode[" + i + " + 1]] = " + m);
        } else if (c == 1) {
            r = r + intCode.get(i + 1);
        } else if (c == 2) {
            r = r + intCode.get(r + intCode.get(i + 1));
        } else {
            System.out.println("Sorry but that is not a valid option.");
        }

        i = i + 2;
    }

    public void nineNine() {

        //HALTS PROGRAM

        STOP = false;
        cont = false;
        System.out.println("\n99 ends program\n=========================================================================\nALL OUTPUTS");
        System.exit(1);
//        for (int z = 0; z < outputs.size(); z++) {
//            System.out.println(z + " | " + outputs.get(z));
//        }
    }

    public void curateOpCode() {
        if (opCode.length() == 5) {
        } else if (opCode.length() == 4) {
            opCode = "0" + opCode;
        } else if (opCode.length() == 3) {
            opCode = "00" + opCode;
        } else if (opCode.length() == 2) {
            opCode = "000" + opCode;
        } else if (opCode.length() == 1) {
            opCode = "0000" + opCode;
        }
    }

    public void defineOpCode() {
        opCode = "" + intCode.get(i);
        this.curateOpCode();
        m = 0L;
        n = 0L;

        a = Integer.parseInt(opCode.substring(0, 1));
        b = Integer.parseInt(opCode.substring(1, 2));
        c = Integer.parseInt(opCode.substring(2, 3));
        d_e = Integer.parseInt(opCode.substring(3, 5));
    }

    public boolean checkIfStopped() {
        return STOP;
    }

    public Long getLong(Long longIn) {
        return intCode.get(longIn);
    }

}
