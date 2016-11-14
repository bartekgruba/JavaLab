/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter.view;

import java.io.IOException;
import java.util.Scanner;
import static Converter.model.decToHex.decToHex;
import static Converter.model.hexToDec.hexToDec;

/**
 *  Class that converts given number from dex to hex or the other way.
 * Two arguments are required for proper conversion. First one specifies
 * which conversion is going to be performed 0 - dec2hex, 1 - hex2dec. 
 * If argument is not an integer program will stop
 * and display an instruction telling what to do. Second argument must be
 * integer or string depending on conversion. If any argument is missing
 * IndexOutOfBounds exception will be thrown.
 * @author Bartek GRUBA
 * @version 1.4
 */
public class Converter {

    /**
     * @param convType - determines direction of the conversion
     * @param convNumber - number to be converted
     * @param HexRes - result of dec2hex conversion
     * @param DecRes - result of hex2dec conversion
     * @param mode - determines path of conversion hex2dec or dec2hex
     * @param fArgCorr - tells when to stop checking first argument
     * @param sArgCorr - tells when to stop checking second argument
     * @param checker - tells when to stop checking format of hex number
     */
    
    private static String convType;
    private static String convNumber;
    private static String HexRes;
    private static int mode;
    private static int DecRes;
    private static boolean fArgCorr = true;
    private static boolean sArgCorr = true;
    private static boolean checker = true;
    
    public static void main(String[] args) throws IOException { 
                        
        try{          
            convType = args[0];
            convNumber = args[1];
        }
        catch (IndexOutOfBoundsException exc) {
        System.err.println("IndexOutOfBoundsException: " + exc.getMessage());
        return;
        }
        
        while(fArgCorr){
            try {
                if(convType.equals("0")){
                    mode = 0;
                    fArgCorr = false;
                }
                else if(convType.equals("1")){
                    mode = 1;
                    fArgCorr = false;
                }
                else
                    throw new IOException("First argument"
                            + " must be either 0 or 1!");  
            }
            catch(IOException exc){
                    System.err.println("Caught IOException: "
                            + exc.getMessage());
                    System.out.println("Enter 0 to use"
                            + " decToHex or 1 to use hexToDec");
                    Scanner reader = new Scanner(System.in);
                    convType = reader.next();
                }
        }
        
        while(sArgCorr){
            if(mode == 0){
                try{                    
                    int tmp = Integer.parseInt(convNumber);
                    HexRes = decToHex(tmp);
                    sArgCorr = false;
                }
                catch(NumberFormatException exc){
                    System.err.println("Caught NumberFormatException: "
                            + exc.getMessage());
                    System.out.println("Enter correct number in decimal system"
                            + " to be converted");
                    Scanner reader = new Scanner(System.in);
                    convNumber = reader.next();
                }
                catch(Exception exc){
                    System.err.println("Caught converting exception: "
                            + exc.getMessage());
                }
            }
            else{
                checker = true;
                for( int i = 0 ; i < convNumber.length() ; i++ ){
                    if (Character.digit(convNumber.charAt(i), 16) == -1 ){
                        System.out.println("Entered number does not exist"
                                + " in hex system!");
                        System.out.println("Enter correct number in hexadecimal"
                                + " system to be converted");
                        Scanner reader = new Scanner(System.in);
                        convNumber = reader.next();
                        checker = false;
                    }
                }
                if(checker){
                    DecRes = hexToDec(convNumber);
                    sArgCorr = false;  
                }
            }
        }
        if(mode == 0){
            System.out.println("Decimal number " + convNumber +
                    " equals " + HexRes + " in hex system.");
        }
        else{
            System.out.println("Hex number " + convNumber.toUpperCase() +
                    " equals " + DecRes + " in decimal system.");
        }
    }    
}
