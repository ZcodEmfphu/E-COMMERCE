package model;

import java.util.ArrayList;

public class Cart {
	private ArrayList<CartItem> items = new ArrayList<>();
	private int total;

	// Xóa giỏ hàng khi đặt hàng thành công
	public void deleteCart() {
		items.clear(); // Xóa tất cả các sản phẩm trong giỏ hàng
		calculateOrderTotal();
	}

	// Xóa sản phẩm khỏi giỏ hàng
	public void deleteProduct(String stt) {
		try {
			int index = Integer.parseInt(stt) - 1;
			if (index >= 0 && index < items.size()) {
				items.remove(index); // Xóa sản phẩm tại vị trí chỉ định
				calculateOrderTotal();
			} else {
				System.out.println("Invalid index for deleting product: " + stt);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid index format for deleting product: " + stt);
		}
	}

	// Cập nhật số lượng sản phẩm trong giỏ hàng
	public int updateQuanlity(String stt, int status) {
		try {
			int index = Integer.parseInt(stt) - 1;
			if (index >= 0 && index < items.size()) {
				CartItem cartItem = items.get(index);
				int newQuantity = cartItem.getQuantity() + status;
				if (newQuantity > 0) {
					cartItem.setQuantity(newQuantity);
					if (newQuantity == 0) {
						items.remove(index); // Xóa sản phẩm nếu số lượng bằng 0
					}
					calculateOrderTotal();
					return newQuantity;
				} else {
					System.out.println("Invalid quantity after update: " + newQuantity);
				}
			} else {
				System.out.println("Invalid index for updating quantity: " + stt);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid index format for updating quantity: " + stt);
		}
		return 0;
	}

	// Thêm sản phẩm vào giỏ hàng
	public void addCart(Product product, String quantity) {
		try {
			int newQuantity = Integer.parseInt(quantity);
			if (newQuantity > 0) {
				boolean existingItem = false;
				for (CartItem item : items) {
					if (item.getProduct().getId() == product.getId()) {
						item.setQuantity(item.getQuantity() + newQuantity);
						existingItem = true;
						break;
					}
				}
				if (!existingItem) {
					CartItem newItem = new CartItem(product, newQuantity);
					items.add(newItem);
				}
				calculateOrderTotal();
			} else {
				System.out.println("Invalid quantity for adding product: " + quantity);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid quantity format for adding product: " + quantity);
		}
	}

	// Tính lại tổng số tiền đơn hàng
	protected void calculateOrderTotal() {
		int totalCost = 0;
		for (CartItem item : items) {
			totalCost += item.getTotalCost();
		}
		total = totalCost;
	}

	// Định dạng lại tổng số tiền
	public String formatTotal() {
		String formattedTotal = String.format("%,d", total); // Sử dụng định dạng số nguyên có dấu phẩy
		return formattedTotal;
	}

	// Getter và setter
	public ArrayList<CartItem> getList() {
		return items;
	}

	public void setList(ArrayList<CartItem> list) {
		this.items = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLineItemCount() {
		return items.size();
	}
}
