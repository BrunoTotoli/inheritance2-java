package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

    private Date manufactureDate;
    private String dateString;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public UsedProduct(String name, Double price) {
        super(name, price);
    }

    public UsedProduct(String name, Double price, Date manufactureDate ) {
        super(name, price);
        this.manufactureDate = manufactureDate;

    }

    public String priceTag(){
        return getName() + " (used) $ " + getPrice() + " (Manufacture date: "+sdf.format(manufactureDate)+")";
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
