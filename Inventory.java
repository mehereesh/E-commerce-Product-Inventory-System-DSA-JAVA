import java.util.ArrayList;

class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Selection sort
    public void selectionSortByPrice() {
        for (int i = 0; i < products.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(j).price < products.get(minIndex).price) {
                    minIndex = j;
                }
            }
            Product temp = products.get(minIndex);
            products.set(minIndex, products.get(i));
            products.set(i, temp);
        }
    }

    public void selectionSortByRating() {
        for (int i = 0; i < products.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(j).rating > products.get(minIndex).rating) {  // Higher rating comes first
                    minIndex = j;
                }
            }
            Product temp = products.get(minIndex);
            products.set(minIndex, products.get(i));
            products.set(i, temp);
        }
    }

    public void selectionSortByName() {
        for (int i = 0; i < products.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(j).name.compareTo(products.get(minIndex).name) < 0) {
                    minIndex = j;
                }
            }
            Product temp = products.get(minIndex);
            products.set(minIndex, products.get(i));
            products.set(i, temp);
        }
    }

    // Binary search methods
    public Product binarySearchByName(String name) {
        selectionSortByName(); // Ensure the list is sorted by name before searching
        int left = 0, right = products.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products.get(mid).name.compareTo(name);
            if (cmp == 0) {
                return products.get(mid);
            }
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public ArrayList<Product> binarySearchByCategory(String category) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.category.equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }
}
