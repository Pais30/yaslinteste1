/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author antoniojoaozimila
 */
public class Dividas implements Serializable {
    private int id;
    private String nomeDevedor,apelidoDevedor,data,estadoDivida;
    private double valorDivida,valorAPagar;

    public Dividas(int id, String nomeDevedor, String apelidoDevedor, String data, String estadoDivida, double valorDivida, double valorAPagar) {
        this.id = id;
        this.nomeDevedor = nomeDevedor;
        this.apelidoDevedor = apelidoDevedor;
        this.data = data;
        this.estadoDivida = estadoDivida;
        this.valorDivida = valorDivida;
        this.valorAPagar = valorAPagar;
    }
    public Dividas(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public String getApelidoDevedor() {
        return apelidoDevedor;
    }

    public void setApelidoDevedor(String apelidoDevedor) {
        this.apelidoDevedor = apelidoDevedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstadoDivida() {
        return estadoDivida;
    }

    public void setEstadoDivida(String estadoDivida) {
        this.estadoDivida = estadoDivida;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    @Override
    public String toString() {
        return "" + "ID:. " + id +"\n"+"NOME DEVEDOR:. " + nomeDevedor +"\n"+ "APELIDO DEVEDOR:. " + apelidoDevedor +"\n"+ "DATA:.   " + data +"\n"+ "ESTADO DIVIDA:.  " + estadoDivida +"\n"+ "VALOR DIVIDA:. " + valorDivida +"\n"+"VALOR A PAGAR:. " + valorAPagar + "\n"+"\n";
    }
    
}

