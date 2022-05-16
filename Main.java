import java.util.ArrayList;
import java.util.Scanner;



/**
 * @author Wilfredo Gallegos
 * @author Guillermo Furlan
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Leer archivo = new Leer();
		System.out.println("Ingrese la ruta del archivo .txt a leer:");
		String ruta = teclado.nextLine();
		String texto = archivo.Leer(ruta);
		ArrayList<String> lista = archivo.Listar(texto);
		ArrayList<String> ciudades = new ArrayList();
		String ciudad = "";
		System.out.println(texto);
		for(int i=0;i<texto.length();i++) {
			if(Character.isAlphabetic((texto.charAt(i)))||((String.valueOf(texto.charAt(i))).equals("-"))) {
				ciudad=ciudad+texto.charAt(i);
			}else if(!Character.isAlphabetic((texto.charAt(i)))) {
				if(!(Character.isDigit((texto.charAt(i))))) {
					if(!((String.valueOf(texto.charAt(i))).equals("\n"))) {
						if(!(ciudades.contains(ciudad))) {	
							ciudades.add(ciudad);
							System.out.println(ciudades);
						}
						ciudad="";
					}
				}
			}
		}
		Integer caminos[][] = new Integer[ciudades.size()][ciudades.size()];
		//System.out.println(caminos[1][1]);
		for(int i=0;i<caminos.length;i++) {
			caminos[i][i]=0;
		}
		int contador=0;
		int l=0;
		int j=0;
		ciudad="";
		for(int i=0;i<texto.length();i++) {
			if(Character.isAlphabetic((texto.charAt(i)))||(Character.isDigit((texto.charAt(i))))||((String.valueOf(texto.charAt(i))).equals("-"))) {
				ciudad=ciudad+texto.charAt(i);
			}else if(!Character.isAlphabetic((texto.charAt(i)))) {
					if(contador==0) {
						l=ciudades.indexOf(ciudad);
						contador++;
						ciudad="";
					}else if(contador==1) {
						j=ciudades.indexOf(ciudad);
						contador++;
						ciudad="";
					}else if(contador==2) {
						caminos[l][j]= Integer.parseInt(ciudad);
						caminos[j][l]= Integer.parseInt(ciudad);
						ciudad="";
						contador=0;
						l=0;
						j=0;
					}
					
				}
			
		}
		for(int i=0;i<caminos.length;i++) {
			for(int k=0;k<caminos.length;k++) {
			//System.out.println("fila: "+i+", columna: "+k+", valor: "+caminos[i][k]);	
			}
			
		}
		
	}

}
