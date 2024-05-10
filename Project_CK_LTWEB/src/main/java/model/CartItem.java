package model;

public class CartItem {
	private Product product;
	private int quantity;

	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	// Phuong thuc tinh tong tien
	public int getTotalCost() {
		return this.quantity * this.product.getPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void increment() {
		this.quantity++;
	}

	public void descrement() {
		this.quantity--;
	}

	// Phuong thuc format gia de hien thi
	public String formatPrice() {
		String fm = product.getPrice() + "";
		String result = "";
		int count = 0;
		for (int i = fm.length() - 1; i >= 0; i--) {
			result = fm.charAt(i) + result;
			count++;
			if (count == 3 && i != 0) {
				result = "." + result;
				count = 0;
			}
		}
		return result;
	}

	// Phuong thuc format tong gia de hien thi
	public String formatTotal() {
		String fm = getTotalCost() + "";
		String result = "";
		int count = 0;
		for (int i = fm.length() - 1; i >= 0; i--) {
			result = fm.charAt(i) + result;
			count++;
			if (count == 3 && i != 0) {
				result = "." + result;
				count = 0;
			}
		}
		return result;
	}

	public CartItem() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}