package mistycalShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Util extends BufferedReader {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


    public String inputChars(int attemptsAllowed) {
        String temp = "";
        if (attemptsAllowed > 0) {
            System.out.println("Input rules: 3-10 symbols(chars and numbers) " + attemptsAllowed + " attempts left");
            try {
                temp = super.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("RUNTIME IN inputChars");
        }
        assert temp != null;
        if (temp.toCharArray().length < 3 || temp.toCharArray().length >= 10) {
            inputChars(--attemptsAllowed);
        }
        return temp;
    }

    //    public int inputNumbers(int attemptsAllowed) {
//        int tempNum = 0;
//        String checkStringLength;
//        if (attemptsAllowed-- <= 0) {
//            System.out.println("Input rules: 1-10 symbols(numbers only) " + attemptsAllowed + " attempts left");
//            try {
//                checkStringLength = super.readLine();
//                if(checkStringLength.toCharArray().length>0){
//                    throw new IllegalArgumentException("Not enough inputs");
//                }
//                tempNum = Integer.parseInt(checkStringLength);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                inputNumbers(attemptsAllowed);
//            }
//        } return tempNum;
//    }
    public int inputNumbers(int attemptsAllowed) {
        try {
            if (attemptsAllowed > 0) {
                System.out.println("Input rules: 1-10 symbols(numbers only) " + attemptsAllowed + " attempts left");
                String checkStringLength = super.readLine();
                if (checkStringLength.toCharArray().length == 0||checkStringLength.toCharArray().length > 10) {
                    throw new IllegalArgumentException("Not enough inputs");
                }
                System.out.println(Integer.parseInt(checkStringLength));
                return Integer.parseInt(checkStringLength);
            }
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return inputNumbers(--attemptsAllowed);
        }
    }


    public Util(Reader in, int sz) {
        super(in, sz);
    }

    public Util(Reader in) {
        super(in);
    }

    public Util() {
        super(new InputStreamReader(System.in));
    }


    public static void main(String[] args) {
        Util test = new Util();
        String str = test.inputChars(3);
        int in = test.inputNumbers(3);
        System.out.println("TEST - "+test.inputNumbers(3));
        System.out.println(str);
        System.out.println(in);
    }


}
