public class CustomerManager {
    Customer customer;
    ICreditManager creditManager;

    public CustomerManager(Customer customer, ICreditManager creditManager) {
        this.customer = customer;
        this.creditManager = creditManager;
    }

    public void save() {
        System.out.println("Müşteri Kaydedili: ");
    }

    public void delete() {
        System.out.println("Müşteri Silindi");
    }

    public void giveCredit() {
        creditManager.calculate();
        System.out.println("Kredi verildi");
    }
}
