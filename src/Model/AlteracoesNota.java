package Model;

public class AlteracoesNota {

    public static void finalizarNota(int nota) {
        try {
            for (Nota i : Listas.listNotas) {
                if (nota == i.getNumNota()) {
                    i.setStatus("Finalizado");
                    GerenciadorDeListas.addNota();
                }
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
    
    public static void addNotaPasta(int nota) {
        try {
            for (Nota i : Listas.listNotas) {
                if (nota == i.getNumNota()) {
                    i.setStatus("Na Pasta");
                    GerenciadorDeListas.addNota();
                }
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

}
