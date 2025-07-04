import java.util.List;

public class ShippingService {
    float weight;
    float shipCost;
    public ShippingService() {
        this.weight = 0;
        this.shipCost = 0;
    }


    public float calculateShipping(List<shipping> products, List<Integer> count){
        if (products.isEmpty())
            return 0;

        System.out.println("** Shipment notice **");
        int i=0;
        for (shipping item : products) {

            weight+=item.getWeight()*count.get(i);
            shipCost+=15;                //assume for each shipping item we add 15
            System.out.println(count.get(i)+"x "+item.getName()+"       "+item.getWeight()*count.get(i)+"g");
            i++;


        }
        System.out.println("Total Package weight           " +weight / 1000+"Kg");
        return shipCost;


    }

}
