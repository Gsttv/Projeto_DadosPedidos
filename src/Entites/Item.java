package Entites;

public class Item {
    private Integer quantidade;
    private Produto produto;

    public Item(){}

    public Item(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public double subTotal(){
        return quantidade*produto.getPreco();
    }
}
