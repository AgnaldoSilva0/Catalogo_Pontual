package Model;

public class Nota {
    
    String proprietario, cor, modelo, placa, status;
    int numNota;

    public Nota(String proprietario, String cor, String modelo, String placa, String status, int numNota) {
        this.proprietario = proprietario;
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
        this.status = status;
        this.numNota = numNota;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumNota() {
        return numNota;
    }

    public void setNumNota(int numNota) {
        this.numNota = numNota;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
