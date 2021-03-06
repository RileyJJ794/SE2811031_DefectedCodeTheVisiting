/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Riley Jensen
 */

package visitor.products;

import javafx.scene.image.Image;
import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The RentACarProduct will be priced by the time it is rented (per hour or day)
 * Responsible for holding all the base information of a Rent-a-Car
 */
public class RentACarProduct implements Product {
    private int pricePerDay =  250;
    private int shippingTime = 10;
    private ArrayList<String> handlingType = new java.util.ArrayList<>(Arrays.asList("On an open trailer", "On a closed, climate controlled trailer"));
    private String name = "Lambo";
    private static Image carImage;
    private static String description = "The most elegant car money can buy. " +
            "This car gives a whole new experience to driving";

    public RentACarProduct() {
        try { //image was not happy with the string url, the file input stream fixed the problem
            carImage = new Image(new FileInputStream("src/resources/images/car.jpeg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DisplayShell accept(Shopper shopper, int quantity) {
        return shopper.visit(this, quantity);
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public int getShippingTime() {
        return shippingTime;
    }

    public ArrayList<String> getHandlingType() {
        return handlingType;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return carImage;
    }

    public String getDescription(){
        return description;
    }
}
