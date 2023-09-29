package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Manager;
import za.ac.cput.util.Helper;

public class ManagerFactory {
    public static Manager createManager(int managerId, Employee employeeId){
        if (Helper.isNullOrEmpty(employeeId))
            return null;
        return new Manager.Builder().setManagerId(managerId)
                .setEmployeeId(employeeId)
                .build();
    }
}
