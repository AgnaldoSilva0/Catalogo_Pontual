/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImprimirJasper;

/**
 *
 * @author Usuario
 */
public class DadosSaida {
    
    private static String cliente, endereco, cidade, cpf, telefone, modelo, placa;
    String codigo, descricao;
    int quantidade;
    double vTotal, vUnitario;
    private static double totalGeral;
    private static String pagamento = "";

    public DadosSaida() {
    }
    
    public DadosSaida(String cliente, String endereco, String cidade, String cpf, String telefone, String modelo, String placa) {
        this.cliente = cliente;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.modelo = modelo;
        this.placa = placa;
    }

    public DadosSaida(String codigo, String descricao, int quantidade, double vTotal, double vUnitario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.vTotal = vTotal;
        this.vUnitario = vUnitario;
    }

    public DadosSaida(double totalGeral) {
        this.totalGeral = totalGeral;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getVTotal() {
        return vTotal;
    }

    public double getvTotal() {
        return vTotal;
    }

    public void setvTotal(double vTotal) {
        this.vTotal = vTotal;
    }

    public double getvUnitario() {
        return vUnitario;
    }

    public void setvUnitario(double vUnitario) {
        this.vUnitario = vUnitario;
    }

    public double getTotalGeral() {
        return totalGeral;
    }

    public static void setTotalGeral(double totalGeral) {
        DadosSaida.totalGeral = totalGeral;
    }

    public String getPagamento() {
        return pagamento;
    }

    public static void setPagamento(String pagamento) {
        DadosSaida.pagamento = pagamento;
    }

    public static void setCliente(String cliente) {
        DadosSaida.cliente = cliente;
    }

    public static void setEndereco(String endereco) {
        DadosSaida.endereco = endereco;
    }

    public static void setCidade(String cidade) {
        DadosSaida.cidade = cidade;
    }

    public static void setCpf(String cpf) {
        DadosSaida.cpf = cpf;
    }

    public static void setTelefone(String telefone) {
        DadosSaida.telefone = telefone;
    }

    public static void setModelo(String modelo) {
        DadosSaida.modelo = modelo;
    }

    public static void setPlaca(String placa) {
        DadosSaida.placa = placa;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
