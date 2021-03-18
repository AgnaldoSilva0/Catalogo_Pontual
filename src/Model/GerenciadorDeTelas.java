package Model;

import Controller.TelaIncialController;
import catalogopontual.Balcao;
import catalogopontual.CadastrarProdutos;
import catalogopontual.CatalogoAmalcaburio;
import catalogopontual.CatalogoBonfanti;
import catalogopontual.CatalogoPontual;
import catalogopontual.Contatos;
import catalogopontual.Orcamento;
import catalogopontual.ProdutoAvulso;
import catalogopontual.TabelaNotas;
import catalogopontual.Termos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

public class GerenciadorDeTelas {
    
    public static void abrirTelaAmalcaburio() {
        CatalogoAmalcaburio instancia = new CatalogoAmalcaburio();
        try {
            instancia.start(new Stage());
            CatalogoPontual.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaBonfanti() {
        CatalogoBonfanti instancia = new CatalogoBonfanti();
        try {
            instancia.start(new Stage());
            CatalogoPontual.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaNotas() {
        TabelaNotas instancia = new TabelaNotas();
        try {
            instancia.start(new Stage());
            CatalogoPontual.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaCadastrarProduto() {
        CadastrarProdutos instancia = new CadastrarProdutos();
        try {
            instancia.start(new Stage());
            CatalogoPontual.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaTermos() {
        Termos instancia = new Termos();
        try {
            instancia.start(new Stage());
            CatalogoPontual.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaContatos() {
        Contatos instancia = new Contatos();
        try {
            instancia.start(new Stage());
            CatalogoPontual.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaOrcamento() {
        Orcamento instancia = new Orcamento();
        try {
            instancia.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaProdutoAvulso() {
        ProdutoAvulso instancia = new ProdutoAvulso();
        try {
            instancia.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaBalcao() {
        Balcao instancia = new Balcao();
        try {
            instancia.start(new Stage());
            CatalogoPontual.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void fecharTelaOrcamento() {
        try {
            Orcamento.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void voltarAoMenuInicial() {
        CatalogoPontual instancia = new CatalogoPontual();
        try {
            instancia.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaIncialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
