public class Main {
    public static void main(String[] args) {

        Product product = new Product(1, "Laptop", "Macbook Pro", 33000, 3);

        ProductManager productManager = new ProductManager();
        productManager.add(product);
        System.out.println(product.getKod());

    }
}