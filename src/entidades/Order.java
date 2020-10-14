package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private Date momento;
	private OrderStatus status;
	private List<OrderItem> produtos = new ArrayList<OrderItem>();
	private Cliente cliente;

	public Order(Date momento, OrderStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void addItem(OrderItem item) {
		produtos.add(item);
	}

	public void removeItem(OrderItem item) {
		produtos.remove(item);
	}

	public Double total() {
		double total = 0;

		for (OrderItem item : produtos) {
			total += item.subTotal();
		}

		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Hora pedido: "
				+ sdf.format(momento) + "\n"
				+ "Status do pedido: "
				+ status + "\n"
				+ "Cliente: "
				+ cliente + "\n"
				+ "Itens do pedido: "
				);
		for (OrderItem item : produtos) {
			sb.append(item + "\n");
		}
		sb.append("total price: $"
				+ (String.format("%.2f", total())));
		
		return sb.toString();
		
	}
}
