/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Cliente {
    
    String nome;
    String cnpj;
    String endereco;
    String numero;
    String cidade;

    public Cliente(String nome, String cnpj, String endereco, String numero, String cidade) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
    }
   
    public Cliente(String nome, String cnpj, String numero, String cidade) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.numero = numero;
        this.cidade = cidade;
    }

    public Cliente(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}
