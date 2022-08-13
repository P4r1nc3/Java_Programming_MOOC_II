import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Test your app here
        ShoppingCart cart = new ShoppingCart();
        cart.add("milk", 3);
        cart.add("buttermilk", 2);
        cart.add("cheese", 5);
        System.out.println("cart price: " + cart.price());
        cart.add("computer", 899);
        System.out.println("cart price: " + cart.price());

        cart.print();
    }
}
