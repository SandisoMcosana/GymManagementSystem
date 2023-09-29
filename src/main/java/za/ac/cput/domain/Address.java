package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int addressId;
    private String street;
    private String city;
    private String province;
    private int zipCode;


    protected Address(){}

    private Address(Builder builder){
        this.addressId= builder.addressId;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.zipCode = builder.zipCode;

    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public static class Builder{
        private int addressId;
        private String street;
        private String city;
        private String province;
        private int zipCode;

        public Builder setAddressId(int addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setZipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }



        public Builder copy(Address address){
            this.addressId= address.addressId;
            this.street = address.street;
            this.city = address.city;
            this.province = address.province;
            this.zipCode = address.zipCode;

            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}

