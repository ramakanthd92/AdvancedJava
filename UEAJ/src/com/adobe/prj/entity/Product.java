package com.adobe.prj.entity;

public class Product implements  Comparable<Product> {

    int id;
    String name;
    double price;
    String type;

    public Product() {
    }

    public Product(int id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *  This  method  is  used  to  find  if propublic  product  is  expensive  or  not
     *
     *  @return  true  if  expensive  else  return  false.
     */
    public  boolean  isExpensive() {
        return false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public  int  compareTo(Product  o)  {
        return  Double.compare(this.id,  o.id);
    }

    @Override
    public  String  toString()  {
        return  "Product  [id="  +  id  +  ",  name="  +  name  +  ",  price="  +  price  +  "]";
    }


//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }

}
