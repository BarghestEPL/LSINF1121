public class RabinKarp{
    //TODO by student: many things are not correct here
    private String[] pat;       // pattern (only needed for Las Vegas)
    private long[] patHash;     // pattern hash value
    private int M;              // pattern length
    private long Q;             // a large prime
    private int R = 2048;       // alphabet size
    private long RM;            // R^(M-1) % Q

    public RabinKarp(String pat){
        this(new String[]{pat});
    }

    public RabinKarp(String[] pat){
        //TODO by student: it's obviously not correct
        this.pat = pat;
        this.M = pat[0].length();
        Q = 4463;
        RM = 1;

        // Compute R^(M-1) % Q for use
        for (int i = 1; i <= M-1; i++){
            RM = (R * RM) % Q;
        }


        patHash = new long[pat.length];
        for (int i = 0; i < pat.length; i++) {
            patHash[i] = hash(pat[i], M);
        }
    }


    public boolean check(int i, String txt){
        //TODO by student:SS
        for (String s : pat){
            if (s.equals(txt.substring(i, i + M)))
                return true;
        } return false;
    }

    private long hash(String key, int M){           // Compute hash for key[0..M-1].
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }


    public int search(String txt){
        //TODO by student:
        int N = txt.length();
        long txtHash = hash(txt, M);

        for (int i = 0; i < patHash.length; i++){
            if(patHash[i] == txtHash) return N;
        }

        for (int i = M; i < N; i++){
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;

            for (int j = 0; j < patHash.length; j++){
                if (patHash[j] == txtHash)
                    if (check(i - M + 1, txt)) return i - M + 1;
            }
        }
        return N;
    }
}