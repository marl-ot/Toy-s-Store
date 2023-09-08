import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {
    private Random random = new Random();
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());
    private List<Toy> prizeToys = new ArrayList<>();

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public void updateToyWeight(String toyId, int newWeight) {
        for (Toy toy : toyQueue) {
            if (toy.getId().equals(toyId)) {
                toy.setFrequency(newWeight);
                toyQueue.remove(toy);
                toyQueue.add(toy);
                break;
            }
        }
    }

    public Toy getRandomToy() {
        double totalWeight = toyQueue.stream().mapToDouble(Toy::getFrequency).sum();
        double randomValue = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.getFrequency();
            if (randomValue <= cumulativeWeight) {
                return toy;
            }
        }

        return null;
    }

    public List<Toy> getPrizeToys() {
        return prizeToys;
    }

    public void choosePrizeToy() {
        Toy selectedToy = getRandomToy();
        if (selectedToy != null) {
            prizeToys.add(selectedToy);
            decreaseToyQuantity(selectedToy);
        }
    }

    public void getPrizeToyAndWriteToFile(String outputFileName, Toy prizeToy) {
        if (prizeToy != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName, true))) {
                writer.write("Получена призовая игрушка: ID=" + prizeToy.getId() + ", Название=" + prizeToy.getName());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void simulateToySelection(int numberOfSelections, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int i = 0; i < numberOfSelections; i++) {
                Toy selectedToy = getRandomToy();
                if (selectedToy != null) {
                    writer.write("Выбрана игрушка: ID=" + selectedToy.getId() + ", Название=" + selectedToy.getName() + ", Частота=" + selectedToy.getFrequency());
                    writer.newLine();
                } else {
                    writer.write("Игрушки закончились");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTotalFrequency() {
        int totalFrequency = 0;
        for (Toy toy : toyQueue) {
            totalFrequency += toy.getFrequency();
        }
        return totalFrequency;
    }

    public void decreaseToyQuantity(Toy toy) {
        for (Toy t : toyQueue) {
            if (t.getId().equals(toy.getId())) {
                t.decrementQuantity();
                break;
            }
        }
    }
}

