package javaapi;

public enum EnumTest {
    ENUM1(1),
    ENUM2(2),
    ENUM3(3),
    EMPTY(0);

    private int code;

    private EnumTest(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
    public EnumTest getEnum(int code){
        for (EnumTest enumTest : EnumTest.values()) {
            if(code == enumTest.code){
                return enumTest;
            }
        }
        return EMPTY;
    }
}
