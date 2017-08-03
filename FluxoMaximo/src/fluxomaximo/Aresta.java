/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluxomaximo;

/**
 *
 * @author gustavozf
 */
public class Aresta {
    private final int v; //Nome
    private final int u; //Informa na lista de quem esta ligado
    private final String tipo;
    private int capacidade, fluxo;
    
    Aresta(int u, int v, int capacidade, String tipo, int fluxo){
        this.v = v;
        this.u = u;
        this.capacidade = capacidade;
        this.fluxo = fluxo;
        this.tipo = tipo;
    }
    
    public int getV(){//getNome
        return this.v;
    }
    
    public int getU(){//Pega o index em quem esta ligado
        return this.u;
    }
    
    public int getCapacidade(){
        return this.capacidade;
    }
    
    public int getFluxo(){
        return this.fluxo;
    }
    
    public void setCapacidade(int newCapacidade){
        this.capacidade = newCapacidade;
    }
    
    public void incrementaFluxo(int b){
        this.fluxo += b;
    }
    
    public void decrementaFluxo(int b){
        this.fluxo -= b;
    }
    
    public String getTipo(){
        return this.tipo;
    }
}
