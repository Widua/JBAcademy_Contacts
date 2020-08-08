package Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface CheckCorrectness{
    static boolean checkNumber(String number){
        String digit = "[0-9a-z]{2,}( |-)";
        Pattern correctNumber1 = Pattern.compile("[+]?[0-9a-z]?( |-)?("+digit+ ")*"+"[0-9a-z]{2,}", Pattern.CASE_INSENSITIVE);
        Pattern correctNumber2 = Pattern.compile("[+]?[(][0-9a-z]?[)]( |-)?("+digit+ ")*"+"[0-9a-z]{2,}", Pattern.CASE_INSENSITIVE);
        Pattern correctNumber3 = Pattern.compile("[+]?[0-9a-z]?( |-)?[(][a-z0-9]{2,}[)]( |-)("+digit+")*([0-9a-z]{2,})*", Pattern.CASE_INSENSITIVE);
        Pattern correctNumber4 = Pattern.compile("[+]?[0-9a-z]?( |-)?([a-z0-9]{2,}( |-))*[(][0-9a-z]{2,}[)]( |-)*("+digit+")*([0-9a-z]{2,})*", Pattern.CASE_INSENSITIVE);
        Pattern correctNumber5 = Pattern.compile("[+]?[0-9a-z]",Pattern.CASE_INSENSITIVE);
        Matcher match1 = correctNumber1.matcher(number);
        Matcher match2 = correctNumber2.matcher(number);
        Matcher match3 = correctNumber3.matcher(number);
        Matcher match4 = correctNumber4.matcher(number);
        Matcher match5 = correctNumber5.matcher(number);

        if (match1.matches() || match2.matches() || match3.matches() || match4.matches() || match5.matches() ){
            return true;
        }else {
            return false;
        }

    }

    static boolean checkDate(String date){
        Pattern pattern = Pattern.compile("[0-9]{4}-[1-9][0-2]*-[0-9]{1,2}");
        Matcher match = pattern.matcher(date);
        if (match.matches()){
            return true;
        }else {
            return false;
        }
    }
}
