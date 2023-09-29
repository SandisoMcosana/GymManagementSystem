package za.ac.cput.domain;
import jakarta.persistence.*;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String surname;
    private String cellNum;
    private String address;
    @Column(unique = true)
    private String email;
    private String password;
    protected User(){}
    private User(Builder builder){
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.cellNum = builder.cellNum;
        this.address = builder.address;
        this.email = builder.email;
        this.password = builder.password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getCellNum() {
        return cellNum;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellNum='" + cellNum + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private int userId;
        private String name;
        private String surname;
        private String cellNum;
        private String address;
        private String email;
        private String password;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder setCellNum(String cellNum) {
            this.cellNum = cellNum;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(User user){
            this.userId = user.userId;
            this.name = user.name;
            this.surname = user.surname;
            this.cellNum = user.cellNum;
            this.address = user.address;
            this.email = user.email;
            this.password = user.password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
