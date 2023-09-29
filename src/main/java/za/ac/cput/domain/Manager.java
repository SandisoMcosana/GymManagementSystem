package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;
    @OneToOne
    private Employee employeeId;

    protected Manager(){}
    private Manager(Builder builder){
        this.managerId = builder.managerId;
        this.employeeId = builder.employeeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", employeeId=" + employeeId +
                '}';
    }

    public static class Builder{
        private int managerId;
        private Employee employeeId;

        public Builder setManagerId(int managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder setEmployeeId(Employee employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder copy(Manager manager){
            this.managerId = manager.managerId;
            this.employeeId = manager.employeeId;
            return this;
        }

        public Manager build(){
            return new Manager(this);
        }
    }
}
