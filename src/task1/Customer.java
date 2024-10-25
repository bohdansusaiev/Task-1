package task1;

class Customer extends Thread {
    private final Warehouse warehouse;
    private final int activeTime;   // Час, протягом якого покупець активний
    private final int inactiveTime; // Час, протягом якого покупець "відпочиває"

    public Customer(Warehouse warehouse, int activeTime, int inactiveTime) {
        this.warehouse = warehouse;
        this.activeTime = activeTime;
        this.inactiveTime = inactiveTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Покупець активний. Може купувати товари.");
                long endActiveTime = System.currentTimeMillis() + activeTime;

                // Період, коли покупець активний і може купувати
                while (System.currentTimeMillis() < endActiveTime) {
                    warehouse.removeItem(); // Спроба забрати товар
                    Thread.sleep(2000); // Імітація часу між покупками
                }

                System.out.println("Покупець на вихідних. Не може купувати.");
                Thread.sleep(inactiveTime); // Період "відпочинку"
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
