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
    private final int u, v;
    private int capacidade, fluxo;
    
    Aresta(int u, int v, int capacidade, int fluxo){
        this.u = u;
        this.v = v;
        this.capacidade = capacidade;
        this.fluxo = 0;
    }
    
    public int getU(){
        return this.u;
    }
    
    public int getV(){
        return this.v;
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
    
    public void setFluxo(int newFluxo){
        this.fluxo = newFluxo;
    }
}
