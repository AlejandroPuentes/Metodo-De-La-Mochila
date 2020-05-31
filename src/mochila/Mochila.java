package mochila;

import java.util.Scanner;

public class Mochila {
    public int max(int n, int m){
        if (n>m){
            return n;
        }else {
        return m;
        }
    }
    public static void main(String[]args){
        Mochila moc = new Mochila();
        Scanner cs = new Scanner(System.in); //Número de objetos
        System.out.println("Numero de objetos");
        int n = cs.nextInt();
        System.out.println("Peso de la mochila");
        int w = cs.nextInt();
        
        int[][] v = new int[n+1][w+1]; //Matriz que almacenará los datos
        int [] peso = new  int [n+1];
        int [] valor = new  int [n+1]; 
        //Llena de 0 la matriz de productos
        peso[0]=0;
        valor[0]=0;
        System.out.println("dijite los pesos y sus respectivos valores");
        for (int i = 1; i <=n; i++) {
            peso[i]=cs.nextInt();
            valor[i]=cs.nextInt();
        }
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<w+1; j++){
                v[0][j] = 0;
                v[i][0] = 0;
            }
        }
        
       
        
        //Calcula los valores
        
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<w+1; j++){
                if(j>=peso[i]){
                    v[i][j]=moc.max(v[i-1][j],v[i-1][j-peso[i]]+valor[i]);
                }else{
                    v[i][j]=v[i-1][j];
                }
            }
        }
        
        //Imprime la matriz de datos
        
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<w+1; j++){
                System.out.print(v[i][j]);
            }
            System.out.println("  ");
        }
        
    }
    
}
