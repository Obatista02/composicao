package entities;

public class ItemPedido {

	private int quantity;
	private Double price;
	private Produto produto;

	public ItemPedido() {
	}

	public ItemPedido(int quantity, Double price, Produto produto) {

		this.quantity = quantity;
		this.price = price;
		this.produto = produto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}
	public Double subTotal() {
		return price * quantity;
	}
	@Override
	public String toString() {
		return produto.getName() 
				+ ", $" 
				+ String.format("%.2f", price) 
				+ ", Quantity: " 
				+ quantity + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}
	
}
