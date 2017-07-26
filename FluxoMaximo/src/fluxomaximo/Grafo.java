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
    private int tamanho;
    private final int fonte, sumidouro;
    
    Grafo(int tamanho, String nome, int fonte, int sumidouro){
        this.Grafo = new Vertice[tamanho];
        this.nome = nome;
        this.tamanho = tamanho;
        this.fonte = fonte;
        this.sumidouro = sumidouro;
    }
    
    public void addVertice(int index){
        this.Grafo[index] = new Vertice(index);
    }
    
    public void addAresta(int index1, int index2){
        this.Grafo[index1].addAresta(new Vertice(index2));
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void printGrafo(){
        int i;
        
        System.out.print("\nGrafo: "+ this.nome);
        for(i=0; i<this.tamanho; i++){
            System.out.print("Vertice: " + i + " => Lista de Adjacencia: ");
            for(Vertice j : Grafo[i].getListaAdj()){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
