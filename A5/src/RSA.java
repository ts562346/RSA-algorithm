public class RSA {
    private final int n;
    private final int m;
    public RSA(int p, int q) {
        this.n = p*q;
        this.m = (p-1)*(q-1);
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public int [] gcdExtended (int a, int b){
        int[] result = new int[3];
        if (b == 0) {
            result[0] = a;
            result[1] = 1;
        } else {
            int[] temp = gcdExtended(b, a % b);
            result[0] = temp[0];
            result[1] = temp[2];
            result[2] = temp[1] - (a / b) * temp[2];
        }
        return result;
    }

    public Pair getPublicKey(){
        int a = 2;
        while (gcd(a, m) != 1) {
            a = a + 1;
        }
        return new Pair(a,n);
    }

    public Pair getPrivateKey(int e){
        int [] result = gcdExtended(e, m);
        if (result[1] < 0){
            result[1] = result[1] + m;
        }
        return new Pair (result[1],n);
    }

    public int modExpon(int x, int y, int p) {
        int res = 1;

        while (y > 0) {
            if(y % 2 ==1){
                res = (res * x) % p;
            }

            x = (x * x )%p;
            y = y/2;
        }

        return res;
    }

    public int encrypt(Pair key, int plaintext){
        return (int) (Math.pow(plaintext,key.getX())%key.getY());
    }

    public int decrypt(Pair key, int ciphertext){
        return modExpon(ciphertext, key.getX(), key.getY());
    }

}
