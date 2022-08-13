public class Person {
    private String name;
    private String adress;

    public Person (String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString () {
        return this.name + "\n  " + this.adress;
    }
}
