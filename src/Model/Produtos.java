package Model;

public class Produtos {
    
    String codigo;
    String descricao;
    double preco, precovenda, total, precoUni;
    int ipi, quantidade, estoque;

    public Produtos() {
    }
    
    public Produtos(String codigo, String descricao, double preco, int ipi) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.ipi = ipi;
    }
    
    public Produtos(String codigo, String descricao, double preco, int quantidade, double total) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.total = total;
        this.quantidade = quantidade;
    }

    public Produtos(String codigo, String descricao, double preco, double precovenda) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.precovenda = precovenda;
    }
    
    public Produtos(String codigo, String descricao, double preco, double precovenda, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.precovenda = precovenda;
        this.estoque = estoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(double precovenda) {
        this.precovenda = precovenda;
    }

    public int getIpi() {
        return ipi;
    }

    public void setIpi(int ipi) {
        this.ipi = ipi;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPrecoUni() {
        return precoUni;
    }

    public void setPrecoUni(double precoUni) {
        this.precoUni = precoUni;
    }
    
    
    
}
