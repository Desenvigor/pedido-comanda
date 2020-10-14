package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Order;
import entidades.OrderItem;
import entidades.OrderStatus;
import entidades.Produto;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		String nome, email;
		Date data;
		
		System.out.println("Digite o nome do cliente:");
		nome = sc.nextLine();
		System.out.println("Digite o e-mail do cliente");
		email = sc.nextLine();
		System.out.println("Data de nascimento do cliente: ");
		data = sdf.parse(sc.nextLine());
		
		Cliente cliente = new Cliente(nome, email, data);
		
		System.out.println("Informe os dados do pedido: ");
		System.out.println("Status: ");
		OrderStatus status =  OrderStatus.valueOf(sc.nextLine());
		Order pedido = new Order(data, status, cliente);
		
		System.out.println("Digite quantos itens vai ter no pedido: ");
		int itensPedido = sc.nextInt();
		for (int i = 0; i < itensPedido; i++) {
			System.out.println("Digite os dados do "+ (i+1) +" item:");
			System.out.print("Nome: ");
			String nomeProduto = sc.next();
			System.out.print("Preço: ");
			Double precoProduto = sc.nextDouble();
			Produto produto = new Produto(nomeProduto, precoProduto);
			System.out.print("Quantidade: ");
			Integer quantidade = sc.nextInt();
			OrderItem itemPedido = new OrderItem(quantidade, produto);
			pedido.addItem(itemPedido);
		}
		
		System.out.println(pedido.toString());
		
		
		sc.close();		
	}

}
