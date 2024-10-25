package task1;

import java.util.concurrent.Semaphore;

class Warehouse {
    private final Semaphore items;
    private final Semaphore emptySlots;
    private final int capacity;

    public Warehouse(int capacity) {
        this.capacity = capacity;
        this.items = new Semaphore(0); // Немає товарів на початку
        this.emptySlots = new Semaphore(capacity); // Всі місця вільні
    }

    public void addItem() throws InterruptedException {
        emptySlots.acquire(); // Чекаємо на вільне місце
        System.out.println("Постачальник додає товар");
        items.release(); // Додаємо товар
    }

    public void removeItem() throws InterruptedException {
        items.acquire(); // Чекаємо, якщо немає товарів
        System.out.println("Покупець забирає товар");
        emptySlots.release(); // Звільняємо місце
    }
}






