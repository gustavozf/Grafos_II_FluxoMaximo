/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluxomaximo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gustavozf
 */

/*
Ciencia da Computacao - UEM
Grafos - Daniel Kikuti
Alunos: Gustavo Zanoni Felipe (RA 92821)
        Mariana Soder (RA 95381)
        Narcizo Gabriel (RA 95380)

Agosto/2017
*/
public class FluxoMaximo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo Original, Residual;
        Original = null;
        Residual = null;
        Scanner scan = new Scanner(System.in);
        int n, m, t, s;
        int maxFlow;
        FordFulkerson max = new FordFulkerson();
        
        System.out.println("ULTIMATE PROGRAMA OF FLUXOS");
        System.out.print("Insira o numero de Vertices: ");        
        n = scan.nextInt(); // numero de vertices
        //System.out.println();
        System.out.print("Insira o numero de Arestas: ");
        m = scan.nextInt(); // numero de arestas
        //System.out.println();
        System.out.print("Insira o vertice Fonte: ");        
        s = scan.nextInt(); // fonte
        //System.out.println();
        System.out.print("Insira o vertice Sumidouro: ");
        t = scan.nextInt(); // sumidouro
        //System.out.println();
            
        System.out.println("n= "+n+" m="+m+" s="+s+" t="+t);
            
        Original = new Grafo(n,"Original",s, t);
        Residual = new Grafo(n,"Residual",s, t);
                
        montaGrafos("grafo.txt", Original, Residual);
        
        Original.printGrafo();
        Residual.printGrafo();
        
        maxFlow = max.MaxFlow(Original, Residual);
        System.out.println("O Fluxo Maximo eh: " + maxFlow);
        // TODO code application logic here
    }
    
    private static void montaGrafos(String arquivo, Grafo Original, Grafo Residual){
        String file = System.getProperty("user.dir") + "/src/fluxomaximo/" + arquivo;
        System.out.println("Arquivo de entrada: " + file);
        BufferedReader br = null;
        String[] parametros;
        int[] aux;
        aux = new int[3];
        String line = "";
        String SplitBy = " ";
        int i = 0;        
        
        try {//inserir vertices
            String[] arestas;
            br = new BufferedReader(new FileReader(file));
            
            while ((line = br.readLine()) != null) { //le linha por linha do arquivo
                arestas = line.split(SplitBy);
                aux[0] = Integer.parseInt(arestas[0]);//u
                aux[1] = Integer.parseInt(arestas[1]);//v
                aux[2] = Integer.parseInt(arestas[2]);//c
                if(Original.getVertice(aux[0]) == null){ //se nao tem o primeiro numero inserido,
                    Original.addVertice(aux[0]);         // insere no grafo original
                    Residual.addVertice(aux[0]);         // insere no grafo residual
                }
                if(Original.getVertice(aux[1]) == null){ ////se nao tem o segundo numero inserido
                    Original.addVertice(aux[1]);
                    Residual.addVertice(aux[1]);
                }
                Original.addAresta(aux[0], aux[1], aux[2], 0, "avanco"); //insere na lista do vertice na posicao aux[0], aux[1] e a capacidade aux[2]
                Residual.addAresta(aux[0], aux[1], aux[2], aux[2], "avanco");//Insere a aresta de avanço
                Residual.addAresta(aux[1], aux[0], aux[2],0, "retorno");//insere a aresta de retorno
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
