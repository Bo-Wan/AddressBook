package com.bowan.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    // Address builder
    public static class Builder {
        private String addressLine1;
        private String addressLine2;
        private String suburb;
        private State state;
        private String postCode;

        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }
        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }
        public Builder suburb(String suburb) {
            this.suburb = suburb;
            return this;
        }
        public Builder state(State state) {
            this.state = state;
            return this;
        }
        public Builder postCode(String postCode) {
            this.postCode = postCode;
            return this;
        }
        public Address build(){
            Address address = new Address();
            address.addressLine1 = this.addressLine1;
            address.addressLine2 = this.addressLine2;
            address.suburb = this.suburb;
            address.state = this.state;
            address.postCode = this.postCode;
            return address;
        }
    }

    // Australian State
    public enum State {
        NSW, WA, QLD, SA, VIC, TAS, ACT, NT,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String suburb;
    private State state;
    private String postCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
