package App;

import Entites.Cliente;
import Entites.Item;
import Entites.Pedido;
import Entites.Produto;
import Enums.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Pedido pedido = new Pedido();
        Item item = new Item();
        Produto produto = new Produto();

        System.out.println("Digite os dados d cliente");
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Email: ");
        String email = sc.next();
        System.out.println("Aniversario (dd/MM/yyyy): ");
        Date niver = sdf.parse(sc.next());

        System.out.println("Digite os dados do pedido");
        System.out.println("STATUS: ");
        String status = sc.next();
        System.out.println("Quantos items para esse pedido: ");
        int qntItens = sc.nextInt();
        for (int i = 0; i < qntItens; i++) {
            System.out.println("Digite os dados do " + i + 1 + "° item");
            System.out.println("Nome");
            String nomeProduto = sc.next();
            System.out.println("Peço");
            double precoProduto = sc.nextDouble();
            System.out.println("Quantidade");
            int qntPrduto = sc.nextInt();

            pedido = new Pedido(new Date(), Status.valueOf(status.toUpperCase()), new Cliente(nome, email, niver));
            produto = new Produto(nomeProduto, precoProduto);
            item = new Item(qntPrduto, produto);
            pedido.addItem(item);


        }

        System.out.println("SUMARIO");
        System.out.println(pedido);
        sc.close();

    }
}