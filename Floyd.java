
import java.util.ArrayList;

/**
 *
 * @author Sebastian Solorzano
 */
public class Floyd {
    public String Floyd(ArrayList<String> nombres, int[][] matriz){
        int vertices = matriz.length;
        int matrizAdy[][] = matriz; 
        String caminos[][] = new String[vertices][vertices];
        String caminosAux[][] = new String[vertices][vertices];
        String caminoRec = "", cadena = "", caminitos = "";
        int i, j, k;
        float tempora11, tempora12, tempora13, tempora14, minimo;
        for (i = 0; i < vertices; i++){
            for (j = 0; j < vertices; j++){
                caminos[i][j] = "";
                caminosAux[i][j] = "";
            }
        }
        for (k = 0; k < vertices; k++){
            for (i = 0; i < vertices; i++){
                for (j = 0; j < vertices; j++){
                    tempora11 = matrizAdy[i][j];
                    tempora12 = matrizAdy[i][j];
                    tempora13 = matrizAdy[i][j];
                    tempora14 = tempora12 + tempora13;
                    
                    minimo = Math.min(tempora11, tempora14);
                    if (tempora11 != tempora14){
                        if (minimo == tempora14){
                            caminoRec = "";
                            caminosAux[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAux, caminoRec) + (k);
                            
                        }
                    }
                    matrizAdy[i][j] = (int) minimo; 
                }
            }  
        }
        for (i = 0; i < vertices; i++){
            for (j = 0; j < vertices; j++){
                cadena = cadena + "[" + matrizAdy[i][j] + "]";
            }
            cadena = cadena + "\n";
        }
        
        for (i = 0; i < vertices; i++){
            for (j = 0; j < vertices; j++){
                if (matrizAdy[i][j] != 1000000000){
                    if(i !=j){
                        if(caminos[i][j].equals("")){
                            caminitos += "Desde "+nombres.get(i)+" Hacia "+nombres.get(j)+" Es mejor irse por "+nombres.get(i)+" y luego a "+nombres.get(j)+"\n";
                        }else{
                            caminitos +="Desde "+ nombres.get(i)+" Hacia "+nombres.get(j)+" Es mejor irse por "+(i)+", "+(caminos[i][j]) + " y finalmente " +(j)+"\n";
                        }
                    }
                }
            }
            cadena = cadena + "\n";
        }
        return "La matriz mas cortos es: \n" + cadena 
                + "\n los diferentes caminos mas cortos son: \n" + caminitos;
    }
    
    
    
    public String caminosR(int i, int k, String[][] caminosAux, String caminoRec){
        if ("".equals(caminosAux[i][k])){
            return "";
        }else{
            caminoRec += caminosR(i, Integer.parseInt(caminosAux[i][k]), 
                    caminosAux, caminoRec) + (Integer.parseInt(caminosAux[i][k])+1)
                    + ", ";
            return caminoRec;
        }
    }
}
