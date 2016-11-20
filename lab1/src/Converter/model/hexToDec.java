/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter.model;

import static java.lang.Character.isDigit;
import java.util.ArrayList;

/**
 *  Class for converting number from hex system to decimal.
 * @author Bartek GRUBA
 * @version 1.2
 */

public final class hexToDec {
    /**
     * @param str - number in hex represented by string
     * @param counter - number of digits in entered number
     * @param digits - type safe collection of Integer objects
     * @return converted number
     */    
    
    private static int counter = 0;
    private static ArrayList<Integer> digits = new ArrayList<Integer>();
    
    public static int hexToDec(String str) throws NegativeException {
        str = str.toUpperCase();
        counter = 0;
        digits.clear();
        int value = 0;
        if(str.contains("-")){
            throw new NegativeException();
        }
        for (int i = (str.length() - 1); i >= 0; i--) {
            char c = str.charAt(i);           
            if(isDigit(c)){
            value = (int) (value + ((Math.pow(16, counter)) * (c - 48)));
            counter++;
            }
            else{
                switch(c){
                    case 'A':
                        value = (int) (value + ((Math.pow(16, counter)) * 10));
                        counter++;
                        break;
                    case 'B':
                        value = (int) (value + ((Math.pow(16, counter))) * 11);
                        counter++;
                        break;
                    case 'C':
                        value = (int) (value + ((Math.pow(16, counter))) * 12);
                        counter++;
                        break;
                    case 'D':
                        value = (int) (value + ((Math.pow(16, counter))) * 13);
                        counter++;
                        break;
                    case 'E':
                        value = (int) (value + ((Math.pow(16, counter))) * 14);
                        counter++;
                        break;
                    case 'F':
                        value = (int) (value + ((Math.pow(16, counter))) * 15);
                        counter++;
                        break;
                }
            }                        
        }
        for(int i = 1; i <= counter; i++)
            digits.add(i);
        for(Integer I : digits){
            if(I.equals(counter))
                System.out.println("Entered hex number has " + I + " digit(s)");
        }
        return value;
    }
}
