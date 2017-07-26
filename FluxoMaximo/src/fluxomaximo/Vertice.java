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
    private final int index;
    private  List<Vertice> listaAdj;//Lista de adjacencia
    
    Vertice(int index){
        this.index = index;
        this.listaAdj = new ArrayList <>();
    }
    public void addAresta(Vertice x){
        this.listaAdj.add(x);
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public List<Vertice> getListaAdj(){
        return this.listaAdj;
    }
}