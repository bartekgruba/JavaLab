/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class for testing decToHex method, of class decToHex.
 * @author Bartek
 */
public class decToHexTest {
    
    /**
     * two proper values (10 and 16), one incorrect value (-1)
     * and one threshold value (0).
     */
    
    private int param;
    private String expResult, testresult;
    
    @Test
    public void testDecToHex() throws NegativeException{
        try{
            param = 10;
            expResult = "A";
            testresult = decToHex.decToHex(param);
            assertEquals("10 in hex: ", expResult, testresult);
            
            param = 16;
            expResult = "10";
            testresult = decToHex.decToHex(param);
            assertEquals("16 in hex: ", expResult, testresult);
            
            param = 0;
            expResult = "0";
            testresult = decToHex.decToHex(param);
            assertEquals("0 in hex: ", expResult, testresult);
            
            param = -1;
            testresult = decToHex.decToHex(param);
        }
        catch (NegativeException exc){
            fail("Cannot be negative");
        }
    }
}
