package ca.georgiancollege.comp1011m2022finaltest;

import com.google.gson.annotations.SerializedName;


public class Customer {

    /*For the Customer class, your java program must track (at minimum) the id, first name, last name, phone
and the products that were purchased. You must create get (accessor) methods for all the instance
variables. Your code does NOT require Javadoc or set (mutator) methods. */

    //instance variables
    @SerializedName("id")
    private int id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("phone")
    private String phone;
    @SerializedName("purchases")
    private Product[] products;

    //accessor methods
    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhone(){
        return phone;
    }

    public Product[] getProducts(){
        return products;
    }


}
