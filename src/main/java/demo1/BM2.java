package demo1;

public class BM2 {
    private String a;
    private String b;
    private String c;
    BM2(){}
    BM2(Builder builder){
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }
    public static Builder newBuilder(){
        return new Builder();
    }

    public static class Builder{
        private String a;
        private String b;
        private String c;

        Builder a(String val){
            this.a = val;
            return this;
        }
        Builder b(String val){
            this.b = val;
            return this;
        }
        Builder c(String val){
            this.c = val;
            return this;
        }
        BM2 build(){
            return new BM2(this);
        }

    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public static void main(String[] args) {
        BM2 bm2 = BM2.newBuilder().a("a").b("b").build();


        System.out.println(bm2.getA());
    }
}
