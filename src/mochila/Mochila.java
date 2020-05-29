package mochila;

import java.util.Scanner;

public class Mochila {
    public static void main(String[]args){
        
        Scanner cs = new Scanner(System.in); //Número de objetos
        System.out.println("Numero de objetos");
        int n = cs.nextInt();
        System.out.println("Peso de la mochila");
        int w = cs.nextInt();
        
        int[][] v = new int[n+1][w+3]; //Matriz que almacenará los productos
        
        //Llena de 0 la matriz de productos
        
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<2; j++){
                v[0][i] = 0;
                v[i][2] = 0;
            }
        }
        
        //Pide el valor de los productos
        
        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<2; j++){
                System.out.println("["+i+"]"+"["+j+"]");
                v[i][j] = cs.nextInt();
            }
        }
        
        //Calcula los valores
        
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<w+1; j++){
                int wi = v[i][0];
                int bi = v[i][1];
                if(wi<=w){
                    if((bi + v[i-1][w-wi]) > v[i-1][w]){
                        v[i][w] = bi +v[i-1][w-wi];
                    }
                    else{
                        v[i][w] = v[i-1][w];
                    }
                }
                else{
                    v[i][w] = v[i-1][w];
                }
            }
        }
        
        //Imprime la matriz de datos
        
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<w+1; j++){
                System.out.print(v[i][j]);
            }
            System.out.println(" ");
        }
        
    }
    
}
