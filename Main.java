public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        Toy toy1 = new Toy("1", "Кукла", 5, toyStore);
        Toy toy2 = new Toy("2", "Робот", 2, toyStore);
        Toy toy3 = new Toy("3", "Пазл", 6, toyStore);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        toyStore.simulateToySelection(10, "toy_results.txt");
    }
}
