import java.time.LocalDate;

public class notShipable_Expired extends Product {
    private LocalDate expiryDate;
    public notShipable_Expired(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
         this.expiryDate=expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }
}
