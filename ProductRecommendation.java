import java.util.PriorityQueue;

class ProductRecommendation {
    private PriorityQueue<Product> productQueue;

    public ProductRecommendation() {
        productQueue = new PriorityQueue<>((a, b) -> Double.compare(b.rating, a.rating));
    }

    public void addProduct(Product product) {
        productQueue.offer(product);
    }

    public void recommendTopProducts(int n) {
        System.out.println("Top " + n + " product recommendations based on rating:");
        for (int i = 0; i < n && !productQueue.isEmpty(); i++) {
            System.out.println(productQueue.poll());
        }
    }
}
