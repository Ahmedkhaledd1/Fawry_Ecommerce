import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void Checkout(Customer customer, Cart c){
       if (c.products.isEmpty()) {
           System.out.println("Error: Cart is empty.");
           return;
       }

       float subamount = 0;
       List<shipping> shippingProducts = new ArrayList<>();
       List<Integer>count=new ArrayList<>();

       for (Product p : c.products.keySet()) {
           int qty = c.products.get(p);
           subamount += p.getPrice() * qty;

           // ✅ add shipping items to list and add also their quantity
           if (p instanceof shipping) {

                   shippingProducts.add((shipping) p);
                   count.add(qty);

           }
       }
       ShippingService shippingService = new ShippingService();
       float shipping = shippingService.calculateShipping(shippingProducts,count);

       float totalamount = subamount + shipping;

       if (!customer.withdraw(totalamount)) {
           System.out.println("Error: Transaction cannot be completed: insufficient balance.");

           for (Product p : c.products.keySet()) {
               p.addQuantity(c.products.get(p)); // return items to store
           }
           return;  // treansaction not executed
       }
        else {
           System.out.println("** Checkout receipt **");
           for (Product p : c.products.keySet()) {
               System.out.println(c.products.get(p) + "x " + p.getName() + "        " + c.products.get(p) * p.getPrice());
           }


           System.out.println("---------------------------");
           System.out.println("Subtotal       " + subamount);
           System.out.println("Shipping       " + shipping);
           System.out.println("Total Amount   " + totalamount);
       }

   }



    public static void main(String[] args) {

        Customer c1=new Customer(4000);
        Product biscuts=new shipable_notExpired("biscut",100,20,300);
        Product cheese=new shipable_notExpired("cheese",50,20,300);
        Product food=new notShipable_Expired("food",200,30, LocalDate.of(2025, 12, 24));
        Cart cart=new Cart();
        cart.add(biscuts,5);
        cart.add(cheese,10);
        cart.add(cheese,2);
        cart.add(food,2);
       Checkout(c1,cart);



    }

}
