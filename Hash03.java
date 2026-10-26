import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.Scanner;

public class Hash03 {

    //Utilitzaré SecureRandom per fer el salt
    //Utilitzaré HashMap per guardar en la memoria
    // hashmap funciona així, fa "usuari -> salt i hash"
    static HashMap<String, String[]> usuaris = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcio = "";

        //PART 3 i 4
        while (!opcio.equals("0")) {
            System.out.println("1 - Registrar");
            System.out.println("2 - Login");
            System.out.println("0 - Sortir");
            opcio = sc.nextLine();

            if (opcio.equals("1")) {
                registrar(sc);
            } else if (opcio.equals("2")) {
                login(sc);
            }
        }

        sc.close();
    }

    //PART 3
    public static void registrar(Scanner sc) {
        System.out.print("Usuari : ");
        String usuari = sc.nextLine();
        System.out.print("Contrasenya : ");
        String contrasenya = sc.nextLine();

        // salt aleatoria en 16 bytes (he posat 16 perque es el recomenat)
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        String salt = HexFormat.of().withUpperCase().formatHex(saltBytes);

        // hash de salt + contrasenya
        String hash = EncriptarHash.calcularHash(salt + contrasenya);

        usuaris.put(usuari, new String[]{salt, hash});

        System.out.println("Salt: " + salt);
        System.out.println("Hash: " + hash);
    }

    //PART 4
    public static void login(Scanner sc) {
        System.out.print("Usuari : ");
        String usuari = sc.nextLine();
        System.out.print("Contrasenya : ");
        String contrasenya = sc.nextLine();

        if (usuaris.containsKey(usuari)) {
            String salt = usuaris.get(usuari)[0];
            String hashGuardat = usuaris.get(usuari)[1];

            // tornem a fer el hash amb la salt guardada
            String hash = EncriptarHash.calcularHash(salt + contrasenya);

            if (hash.equals(hashGuardat)) {
                System.out.println("Login correcte!");
            } else {
                System.out.println("Contrasenya incorrecta");
            }
        } else {
            System.out.println("L'usuari no existeix");
        }
    }
}