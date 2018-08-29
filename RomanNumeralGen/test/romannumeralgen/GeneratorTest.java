package romannumeralgen;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.LimitExceededException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam Payne
 */
public class GeneratorTest {
    
    public GeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

/**
     * Test of generate method, of class Generator.
     */
    @Test
    public void testGenerateSingleDigit() {
        try {
            System.out.println("Test generate within 1 to 9");
            int number = 3;
            Generator instance = new Generator();
            String expResult = "III";
            String result = instance.generate(number);
            assertEquals(expResult, result);
            
            number = 7;
            expResult = "VII";
            result = instance.generate(number);
            assertEquals(expResult, result);
            
        } catch (LimitExceededException ex) {
            Logger.getLogger(GeneratorTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    
    @Test
    public void testGenerateDoubleDigit() {
        try {
            System.out.println("Test generate in tens");
            int number = 87;
            Generator instance = new Generator();
            String expResult = "LXXXVII";
            String result = instance.generate(number);
            assertEquals(expResult, result);
            
            number = 34;
            expResult = "XXXIV";
            result = instance.generate(number);
            assertEquals(expResult, result);
            
            number = 60;
            expResult = "LX";
            result = instance.generate(number);
            assertEquals(expResult, result);
            
        } catch (LimitExceededException ex) {
            Logger.getLogger(GeneratorTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
 
    @Test
    public void testGeneratThreeDigit() {
        try {
            System.out.println("Test generate in hundreds");
            int number = 746;
            Generator instance = new Generator();
            String expResult = "DCCXLVI";
            String result = instance.generate(number);
            assertEquals(expResult, result);
            
            number = 323;
            expResult = "CCCXXIII";
            result = instance.generate(number);
            assertEquals(expResult, result);
            
            number = 600;
            expResult = "DC";
            result = instance.generate(number);
            assertEquals(expResult, result);
            
        } catch (LimitExceededException ex) {
            Logger.getLogger(GeneratorTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    
    @Test
    public void testGenerateFourDigit() {
        try {
            System.out.println("Test generate in thousands");
            int number = 3768;
            Generator instance = new Generator();
            String expResult = "MMMDCCLXVIII";
            String result = instance.generate(number);
            assertEquals(expResult, result);
            
            number = 1434;
            expResult = "MCDXXXIV";
            result = instance.generate(number);
            assertEquals(expResult, result);
            
            number = 2000;
            expResult = "MM";
            result = instance.generate(number);
            assertEquals(expResult, result);
            
        } catch (LimitExceededException ex) {
            Logger.getLogger(GeneratorTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    
    @Test
    public void testGenerateExceedsLimit() {
        try {
            System.out.println("Test exceeds limits");
            Generator g = new Generator();
            int number = g.getNUMBERLIMIT() + 1;
            String result = g.generate(number);
            
            number = 0;
            result = g.generate(number);
            
            number = -1;
            result = g.generate(number);
            
            assertTrue(false);
        } catch (LimitExceededException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testGenerateMax() {
        try {
            System.out.println("Test generate 3999");
            Generator instance = new Generator();
            int number = instance.getNUMBERLIMIT();
            String expResult = "MMMCMXCIX";
            String result = instance.generate(number);
            assertEquals(expResult, result);
        } catch (LimitExceededException ex) {
            Logger.getLogger(GeneratorTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    
}
