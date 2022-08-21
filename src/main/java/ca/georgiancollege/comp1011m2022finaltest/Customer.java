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

    /*Create a method that returns the total purchases as a double. Each customer will have 0 or
more products they have purchased. This method should add up all the purchases and return
the sum of their “salePrice”.*/
    public double getTotalPurchases(){
        Product[] products = getProducts();
        double totalSalesPrice = 0;
        for(Product p: products){
            totalSalesPrice +=p.getSalePrice();
        }
        return totalSalesPrice;
    }

    /*Create a method that returns the total amount the customer has saved as a double. Each
product has a regular price and a sale price. See the area highlighted in red in the diagram on
the next page.
In this example, the customer saved $1 on the first item that they purchased.
Add up the savings across all the purchases and return a double that is the sum of all the
savings.*/
    public double getAmountSaved(){
        Product[] products = getProducts();
        double totalRegularPrice = 0;
        for(Product p: products){
            totalRegularPrice +=p.getRegularPrice();
        }
        double amountSaved = totalRegularPrice - getTotalPurchases();
        return amountSaved;

    }

    /*Create a method that returns true if the customer saved $5 or more on all their purchases.*/
    public boolean getFiveOrMore(){
        boolean result = getAmountSaved() >=5 ? true : false;
        return result;
    }


}
