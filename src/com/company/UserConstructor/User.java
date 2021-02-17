package com.company.UserConstructor;

public class User {
    private final String FirstName;
    private final String LastName;
    private int age;
    private String address;
    private String phoneNumber;

    private User(UserBuilder builder){
        this.FirstName=builder.firstName;
        this.LastName=builder.LastName;
        this.age=builder.age;
        this.address=builder.address;
        this.phoneNumber=builder.phoneNumber;
    }


    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public static class UserBuilder {
        private String firstName;
        private String LastName;
        private int age=0;
        private String phoneNumber="";
        private String address="";

        public UserBuilder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public UserBuilder lastName(String lastName){
            this.LastName=lastName;
            return this;
        }

        public UserBuilder age(int age){
            this.age=age;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        public User build(){
            if(firstName==null||LastName==null){
                throw new IllegalArgumentException("Name needs to be input.");
            }
            return new User(this);
        }
    }
}
