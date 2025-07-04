import java.time.LocalDate;

public class Shipable_Expired   extends Product  implements shipping{
    private String name;
    private Double weight;

    private LocalDate expiryDate;

    public Shipable_Expired(String name, double price, int quantity,LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate=expiryDate;
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
