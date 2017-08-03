/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluxomaximo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavozf
 */
public class FordFulkerson {
 
    public int MaxFlow(Grafo Original, Grafo Residual){
        Auxiliares[] dicionario = new Auxiliares[Original.getTamanho()]; //cria um "dicionario" para guardar cor, distancia, predecessor e etc
        boolean controlador = true;
        int fluxoMax = 0;
        List<Aresta> P = new ArrayList<>();
        
        while(controlador){
            buscaLargura(Residual, Original.getFonte(), dicionario);
            //encontraCaminho
            Aumenta(Original, Residual, P);
        }
        
        return fluxoMax; //Lembrar de mudar retorno
    }
    
    private void Aumenta(Grafo Original, Grafo Residual, List<Aresta> P){
        int b = BuscaGargalo(P);
        //int i;
        for(Aresta i : P){
            if(i.getTipo().equals("avanco")){ //checar aresta de avanco
                Original.incrementaFluxo(i.getU(), i.getV(), b);
                Residual.incrementaFluxoRet(i.getV(), i.getU(), b);
                Residual.decrementaFluxo(i.getU(), i.getV(), b);
            } else {
                Original.decrementaFluxo(i.getU(), i.getV(), b);
                Residual.incrementaFluxo(i.getU(), i.getV(), b);
                Residual.decrementaFluxoRet(i.getV(), i.getU(), b);
            }
        }
    }
    
    private int BuscaGargalo(List<Aresta> P){
        int minimo;
        minimo = P.get(0).getCapacidade();
        for(Aresta i :P){
           if(i.getCapacidade()<minimo){
               minimo = i.getCapacidade();
           }
       }
       return minimo;
    }
    
    private void encontraCaminho(List<Aresta> P, Auxiliares[] dicionario){
        
    }
    
    private void inicializa(Grafo G, int s, Auxiliares [] dicionario){//Busca
        int i;
        for(i = 0; i< G.getTamanho(); i++){
            dicionario[i].setCorBranco();
            dicionario[i].setDistancia(-1);
            dicionario[i].setPredecessor(-1);
        }
        
        dicionario[s].setCorCinza();//faz o dicionario na posicao s mudar a cor
        dicionario[s].setDistancia(0);//distancia
        dicionario[s].setPredecessor(-1);//predecessor
    }
    
    private void buscaLargura(Grafo G, int s,  Auxiliares[] dicionario){
        int aux, u;
        Queue<Auxiliares> Q = new LinkedList();
        int i =0;
        int j = 0;
        
        inicializa(G, s, dicionario);
        Q.add(dicionario[s]); //adiciona o auxiliar na posicao do indice de s
        while(Q.size() != 0){
            u = Q.remove().getIndex();
            for (Aresta v : G.getVertice(u).getListaAdj()){
                j = v.getV();
                if (dicionario[j].getCor().equals("branco") && (v.getFluxo()>0)){
                    dicionario[j].setCorCinza();
                    dicionario[j].setDistancia(dicionario[u].getDistancia()+1);
                    //vai no dicionario na posicao onde v esta, e muda o predecessor, para o index
                    //do dicionario na posicao de u
                    dicionario[j].setPredecessor(u);
                    Q.add(dicionario[v.getV()]);
                }
            }
            dicionario[u].setCorPreto();
        }
    }
}