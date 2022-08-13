import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> prices;

    private Map<String, Integer> stockBalanceMap;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stockBalanceMap = new HashMap<>();
    }

    public int price(String product) {
        return prices.getOrDefault(product, -99);
    }

    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stockBalanceMap.put(product, stock);
    }

    public int stock(String product) {
        return stockBalanceMap.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (this.stock(product) > 0) {
            stockBalanceMap.put(product, stockBalanceMap.get(product) - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        Set<String> productNameSet = new HashSet<>();
        for (String key : prices.keySet()) {
            productNameSet.add(key);
        }
        return productNameSet;
    }
}
