public abstract class Animal {

    private String name;
    public Animal(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println(this.name + " sleeps");
    }

    public void eat() {
        System.out.println(this.name + " eats");
    }

    public String getName() {
        return this.name;
    }
}
