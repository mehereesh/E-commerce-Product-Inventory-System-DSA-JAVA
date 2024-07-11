import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        ProductRecommendation recommendation = new ProductRecommendation();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nE-commerce Product Inventory System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Products");
            System.out.println("4. Sort Products by Price");
            System.out.println("5. Sort Products by Rating");
            System.out.println("6. Sort Products by Name");
            System.out.println("7. Search Product by Name");
            System.out.println("8. Search Products by Category");
            System.out.println("9. Recommend Top Products");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    Product product = new Product(name, price, rating, category);
                    inventory.addProduct(product);
                    recommendation.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    Product productToRemove = inventory.binarySearchByName(removeName);
                    if (productToRemove != null) {
                        inventory.removeProduct(productToRemove);
                        System.out.println("Product removed successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.println("Displaying all products:");
                    inventory.displayProducts();
                    break;
                case 4:
                    inventory.selectionSortByPrice();
                    System.out.println("Products sorted by price.");
                    inventory.displayProducts();
                    break;
                case 5:
                    inventory.selectionSortByRating();
                    System.out.println("Products sorted by rating.");
                    inventory.displayProducts();
                    break;
                case 6:
                    inventory.selectionSortByName();
                    System.out.println("Products sorted by name.");
                    inventory.displayProducts();
                    break;
                case 7:
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    Product searchedProduct = inventory.binarySearchByName(searchName);
                    if (searchedProduct != null) {
                        System.out.println("Product found: " + searchedProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter product category to search: ");
                    String searchCategory = scanner.nextLine();
                    ArrayList<Product> categoryProducts = inventory.binarySearchByCategory(searchCategory);
                    if (!categoryProducts.isEmpty()) {
                        System.out.println("Products found in category " + searchCategory + ":");
                        for (Product prod : categoryProducts) {
                            System.out.println(prod);
                        }
                    } else {
                        System.out.println("No products found in category " + searchCategory + ".");
                    }
                    break;
                case 9:
                    System.out.print("Enter the number of top products to recommend: ");
                    int topN = scanner.nextInt();
                    recommendation.recommendTopProducts(topN);
                    break;
                case 10:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
