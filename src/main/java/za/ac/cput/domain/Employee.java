package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @OneToOne
    private User userId;
    private double hours;
    private double rating;

    protected Employee() {
    }

    private Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.userId = builder.userId;
        this.hours = builder.hours;
        this.rating = builder.rating;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public User getUserId() {
        return userId;
    }

    public double getHours() {
        return hours;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", userId=" + userId +
                ", hours=" + hours +
                ", rating=" + rating +
                '}';
    }

    public static class Builder {

        private int employeeId;

        private User userId;
        private double hours;
        private double rating;

        public Builder setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setUserId(User userId) {
            this.userId = userId;
            return this;
        }

        public Builder setHours(double hours) {
            this.hours = hours;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder copy(Employee employee){
            this.employeeId=employee.employeeId;
            this.userId=employee.userId;
            this.hours=employee.hours;
            this.rating=employee.rating;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }
    }
