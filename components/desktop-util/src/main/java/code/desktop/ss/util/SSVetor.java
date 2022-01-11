/*
 * Vetor.java
 *
 * Created on 21 de Setembro de 2004, 18:35
 */

package code.desktop.ss.util;

import java.util.ArrayList;

/**
 *
 * @author  Administrador
 */
public class SSVetor {
        
    public static Object[] remove(Object vetor[], int posicao) {
        return remove(vetor, posicao, posicao);
    }
    
    public static Object[] remove(Object vetor[], int inicio, int fim){
        //{0,1,2,3,4,5,6,7,8,9}
        Object vetor2[] = new Object[vetor.length - (fim - inicio + 1)];
        int i, j = 0;
        for (i = 0; i < vetor.length; i++) {
            if (i >= inicio && i <= fim)
                continue;
            else
                vetor2[j] = vetor[i];
            j++;
        }
        return vetor2;        
    }
    
    public static void remove(ArrayList vetor, int inicio, int fim){
        for (int i = 0; i < vetor.size(); i++) {
            if (i >= inicio && i <= fim)
                continue;
            else
                vetor.remove(i);
        }
    }
    
    public static boolean existe(Object vetor[], Object elemento){
        return localiza(vetor, elemento) >= 0;
    }
    
    public static boolean existe(int vetor[], int elemento){
        return localiza(vetor, elemento) >= 0;
    }
    
    public static int localiza(Object vetor[], Object elemento){
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i].equals(elemento))
                return i;
        return -1;
    }
    
    public static int localiza(int vetor[], int elemento){
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] == elemento)
                return i;
        return -1;
    }
    
    public static String junta(Object vetor[]){
        return junta(vetor, ",");
    }
    
    public static String junta(boolean vetor[]){
        return junta(vetor, ",");
    }
    
    public static String junta(boolean vetor[], String separador){
        String resultado = "";
        for (int i = 0; i < vetor.length; i++){
            if (!resultado.equals("")) resultado += separador;
            resultado += vetor[i];
        }
        return resultado;
    }
    
    public static String junta(Object vetor[], String separador){
        String resultado = "";
        for (int i = 0; i < vetor.length; i++){
            if (!resultado.equals("")) resultado += separador;
            resultado += vetor[i].toString();
        }
        return resultado;
    }
    
}
