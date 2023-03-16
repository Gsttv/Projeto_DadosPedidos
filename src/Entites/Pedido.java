package Entites;

import Enums.Status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date momento;
    private Status status;
    private List<Item> itensPedidos = new ArrayList<Item>();
    private Cliente cliente;
    private List<Produto> produto = new ArrayList<Produto>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Pedido(){

    }

    public Pedido(Date momento, Status status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;

    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(Item item){
        itensPedidos.add(item);
    }
    public void removeItem(Item item){
        itensPedidos.remove(item);
    }

    public double total(){
        double soma  = 0;
        for (Item i: itensPedidos) {
            soma += i.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instante do pedido: " + momento + "\n");
        sb.append("Status do pedido: " + status + "\n");
        sb.append("Cliente: " + cliente.getNome());
        sb.append("("+sdf.format(cliente.getAniversario())+")");
        sb.append(" - " + cliente.getEmail() +"\n");
        sb.append("Itens compraodos:\n ");
        for (Item c: itensPedidos) {
            sb.append(c.getProduto().getNome() + ", ");
            sb.append(c.getProduto().getPreco() + ", ");
            sb.append("Quantidade: " + c.getQuantidade() + ", ");
            sb.append("Subtotal: " + "R$" + c.subTotal() + "\n");
        }
        sb.append(total());
        return sb.toString();

    }
}
