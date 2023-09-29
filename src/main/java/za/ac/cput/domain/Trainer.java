package za.ac.cput.domain;
import jakarta.persistence.*;
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerId;
    @OneToOne
    private Employee employeeId;
    protected Trainer(){
    }
    private Trainer(Builder builder){
        this.trainerId = builder.trainerId;
        this.employeeId= builder.employeeId;
    }
    public int getTrainerId() {
        return trainerId;
    }
    public Employee getEmployeeId() {
        return employeeId;
    }
    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", employeeId=" + employeeId +
                '}';
    }
    public static class Builder{
        private int trainerId;
        private Employee employeeId;

        public Builder setTrainerId(int trainerId){
            this.trainerId = trainerId;
            return this;
        }
        public Builder setEmployeeId(Employee employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder copy(Trainer trainer){
            this.trainerId = trainer.trainerId;
            this.employeeId = trainer.employeeId;
            return this;
        }

        public Trainer build(){
            return new Trainer(this);
        }
    }
}
