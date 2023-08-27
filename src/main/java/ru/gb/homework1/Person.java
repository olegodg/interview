package ru.gb.homework1;

public class Person {

        private String firstName;

        private String lastName;

        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;



        private Person() {
        }

        public Person(String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.country = country;
            this.address = address;
            this.phone = phone;
            this.age = age;
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", country='" + country + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }

        public static Builder createBuilder() {
            return new Builder();
        }
        public static class Builder {

            private final Person person;

            public Builder() {
                this.person = new Person();
            }

            public Builder withFirstName(String firstName) {
                this.person.firstName = firstName;
                return this;
            }

            public Builder withLastName(String lastName) {
                this.person.lastName = lastName;
                return this;
            }

            public Builder withMiddleName(String middleName) {
                this.person.middleName = middleName;
                return this;
            }
            public Builder withCountry(String country) {
                this.person.country = country;
                return this;
            }

            public Builder withAddress(String address) {
                this.person.address = address;
                return this;
            }

            public Builder withPhone(String phone) {
                this.person.phone = phone;
                return this;
            }

            public Builder withAge(int age) {
                this.person.age = age;
                return this;
            }

            public Builder withGender(String gender) {
                this.person.gender = gender;
                return this;
            }


            public Person build() {
                return person;
            }

        }
}
