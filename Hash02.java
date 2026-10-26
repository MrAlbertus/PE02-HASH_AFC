import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Hash02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //PART 2
        System.out.println("PART 2:");
        verificarIntegritat(sc);

        sc.close();
    }

    public static void verificarIntegritat(Scanner sc) {
        try {
            System.out.print("Entra el missatge : ");
            String missatge = sc.nextLine();

            // Guardem el missatge al fitxer
            Files.writeString(Path.of("missatge.txt"), missatge); //Igual que el missatge.hash, writeString crea missatge.txt e inserta el missatge que hem posat.

            // Calculem el hash i el guardem al .hash
            String hash = EncriptarHash.calcularHash(missatge);
            Files.writeString(Path.of("missatge.hash"), hash); // writeString crea i escriu el hash (el que hem posat) en el fitxer (si hi ha algo ho reescriu)

            System.out.println("Hash: " + hash);

            // llegim el fitxer que ens diguin
            System.out.print("Nom del fitxer : ");
            String nomFitxer = sc.nextLine();

            String text = Files.readString(Path.of(nomFitxer)); //readString et torna TOT el document d'una
            String hashText = EncriptarHash.calcularHash(text);

            // Agafem el hash que haviem guardat
            String hashGuardat = Files.readString(Path.of("missatge.hash"));

            System.out.println("Hash guardat: " + hashGuardat);
            System.out.println("Hash fitxer: " + hashText);

            if (hashText.equals(hashGuardat)) {
                System.out.println("Mateix hash!");
            } else {
                System.out.println("Diferent hash, el missatge s'ha modificat :O ");
            }

        } catch (IOException e) { // al utilitzar writeString i/o readString demana si o si el try/catch
            System.out.println("Error amb el fitxer"); 
        }
    }
}