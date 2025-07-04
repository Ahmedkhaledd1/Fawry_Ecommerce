public class shipable_notExpired extends Product implements shipping{

    private  Double weight;

    public shipable_notExpired(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight=weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public Double getWeight() {
        return weight;
    }
}
