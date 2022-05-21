
/**
 *
 * 
 */
public class Grafo {
    public int g;
    public int[][] matriz;
    
    public Grafo(int g){
        this.g = g;
        matriz = new int[this.g][this.g];
        for(int i=0; i< g; i++){
            for(int j=0; j< g; j++){
                matriz[i][j] = 0;
            }
        }
    }
    
    public void nuevaCiudad(int i, int j){
        matriz[i][j] += 1;
    }
    
    public void eliminarCiudad(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }
    
    public void imprimir(){
        for(int i = 0; i < g; i++){
            System.out.print("||\t");
            for(int j=0; j< g; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }
    
    public void print(){
        for(int i=0; i< g; i++){
            for(int j=0; j< g; j++){
                if (matriz[i][j]==0){
                    matriz[i][j]=999999;
                }
            }
        }
        for(int i=0; i< g; i++){
            System.out.print("||\t");
            for(int j=0; j< g; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }
    
    public int[][] retornar(){
        return matriz;
    }
    
    public int devolver(int a, int b){
        return matriz[a][b];
    }
}
