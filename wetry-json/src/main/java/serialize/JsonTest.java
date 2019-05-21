package serialize;

public class JsonTest {


    /*
    *
    * */

    public static void main(String[] args) {
        System.out.println(fun("hello","hel"));
    }

    public static boolean fun(String source, String target) {
        char[] chars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        int ti = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == targetChars[ti]) {
                ti++;
                if (ti == targetChars.length) {
                    return true;
                }
            }else{
                ti = 0;
            }
        }
        return false;
    }

    /**
     * int kmp(char *t, char *p) {
     *     int *f = fail(p);
     *     int i, j;
     *     for(i = 0, j = 0; i < strlen(t) && j < strlen(p); ) {
     *         if(t[i] == p[j]) {
     *             i++;
     *             j++;
     *         }
     *         else if(j == 0)
     *             i++;
     *         else
     *             j = f[j-1] + 1;
     *     }
     *     return j == strlen(p) ? i - strlen(p) : -1;
     * }
     */
}
