package za.ac.cput.util;

import com.fasterxml.uuid.Generators;
import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
    public Helper() {
    }

    public static String generateId() {
        return Generators.randomBasedGenerator().generate().toString();
    }
    public static boolean isValidEmail(String email){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }
    public static boolean isNullOrEmpty(Object s){

        return s==null || s.equals("");
    }

}
