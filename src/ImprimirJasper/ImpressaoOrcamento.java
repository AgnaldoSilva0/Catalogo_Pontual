/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImprimirJasper;

import Model.Listas;
import Model.Produtos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ImpressaoOrcamento {
    
    public static void imprimir() {
       iReportCodigo impressao = new iReportCodigo();
       List listaDados = GetDados();
       impressao.Imprime_Relatorio(listaDados);
    }
    
    public static List GetDados() {
        List lista = new ArrayList();
        lista.clear();
        lista = Listas.listImprimir;
        
        return lista;
    }
    
    public static void addAtributoLista() {
        Listas.listImprimir.clear();
        for (Produtos e : Listas.listOrcamentoBalcao) {
            double valorTotalVenda = e.getQuantidade() * e.getPreco();
            Listas.listImprimir.add(new DadosSaida(e.getCodigo(), e.getDescricao(), e.getQuantidade(), valorTotalVenda, e.getPreco()));
        }
        valorTotalGeral();
    }
    
    public static void valorTotalGeral() {
        double ValorTotal = 0;
        for (Produtos e : Listas.listOrcamentoBalcao) {
            ValorTotal = e.getTotal() + ValorTotal;
        }
        DadosSaida.setTotalGeral(ValorTotal);
    }
    
}
