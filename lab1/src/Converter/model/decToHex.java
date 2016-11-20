/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter.model;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class converting number from dec system to hex. Required int as parameter.
 * @author Bartek GRUBA
 * @version 1.1
 */
public final class decToHex {
    /**
     * @param param - number to be converted to hex
     * @param result - contains result that will be returned
     * @param signs - characters eligible in hex
     * @param counter - number of digits in entered number
     * @param digits - personal generic type
     * @return converted number
     */
    
    private static String result = "";
    private static String signs = "0123456789ABCDEF";
    private static int counter = 0;
    private static ArrayList<Integer> digits = new ArrayList<Integer>();
    
    public static String decToHex(int param) throws NegativeException {
        result = "";
        counter = 0;
        digits.clear();
        if(param < 0){
            throw new NegativeException();
        }
        else if(param == 0){
            result = "0";
            System.out.println("0 in one system equals 0 in other one");
        }
        else{ 
            do{
                int tmp = param % 16;
                result = signs.charAt(tmp) + result;
                param = param / 16;
                counter++;
            }while(param > 0);
            for(int i = 1; i <= counter; i++)
                digits.add(i);
            for(Integer I : digits){
                if(I.equals(counter))
                    System.out.println("Converted hex has " + I + " digit(s)");
            }
        }
        return result;
    }
}
