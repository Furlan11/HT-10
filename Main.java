import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Wilfredo Gallegos
 * @author Guillermo Furlan
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vista vista =  new Vista();
        Floyd floyd = new Floyd();

        ArrayList<String> ciudades = new ArrayList<String>();

        System.out.println("Lo que hay en el guategrafo.txt\n");
        try{
            FileReader r = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(r);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                System.out.println(temp);
                String[] data = temp.split(" ");
                Rutas rutas = new Rutas(data[0],data[1],data[2]);
                //corroborando el vertice de la ciudad 1
                if (!ciudades.contains(rutas.ubiSalida)){
                    ciudades.add(rutas.ubiSalida);
                }

                if (!ciudades.contains(rutas.ubiFinal)){
                    ciudades.add(rutas.ubiFinal);
                }

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }

        Grafo grafo = new Grafo(ciudades.size());

        try{
            FileReader r = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(r);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                
                String[] data = temp.split(" ");
                Rutas rutas = new Rutas(data[0],data[1],data[2]);
                if (!ciudades.contains(rutas.ubiSalida)){
                    ciudades.add(rutas.ubiSalida);
                }

                if (!ciudades.contains(rutas.ubiFinal)){
                    ciudades.add(rutas.ubiFinal);
                }

                int km = rutas.getKm();
                
                for (int i = 0; i < km; i++){
                    grafo.nuevaCiudad(ciudades.indexOf(rutas.ubiSalida), ciudades.indexOf(rutas.ubiFinal));
                    grafo.nuevaCiudad(ciudades.indexOf(rutas.ubiFinal), ciudades.indexOf(rutas.ubiSalida));
                }

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }
        System.out.println("\nNombres de las ciudades con el numero de vertice asignado\n");
        for (int i=0;i<ciudades.size();i++){
            System.out.print(ciudades.get(i)+"\t");
            System.out.print(ciudades.indexOf(ciudades.get(i)));
            System.out.println();
        }

        System.out.println("\nMatriz de adyacencia entre ciudades\n");

        grafo.imprimir();

        System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

        grafo.print();

        System.out.println(floyd.Floyd(ciudades,grafo .retornar()));


        boolean ciclo = true;
        while (ciclo==true){
            vista.bienvenida();

            int opcion = vista.MenuOpciones();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la ciudad de llegada");
                    String origen = scan.nextLine();
                    System.out.println("Ingrese la ciudad de salida");
                    String destino = scan.nextLine();
                    System.out.println("Ingrese la cantidad de kilometros");
                    int km = Integer.parseInt(scan.nextLine());
                    if (!ciudades.contains(origen)){
                        ciudades.add(origen);
                    }
                    if (!ciudades.contains(destino)){
                        ciudades.add(destino);
                    }   grafo = new Grafo(ciudades.size());
                    try{
                        FileReader r = new FileReader("guategrafo.txt");
                        BufferedReader buffer = new BufferedReader(r);
                        
                        String temp ="";
                        
                        while(temp!=null){
                            temp = buffer.readLine();
                            if(temp == null){
                                break;
                            }
                            String[] data = temp.split(" ");
                            Rutas rutas =  new Rutas(data[0],data[1],data[2]);
                            if (!ciudades.contains(rutas.ubiSalida)){
                                ciudades.add(rutas.ubiSalida);
                            }
                            
                            if (!ciudades.contains(rutas.ubiFinal)){
                                ciudades.add(rutas.ubiFinal);
                            }
                            
                            
                            int kms = rutas.getKm();
                
                            for (int i = 0; i < kms; i++){
                                grafo.nuevaCiudad(ciudades.indexOf(rutas.ubiSalida), ciudades.indexOf(rutas.ubiFinal));
                                grafo.nuevaCiudad(ciudades.indexOf(rutas.ubiFinal), ciudades.indexOf(rutas.ubiSalida));
                            }
                            
                        }
                    }catch(Exception e){
                        System.out.println("archivo no encontrado");
                    }   for (int i=0;i<km;i++){
                        grafo.nuevaCiudad(ciudades.indexOf(origen),ciudades.indexOf(destino));
                        grafo.nuevaCiudad(ciudades.indexOf(destino),ciudades.indexOf(origen));
                    }   System.out.println("Se ha agregado a la matriz");
                    System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");
                    grafo.print();
                    break;
                case 2:
                    Floyd fl = new Floyd();
                    System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");
                    grafo.print();
                    System.out.println(fl.Floyd(ciudades,grafo.retornar()));
                    break;
                case 3:
                    Floyd flo = new Floyd();
                    System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");
                    grafo.print();
                    System.out.println(flo.Floyd(ciudades,grafo.retornar()));
                    break;
                case 4:
                    vista.despedida();
                    ciclo=false;
                    break;
                default:
                    break;
            }
        }
    }
}
