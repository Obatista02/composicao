package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;

public class program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do cliente: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Dia do aniversario: ");
		Date birthdate = sdf.parse(sc.next());

		Cliente cliente = new Cliente(name, email, birthdate);

		System.out.println("Digite os dados do pedido: ");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());

		Pedido pedido = new Pedido(new Date(), status, cliente);

		System.out.println("Quantos itens no pedido: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite o " + i + " pedido:");
			System.out.print("Nome do produto: ");
			String produtoNome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();

			Produto produto = new Produto(produtoNome, preco);

			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();

			ItemPedido itemPedido = new ItemPedido(quantity, preco, produto);
			
			pedido.addItem(itemPedido);
		}

		sc.close();
	}

}
