package demo1;


import org.apache.commons.lang3.StringUtils;

public class JudgeStringBlank {
    public static void main(String[] args) {
        String str = "   ";
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(StringUtils.isBlank(str));


    }
}
