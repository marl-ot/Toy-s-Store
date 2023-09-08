import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.PriorityQueue;

public class ToyStore {
    private Random random = new Random();
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public Toy getRandomToy() {
        double randomValue = random.nextDouble();
        double cumulativeProbability = 0;

        for (Toy toy : toyQueue) {
            cumulativeProbability += toy.getProbability();
            if (randomValue < cumulativeProbability) {
                return toy;
            }
        }

        // Вернуть случайную игрушку, если ничего не выбрано
        return getRandomToy();
    }

    public void simulateToySelection(int numberOfSelections, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int i = 0; i < numberOfSelections; i++) {
                Toy selectedToy = getRandomToy();
                writer.write("Выбрана игрушка: ID=" + selectedToy.getId() + ", Название=" + selectedToy.getName() + ", Частота=" + selectedToy.getFrequency());
                writer.newLine();
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
}
