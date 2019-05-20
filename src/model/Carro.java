
package model;

public class Carro {
    
    private int idCarro;
    private String modelo;
    private int ano;
    private double valor;

    public Carro(int idCarro, String modelo, int ano, double valor) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
