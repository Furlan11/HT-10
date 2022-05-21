
/**
 *
 * 
 */
public class Rutas {
    public String ciudad1 = "";
    public String ciudad2 = "";
    int km = 0;
    
    public Rutas(String a, String b, String c){
        ciudad1 = a;
        ciudad2 = b;
        km = Integer.parseInt(c);
    }
    
    @Override
    public String toString(){
        return "Conexión{" +
                "ciudad 1 = " + ciudad1 + '\'' +
                ", ciudad 2 = " + ciudad2 + '\'' +
                ", km = " + km +
                '}';
    }
}
