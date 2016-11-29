package russ.xiang.foodtruck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Item implements Serializable {
    private static final long serialVersionUID = -1213949467658913456L;
    private String itemId;
    private String name;
    private String price;
    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getItemId() + ". " + getName() + " $"+ getPrice() + " - " + getQuantity + " avaliable";
    }

    public Item(String itemId,String name, String price, String quantity) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>(); // array of data that the ArrayAdapter will use
        items.add(new Item("1","Ginger Scallion Noodles", "10","0"));
        items.add(new Item("2","Beef Pho", "10","0"));
        items.add(new Item("3","Hozon Ramen", "10","0"));
        items.add(new Item("4","Chicken Wings", "10","0"));

        return items;
    }

}