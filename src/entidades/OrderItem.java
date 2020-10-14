package entidades;

public class OrderItem {
	private Integer quantidade;
	private Produto produto;
	private Double preco;

	public OrderItem(Integer quantidade, Produto produto) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Double subTotal() {
		preco = produto.getPreco();
		return (preco * quantidade);
	}

	@Override
	public String toString() {
		return produto.getNome()
				+ ", $"
				+ String.format("%.2f", preco)
				+ ", Quantidade: "
				+ ", Subtotal: $"
				+ String.format("%.2f", subTotal());
	}

}
