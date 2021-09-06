package entities;

public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public ImportedProduct() {

    }

    public Double totalPrice() {
        return (this.getPrice() + customsFee);
    }

    public String priceTag() {
        return getName() + " $ " + (getPrice() + customsFee) + " (Customs fee: $ " + this.customsFee+")";
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
}
