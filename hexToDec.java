/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter.model;

import static java.lang.Character.isDigit;

/**
 *  Class for converting number from hex system to decimal.
 * @author Bartek GRUBA
 * @version 1.2
 */
public final class hexToDec {
    /**
     * @param str - number in hex represented by string
     * @return converted number
     */    
    public static int hexToDec(String str) {
        str = str.toUpperCase();
        int counter = 0;
        int value = 0;
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
        return value;
    }
}