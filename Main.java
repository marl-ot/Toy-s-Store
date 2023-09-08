import java.util.List;

public class Main {
    public static void main(String[] args) {
    ToyStore toyStore = new ToyStore();
    
    // Добавление игрушек
    Toy toy1 = new Toy("1", "Кукла", 10, 20);
    Toy toy2 = new Toy("2", "Мяч", 15, 20);
    Toy toy3 = new Toy("3", "Пазл", 5, 60);
    
    toyStore.addToy(toy1);
    toyStore.addToy(toy2);
    toyStore.addToy(toy3);
    
    // Выбор призовых игрушек и запись их в файл
    for (int i = 0; i < 10; i++) {
        toyStore.choosePrizeToy();
        List<Toy> prizeToys = toyStore.getPrizeToys();
        if (i < prizeToys.size()) {
            Toy prizeToy = prizeToys.get(i);
            toyStore.getPrizeToyAndWriteToFile("prize_results.txt", prizeToy);
        }
    }
}
}
