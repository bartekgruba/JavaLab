/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter.model;

import java.io.IOException;

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
     * @return converted number
     */
    
    private static String result = "";
    private static String signs = "0123456789ABCDEF";
    
    public static String decToHex(int param) throws Exception {
        if(param == 0){
            result = "0";
            throw new Exception("0 in one system equals 0 in other one");
        }
        else{    
            do{
                int tmp = param % 16;
                result = signs.charAt(tmp) + result;
                param = param / 16;
            }while(param > 0);
        }
        return result;
    }
}
