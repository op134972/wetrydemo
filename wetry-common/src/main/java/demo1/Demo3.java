package demo1;

public class Demo3 {


    public static char fun(String str){
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(str.indexOf(chars[i]+"")==str.lastIndexOf(chars[i]+"")){
                return chars[i];
            }
        }

        return '|';
    }

    public static void main(String[] args) {
        String str = "eello";
        System.out.println(fun(str));

        for (int i = 0; i < 99; i++) {
            System.out.print(","+i);
        }
    }


}
