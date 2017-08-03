/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluxomaximo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavozf
 */
public class Vertice {
    private final int index; //Nome do vertice
    private  List<Aresta> listaAdj;//Lista de adjacencia
    
    Vertice(int index){
        this.index = index;
        this.listaAdj = new ArrayList <>();
    }
    public void addAresta(Aresta x){
        this.listaAdj.add(x);
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public Aresta getAresta(int i){
        for(Aresta x: this.getListaAdj()){
            if(x.getV() == i){
                return x;
            }
        }
        
        return null;
    }
    
    public List<Aresta> getListaAdj(){
        return this.listaAdj;
    }
}