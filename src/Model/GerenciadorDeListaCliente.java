/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class GerenciadorDeListaCliente {
    
        
    public static void carregarCliente() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\BDCliente.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaContato = br.readLine();
            while (linhaContato != null) {
                String[] vectLeitor = linhaContato.split(";");
                String nome = (vectLeitor[0]);
                String cnpj = (vectLeitor[1]);
                String endereco = (vectLeitor[2]);
                String numero = (vectLeitor[3]);
                String cidade = (vectLeitor[4]);
                Listas.listCliente.add(new Cliente(nome, cnpj, endereco, numero, cidade));
                linhaContato = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
