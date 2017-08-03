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
public class Grafo {
    private Vertice[] Grafo;
    private String nome;
    private int num_vertices;
    private final int fonte, sumidouro;
    
    Grafo(int num_vertices, String nome, int fonte, int sumidouro){
        this.Grafo = new Vertice[num_vertices];
        this.nome = nome;
        this.num_vertices = num_vertices;
        this.fonte = fonte;
        this.sumidouro = sumidouro;
    }
    
    public void addVertice(int index){
        this.Grafo[index] = new Vertice(index);
    }
    
    public void addAresta(int index1, int index2, int capacidade,int fluxo, String tipo){
        this.Grafo[index1].addAresta(new Aresta(index1, index2, capacidade, tipo, fluxo));
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Vertice getVertice(int i){
        return this.Grafo[i];
    }
    
    public Vertice[] getGrafo(){
        return this.Grafo;
    }
    
    public int getTamanho(){
        return this.num_vertices;
    }
    
    public int getFonte(){
        return this.fonte;
    }
    
    public int getSumidouro(){
        return this.sumidouro;
    }
    
    public void incrementaFluxo(int u, int v, int b){
        
        for(Aresta x: this.Grafo[u].getListaAdj()){
            if(x.getV() == v && x.getTipo().equals("avanco")){
                x.incrementaFluxo(b);
            }
        }
    }
    
    public void decrementaFluxo(int u, int v, int b){
        for(Aresta x: this.Grafo[u].getListaAdj()){
            if(x.getV() == v && x.getTipo().equals("avanco")){
                x.decrementaFluxo(b);
            }
        }
    }
    
    public void incrementaFluxoRet(int u, int v, int b){
        for(Aresta x: this.Grafo[u].getListaAdj()){
            if(x.getV() == v && x.getTipo().equals("retorno")){
                x.incrementaFluxo(b);
            }
        }
    }
    
    public void decrementaFluxoRet(int u, int v, int b){
        for(Aresta x: this.Grafo[u].getListaAdj()){
            if(x.getV() == v && x.getTipo().equals("retorno")){
                x.decrementaFluxo(b);
            }
        }
    }
    
    public void printGrafo(){
        int i;
        
        System.out.println("\nGrafo: "+ this.nome);
        for(i=0; i<this.num_vertices; i++){
            System.out.print("Vertice: " + i + " => Lista de Adjacencia: ");
            for(Aresta j : Grafo[i].getListaAdj()){
                System.out.print(j.getV() + "(C: " + j.getCapacidade()+", F: "+j.getFluxo()+"), ");
            }
            System.out.println();
        }
    }
}
