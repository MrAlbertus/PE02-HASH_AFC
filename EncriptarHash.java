import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;

public class EncriptarHash {

    // li dono un text i retorna el seu hash SHA-256 en hexadecimal
    public static String calcularHash(String text) {
        try {
            // Instanciem la classe per fer el hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convertim l'string a un array de bytes
            byte[] bytesIn = text.getBytes(StandardCharsets.UTF_8);

            // Calculem el hash, que surti sempre 32 bytes
            byte[] hash = md.digest(bytesIn);

            // Convertim el hash a hexadecimal per mostrar-lo
            return HexFormat.of().withUpperCase().formatHex(hash);


        } catch (Exception e) {
            return null; //necesita el return
        }

    }
}

