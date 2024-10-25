package task1;

public class Main {
    public static void main(String[] args) {
        int warehouseCapacity = 5;
        Warehouse warehouse = new Warehouse(warehouseCapacity);

        Supplier supplier = new Supplier(warehouse);
        Customer customer = new Customer(warehouse, 10000, 10000); // Активний та пасивний час роботи.

        supplier.start();
        customer.start();
    }
}