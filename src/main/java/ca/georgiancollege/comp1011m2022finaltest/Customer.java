package ca.georgiancollege.comp1011m2022finaltest;

public class Customer {

    /*For the Customer class, your java program must track (at minimum) the id, first name, last name, phone
and the products that were purchased. You must create get (accessor) methods for all the instance
variables. Your code does NOT require Javadoc or set (mutator) methods. */

    //instance variables
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private Product products;

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

    public Product getProducts(){
        return products;
    }


}
