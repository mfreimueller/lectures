import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.Scanner;

public class PasswordHashing {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        var password = scanner.nextLine();

        var hash = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        System.out.println("Hash: " + hash);

        System.out.print("Enter password again: ");
        var verify = scanner.nextLine();

        var result = BCrypt.verifyer().verify(verify.toCharArray(), hash);
        System.out.println(result.verified ? "Password matches" : "Password does not match");
    }
}
