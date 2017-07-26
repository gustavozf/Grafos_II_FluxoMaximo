/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluxomaximo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gustavozf
 */
public class FluxoMaximo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Grafo Original, Residual;
        Aresta[] AresOriginal, AresResidual;
        
        montaGrafos("grafo.txt", Original, Residual, AresOriginal, AresResidual);
        // TODO code application logic here
    }
    
    private static void montaGrafos(String arquivo, Grafo Original, Grafo Residual, Aresta[] AresOriginal, Aresta[] AresResidual){
        String file = System.getProperty("user.dir") + "/src/fluxomaximo/" + arquivo;
        System.out.println("Arquivo de entrada: " + file);
        BufferedReader br = null;
        String[] parametros;
        int n, m, t, s;
        String line = "";
        String SplitBy = " ";
        
        int i = 0;
        int aux1 = 0, aux2 = 0;
        
        try {//inserir vertices
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            parametros = line.split(SplitBy);
            n = Integer.parseInt(parametros[0]); // numero de vertices
            m = Integer.parseInt(parametros[1]); // numero de arestas
            s = Integer.parseInt(parametros[2]); // fonte
            t = Integer.parseInt(parametros[3]); // sumidouro
            
            Original = new Grafo(n,"Original",s, t);
            Residual = new Grafo(n,"Residual",s, t);
            AresOriginal = new Aresta[m];
            AresResidual = new Aresta[m*2]; // pois este tera arestas de avanco e retorno, o dobro do original
            
            while ((line = br.readLine()) != null) { //le linha por linha do arquivo
                String[] arestas = line.split(SplitBy);
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        line = "";
        br = null;
        
        
    }
    
}
