import java.time.LocalDate;

public class shipable_Expired  extends Product implements shipping{

    private double weight;

    private LocalDate expiryDate;

    public shipable_Expired(String name, double price, int quantity,LocalDate expiryDate,double weight) {
        super(name, price, quantity);
        this.expiryDate=expiryDate;
        this.weight=weight;
    }

    @Override
    public String getName() {
        return name;
    }



    @Override
    public Double getWeight() {
        return weight;
    }

    public boolean isExpired(){

        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }
}
