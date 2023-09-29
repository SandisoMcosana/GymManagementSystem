package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Member;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class EmployeeFactory {

    public static Employee createEmployee(double hours, double rating, User userId) {
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(hours) || Helper.isNullOrEmpty(rating))
            return null;


        return new Employee.Builder()
                .setUserId(userId)
                .setHours(hours)
                .setRating(rating)
                .build();
    }
}




