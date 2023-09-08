class Toy {
    private String id;
    private String name;
    private int quantity;
    private int frequency;

    public Toy(String id, String name, int quantity, int frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}
