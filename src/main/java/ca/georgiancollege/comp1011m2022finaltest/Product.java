package ca.georgiancollege.comp1011m2022finaltest;

public class Product {

  /*This class should track the sku, name, sale price, regular price and a String to hold the url information
for the image. You must create get (accessor) methods for all of the instance variables and a
toString() method. No set (mutator) methods or javadoc is required.
The toString() method should format the response as “[name]-$[sale price]”.
For example, “T-shirt with Logo-$17.00”.*/

  //instance variables
  private int id;
  private java.lang.String sku;
  private String name;
  private double salePrice;
  private double regularPrice;
  private String imageUrl;

  //public services
  public int getId(){
    return id;
  }

  public String getSku(){
    return sku;
  }

  public String getName(){
    return name;
  }

  public double getSalePrice(){
    return salePrice;
  }

  public double getRegularPrice(){
    return regularPrice;
  }

  public String getImageUrl(){
    return imageUrl;
  }

  @Override
  public String toString(){
    return String.format("%s-$%f", getName(), getSalePrice());
  }
}
