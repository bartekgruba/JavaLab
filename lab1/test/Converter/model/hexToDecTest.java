/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartek
 */
public class hexToDecTest {

    /**
     * Test of hexToDec method, of class hexToDec.
     */
    
    private String param;
    private int expResult, testresult;
    @Test
    public void testHexToDec() {
        try{
            param = "FF";
            expResult = 255;
            testresult = hexToDec.hexToDec(param);
            assertEquals("FF in dec: ", expResult, testresult);
            
            param = "F1";
            expResult = 241;
            testresult = hexToDec.hexToDec(param);
            assertEquals("F1 in dec: ", expResult, testresult);
            
            param = "0";
            expResult = 0;
            testresult = hexToDec.hexToDec(param);
            assertEquals("0 in dec: ", expResult, testresult);
            
            param = "-1";
            testresult = hexToDec.hexToDec(param);
        }
        catch (NegativeException exc){
            fail("Cannot be negative");
        }
    }
    
}
