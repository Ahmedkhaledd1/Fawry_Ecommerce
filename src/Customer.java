public class Customer {
    Float money;
    public Customer(float money){
        this.money=money;
    }

    public boolean withdraw(float money) {  //check whether customer has money or not if he has it withdraws
        if (this.money > money) {
            this.money -= money;
            return true;
        }
        return false;
    }
}
