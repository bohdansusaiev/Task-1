package task1;

class Supplier extends Thread {
    private final Warehouse warehouse;

    public Supplier(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                warehouse.addItem();
                Thread.sleep(1000); // Імітація часу між додаванням товарів
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}