public class ProductWarehouseWithHistory extends ProductWarehouse {

    //private double initialBalance;
    private ChangeHistory hisoryListObj = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        hisoryListObj.add(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount) {

        double result = 0;

        result = (double) super.getBalance() + amount;

        hisoryListObj.add(result);
        //histroy to be added
        super.addToWarehouse(amount);
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double result = 0;

        result = (double) super.getBalance() - amount;
        //the difference is added not just the amount
        hisoryListObj.add(result);
        return super.takeFromWarehouse(amount);
    }

    public String history() {
        return this.hisoryListObj.toString();
    }

    public void printAnalysis(){

        System.out.println("Product: " + this.getName());

        System.out.println("History: " + hisoryListObj.toString());

        System.out.println("Largest amount of product: " + hisoryListObj.maxValue());

        System.out.println("Smallest amount of product:" + hisoryListObj.minValue());

        System.out.println("Average: " + hisoryListObj.average());
    }
}