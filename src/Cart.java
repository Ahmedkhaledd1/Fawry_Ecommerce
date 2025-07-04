import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> products = new HashMap<>();

    public void add(Product p,int count){
        if (p.isExpired()) {
            System.out.println("Error: "+p.getName()+" is  expired");

        }
        else if(count<p.getQuantity()) {
            if (products.containsKey(p)) {
                products.put(p, products.get(p) + count);
            } else {
                products.put(p, count);
            }
        }  else
            System.out.println("cannot add "+p.getName()+ " to cart as we dont have "+count+" items");


    }
}
