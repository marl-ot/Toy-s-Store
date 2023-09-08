public class Toy {
    private String id;
    private String name;
    private int frequency;
    private ToyStore toyStore;

    public Toy(String id, String name, int frequency, ToyStore toyStore) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.toyStore = toyStore;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public double getProbability() {
        // Вычисление вероятности выбора данной игрушки на основе частоты выпадения и общей частоты
        return (double) frequency / toyStore.getTotalFrequency();
    }
}

