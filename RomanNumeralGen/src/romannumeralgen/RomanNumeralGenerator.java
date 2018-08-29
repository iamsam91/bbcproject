package romannumeralgen;

import javax.naming.LimitExceededException;

/**
 *
 * @author Sam Payne
 */
public interface RomanNumeralGenerator {
   public String generate(int number) throws LimitExceededException; 
}

