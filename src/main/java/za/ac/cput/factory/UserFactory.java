package za.ac.cput.factory;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;
public class UserFactory {
    public static User createUser( String name, String surname,String cellNum, String address,String email, String password){
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(cellNum) ||Helper.isNullOrEmpty(address) ||Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password))
            return null;

        if (Helper.isValidEmail(email)){
            return null;
        }
        return new User.Builder()
                .setName(name)
                .setSurname(surname)
                .setCellNum(cellNum)
                .setAddress(address)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}
