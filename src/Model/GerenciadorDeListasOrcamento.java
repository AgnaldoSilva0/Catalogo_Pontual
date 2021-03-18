package Model;

import Comando.Alerta;
import static Model.Listas.listOrcamento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class GerenciadorDeListasOrcamento {
    
    public static void addProdutoArqOrcamento() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\BDOrcamento.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Produtos produto : Listas.listOrcamento) {
                bw.write(produto.getCodigo() + ";" + produto.getDescricao() + ";" + produto.getPreco() + ";" + produto.getQuantidade() + ";" + produto.getTotal());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void incrementarProduto(int descisao, String codigo, String descricao, double preco, int quantidade, double total) {
        ModificadorLista.incrementarProduto(descisao, codigo, descricao, preco, quantidade, total);
    }
    
    public static void decrementarProduto(int decisao, String codigo, String descricao, double preco, int quantidade, double total) {
        ModificadorLista.decrementarProduto(decisao, codigo, descricao, preco, quantidade, total);
    }
    
    public static void removerProduto(int decisao, String codigo, String descricao, double preco, int quantidade, double total) {
        ModificadorLista.removerProduto(decisao, codigo, descricao, preco, quantidade, total);
    }
    
    public static void carregarOrcamento() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\BDOrcamento.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaContato = br.readLine();
            while (linhaContato != null) {
                String[] vectLeitor = linhaContato.split(";");
                String codigo = (vectLeitor[0]);
                String descricao = (vectLeitor[1]);
                double preco = Double.parseDouble(vectLeitor[2]);
                int quantidade = Integer.parseInt(vectLeitor[3]);
                double total = Double.parseDouble(vectLeitor[4]);
                Listas.listOrcamento.add(new Produtos(codigo, descricao, preco, quantidade, total));
                linhaContato = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void salvarArquivoOrcamento() {
        Window primaryStage = null;
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        File file = chooser.showSaveDialog(primaryStage);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            double valorTotal = 0;
            Date dataHoraAtual = new Date();
            DecimalFormat deci = new DecimalFormat("0.000");
            bw.write("#Orçamento Oficina Pontual");
            bw.newLine();
            bw.write("#CNPJ: 06.329.655/0001-94");
            bw.newLine();
            bw.write("#TEL: (79) 991910196");
            bw.newLine();
            bw.write("#EMAIL: oficinapontual1@bol.com.br");
            bw.newLine();
            bw.newLine();
            bw.write("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual));
            bw.newLine();
            bw.newLine();
            for (Produtos pE : listOrcamento) {
                bw.write("Código: " + pE.getCodigo());
                bw.newLine();
                bw.write("Quantidade: " + pE.getQuantidade() + " Preço Unitario: R$ "
                        + deci.format(pE.getPreco()) + " Valor Total: R$ " + deci.format(pE.getTotal()));
                bw.newLine();
                bw.write("----------------------------------------------------------------------------");
                bw.newLine();
                valorTotal = valorTotal + pE.getTotal();
            }
            bw.write("Valor Total do Orçamento: " + valorTotal);
            Alerta.showAlert("Sucesso", "Arquivo Salvo com Sucesso", file.getName(), Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            Alerta.showAlert("Erro", "Ocorreu um Erro ao salvar o Arquivo", e.getMessage(), Alert.AlertType.WARNING);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Alerta.showAlert("Cancelado", "Nenhum item foi salvo", "Cancelado com Sucesso", Alert.AlertType.INFORMATION);
        }
    }
    
    public static void carregarOrcamentoArquivo() {
        Window primaryStage = null;
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(primaryStage).getAbsoluteFile();
  
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String linhaContato = br.readLine();
            while (linhaContato != null) {
                String[] vectLeitor = linhaContato.split(";");
                String codigo = (vectLeitor[0]);
                String descricao = (vectLeitor[1]);
                double preco = Double.parseDouble(vectLeitor[2]);
                int quantidade = Integer.parseInt(vectLeitor[3]);
                double total = preco * quantidade;
                Listas.listOrcamentoBalcao.add(new Produtos(codigo, descricao, preco, quantidade, total));
                linhaContato = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public static void addProdutoOrcamento(String codigo, int quantidade) {
        for (Produtos e : Listas.listProduto) {
            if (e.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                double precoUni = e.getPreco() * 2;
                double total = precoUni * quantidade;
                System.out.println(total);
                //codigo, descricao, preco, quantidade, total
                Listas.listOrcamentoBalcao.add(new Produtos(e.getCodigo(), e.getDescricao(), precoUni, quantidade,
                total));
            }
        }
    }
    
    public static void salvarOrcamentoBalcao() {
        Window primaryStage = null;
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        File file = chooser.showSaveDialog(primaryStage);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Produtos produto : Listas.listOrcamentoBalcao) {
                bw.write(produto.getCodigo() + ";" + produto.getDescricao() + ";" + produto.getPreco() + ";" + produto.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static double calcularTotal(double total) {
        for (Produtos e : Listas.listOrcamentoBalcao) {
            total = total + e.getTotal();
        }
        return total;
    }
    
    }
