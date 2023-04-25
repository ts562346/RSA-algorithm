import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner readme = new Scanner(System.in);

        System.out.print("Enter the prime numbers, p and q: ");
        int p = readme.nextInt();
        int q = readme.nextInt();

        RSA rsa = new RSA(p,q);
        System.out.println("\nCalculating RSA values ...");

        Pair publicKey = rsa.getPublicKey();
        System.out.println("\nPublic RSA key is " + publicKey.toString());

        Pair privateKey = rsa.getPrivateKey(publicKey.getX());
        System.out.println("Private RSA key is " + privateKey.toString());

        System.out.print("\nEnter the plaintext message m (an integer): ");
        int m = readme.nextInt();

        System.out.println("\nEncrypting m …");

        int c = rsa.encrypt(publicKey, m);
        System.out.println("The ciphertext c is " + c);

        System.out.println("\nDecrypting c …");

        m = rsa.decrypt(privateKey, c);
        System.out.println("The plaintext m is " + m);
    }
}