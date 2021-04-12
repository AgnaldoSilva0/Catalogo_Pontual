package Model;

import BancoDados.Pesquisar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorDeListas {

    public static void addProdutoArqAmalcaburio() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\BDAmalcaburio.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Produtos produto : Listas.listAmalcaburio) {
                bw.write(produto.getCodigo() + ";" + produto.getDescricao() + ";" + produto.getPreco() + ";" + produto.getIpi());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addArqContato() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\TesteContatos.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Contato contato : Listas.listContatos) {
                bw.write(contato.getNome() + ";" + contato.getNumero() + ";" + contato.getReferencia() + ";" + contato.getDdd());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addNota() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\TesteNota.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Nota nota : Listas.listNotas) {
                bw.write(nota.getProprietario() + ";" + nota.getCor() + ";" + nota.getModelo() + ";" + nota.getPlaca() + ";" + nota.getStatus() + ";" + nota.getNumNota());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void carregarProdutosArqAmalcaburio() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\BDAmalcaburio.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaProduto = br.readLine();
            while (linhaProduto != null) {
                String[] vectLeitor = linhaProduto.split(";");
                String codigo = (vectLeitor[0]);
                String descricao = (vectLeitor[1]);
                double preco = Double.parseDouble(vectLeitor[2]);
                int ipi = Integer.parseInt(vectLeitor[3]);
                Listas.listAmalcaburio.add(new Produtos(codigo, descricao, preco, ipi));
                linhaProduto = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void carregarProdutosArqBonfanti() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\TesteBonfanti.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaProduto = br.readLine();
            while (linhaProduto != null) {
                String[] vectLeitor = linhaProduto.split(";");
                String codigo = (vectLeitor[0]);
                String descricao = (vectLeitor[1]);
                double preco = Double.parseDouble(vectLeitor[2]);
                int ipi = Integer.parseInt(vectLeitor[3]);
                Listas.listBonfanti.add(new Produtos(codigo, descricao, preco, ipi));
                linhaProduto = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void carregarListaNotas() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\TesteNota.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaNota = br.readLine();
            while (linhaNota != null) {
                String[] vectLeitor = linhaNota.split(";");
                String proprietario = (vectLeitor[0]);
                String cor = (vectLeitor[1]);
                String modelo = (vectLeitor[2]);
                String placa = (vectLeitor[3]);
                String status = (vectLeitor[4]);
                int numNota = Integer.parseInt(vectLeitor[5]);
                Listas.listNotas.add(new Nota(proprietario, cor, modelo, placa, status, numNota));
                linhaNota = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void carregarContatos() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\TesteContatos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaContato = br.readLine();
            while (linhaContato != null) {
                String[] vectLeitor = linhaContato.split(";");
                String nome = (vectLeitor[0]);
                int numero = Integer.parseInt(vectLeitor[1]);
                String descricao = (vectLeitor[2]);
                int ddd = Integer.parseInt(vectLeitor[3]);
                Listas.listContatos.add(new Contato(nome, numero, descricao, ddd));
                linhaContato = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }   

    public static void carregarTodasAsListas() {
        if (Listas.listAmalcaburio.isEmpty()) {
            carregarProdutosArqAmalcaburio();
        }
        if (Listas.listBonfanti.isEmpty()) {
            carregarProdutosArqBonfanti();
        }
        if (Listas.listNotas.isEmpty()) {
            carregarListaNotas();
        }
        if (Listas.listContatos.isEmpty()) {
            carregarContatos();
        }
        if (Listas.listOrcamento.isEmpty()) {
            GerenciadorDeListasOrcamento.carregarOrcamento();
        }
        if (Listas.listCliente.isEmpty()) {
            GerenciadorDeListaCliente.carregarCliente();
        }
        if (Listas.listProduto.isEmpty()) {
            Pesquisar.pesquisarProduto();
        }
    }

}
