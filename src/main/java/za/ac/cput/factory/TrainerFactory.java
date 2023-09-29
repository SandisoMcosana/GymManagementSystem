package za.ac.cput.factory;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Trainer;
import za.ac.cput.util.Helper;

public class TrainerFactory {
    public static Trainer createTrainer(int trainerId, Employee employeeId){
      if(Helper.isNullOrEmpty(employeeId))
          return null;
      return new Trainer.Builder().setTrainerId(trainerId).setEmployeeId(employeeId).build();
    }
}
