package romannumeralgen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.LimitExceededException;

/**
 *
 * @author Sam Payne
 */
public class Generator implements RomanNumeralGenerator {

    private final Integer NUMBERLIMIT = 3999;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Generator g = new Generator();
            System.out.println(g.getNumeralsFromInput());
            while (startAgain()){
                System.out.println(g.getNumeralsFromInput());
            }
            System.out.println("Execution Finished!");
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } 
    }

    /**
     *
     * @return Number Limit that the program cannot exceed
     */
    public Integer getNUMBERLIMIT() {
        return NUMBERLIMIT;
    }

    private static boolean startAgain() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Again? (Y/N)");
        String startAgain = reader.readLine();
        switch (startAgain) {
            case "Y":
            case "y":
                return true;
            case "N":
            case "n":
                return false;
            default:
                return startAgain();
        }
    }
    
    /**
     *
     * @return Returns a Roman numeral String from an input integer retrieved from input
     * from the system screen
     * @throws IOException
     */
    public String getNumeralsFromInput() throws IOException{
        try {
            return (generate(getUserInput()));
        } catch (NumberFormatException ex) {
            return ("Input Error: " + ex.getMessage() + ". Please ensure you are inputting a valid integer.");
        } catch (LimitExceededException ex) {
            return (ex.getMessage());
        }
    }
    
    private Integer getUserInput() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input the number from 1 to 3999 you would like to be converted into Roman Numerals: ");
        Integer i = Integer.parseInt(reader.readLine());
        return i;
    }
    
    /**
     *
     * @param number
     * @return Generates a Roman Numeral associated with an input integer
     * @throws LimitExceededException
     */
    @Override
    public String generate(int number) throws LimitExceededException{
        // Throw
        if (number>NUMBERLIMIT) throw new LimitExceededException("Input Error: Input number exceeded limit of " + String.valueOf(NUMBERLIMIT));
        if (number<=0) throw new LimitExceededException("Input Error: Input number cannot be smaller than 1");
        
        String num = String.valueOf(number);
        char[] cs = num.toCharArray();
        int len = num.length();
        StringBuilder sb = new StringBuilder();
        
        for (int k = 1; k<len+1; k++){
            
            Integer i = Integer.valueOf(String.valueOf(cs[k-1]));
            switch (len-k){
                case 3:
                    sb.append(parseThousands(i));
                    break;
                case 2:
                    sb.append(parseHundreds(i));
                    break;
                case 1:
                    sb.append(parseTens(i));
                    break;
                default:
                    sb.append(parseOnes(i));
                    break;
            }
            
        }
        return sb.toString();
    }

    private String parseThousands(Integer i){
        String rtn = "M";
        for (int k = 1; k<i; k++){
            rtn += "M";
        }
        return rtn;
    }
    
    private String parseHundreds(Integer i){
        // C, CC, CCC, CD, D, DC, DCC, DCCC, CM, M.
        String rtn;
        switch (i){
            case (1):
                rtn = "C";
                break;
            case (2):
                rtn = "CC";
                break;
            case (3):
                rtn = "CCC";
                break;
            case (4):
                rtn = "CD";
                break;   
            case (5):
                rtn = "D";
                break;
            case (6):
                rtn = "DC";
                break;
            case (7):
                rtn = "DCC";
                break;
            case (8):
                rtn = "DCCC";
                break;
            case (9):
                rtn = "CM";
                break;
            default:
                rtn = "";
        }
        return rtn;
    }
    
    private String parseTens(Integer i){
        String rtn;
        switch (i){
            case (1):
                rtn = "X";
                break;
            case (2):
                rtn = "XX";
                break;
            case (3):
                rtn = "XXX";
                break;
            case (4):
                rtn = "XL";
                break;   
            case (5):
                rtn = "L";
                break;
            case (6):
                rtn = "LX";
                break;
            case (7):
                rtn = "LXX";
                break;
            case (8):
                rtn = "LXXX";
                break;
            case (9):
                rtn = "XC";
                break;
            default:
                rtn = "";
        }
        return rtn;
    }
    
    private String parseOnes(Integer i){
        // I, II, III, IV, V, VI, VII, VIII, IX, X.
        String rtn;
        switch (i){
            case (1):
                rtn = "I";
                break;
            case (2):
                rtn = "II";
                break;
            case (3):
                rtn = "III";
                break;
            case (4):
                rtn = "IV";
                break;   
            case (5):
                rtn = "V";
                break;
            case (6):
                rtn = "VI";
                break;
            case (7):
                rtn = "VII";
                break;
            case (8):
                rtn = "VIII";
                break;
            case (9):
                rtn = "IX";
                break;
            default:
                rtn = "";
        }
        return rtn;
    }
    
}
