import java.util.Scanner;

public class Hash01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //PART 1
        System.out.println("PART 1:");
        System.out.println("PUNT 1, hash d'un missatge: ");
        punt1HashUnMissatge(sc);
        System.out.println("PUNT 2, comparar dos missatges: ");
        punt2CompararDos(sc);
        System.out.println("PUNT 3: modificar el missatge i tornar a calcular el hash: ");
        punt3ModificarMissatge(sc);
        System.out.println("PUNT 4: calcular el hash varies vegades: ");
        punt4RepetirHash(sc);

        sc.close();
    }

    //PUNT 1: hash d'un missatge
    public static void punt1HashUnMissatge(Scanner sc) {
        System.out.print("Entra un missatge: ");
        String text = sc.nextLine();

        // Calculem el hash
        String hash = EncriptarHash.calcularHash(text);
        System.out.println("Hash: " + hash);
    }

    //PUNT 2: comparar dos missatges
    public static void punt2CompararDos(Scanner sc) {
        System.out.print("Entra text1: ");
        String text1 = sc.nextLine();
        System.out.print("Entra text2: ");
        String text2 = sc.nextLine();

        // Calculem el hash dels dos
        String hash1 = EncriptarHash.calcularHash(text1);
        String hash2 = EncriptarHash.calcularHash(text2);

        System.out.println("Text1 Hash: " + hash1);
        System.out.println("Text2 Hash: " + hash2);

        // Mirem si son iguals
        if (hash1.equals(hash2)) {
            System.out.println("Mateix hash!");
        } else {
            System.out.println("Diferent hash :(");
        }
    }

    //PUNT 3: modificar el missatge i tornar a calcular
    public static void punt3ModificarMissatge(Scanner sc) {
        System.out.print("Entra el missatge original: ");
        String original = sc.nextLine();
        String hashOriginal = EncriptarHash.calcularHash(original);
        System.out.println("Hash original:  " + hashOriginal);

        //MODIFICAR DADA
        System.out.print("Entra el missatge modificat: ");
        String modificat = sc.nextLine();
        String hashModificat = EncriptarHash.calcularHash(modificat);
        System.out.println("Hash modificat: " + hashModificat);

        // Comparem l'original amb el modificat
        if (hashOriginal.equals(hashModificat)) {
            System.out.println("Mateix hash, no has canviat res");
        } else {
            System.out.println("Hash diferent, el missatge s'ha modificat");
        }
    }

    //PUNT 4: calcular el hash varies vegades
    public static void punt4RepetirHash(Scanner sc) {
        System.out.print("Entra un missatge: ");
        String text = sc.nextLine();

        // Guardem el primer per comparar
        String primerHash = EncriptarHash.calcularHash(text);

        // Ho fem 5 vegades
        for (int i = 1; i <= 5; i++) {
            String hash = EncriptarHash.calcularHash(text);

            if (hash.equals(primerHash)) {
                System.out.println("Vegada " + i + ": " + hash + " (igual)");
            } else {
                System.out.println("Vegada " + i + ": " + hash + " (DIFERENT)");
            }
        }
    }
}