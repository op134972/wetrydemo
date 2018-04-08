package demo1;

public class BuilderMode {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    public BuilderMode(){

    }

    private BuilderMode(Builder builder) {
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
        e = builder.e;
        f = builder.f;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BuilderMode copy) {
        Builder builder = new Builder();
        builder.a = copy.a;
        builder.b = copy.b;
        builder.c = copy.c;
        builder.d = copy.d;
        builder.e = copy.e;
        builder.f = copy.f;
        return builder;
    }

    public static final class Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;

        private Builder() {
        }

        public Builder a(String val) {
            a = val;
            return this;
        }

        public Builder b(String val) {
            b = val;
            return this;
        }

        public Builder c(String val) {
            c = val;
            return this;
        }

        public Builder d(String val) {
            d = val;
            return this;
        }

        public Builder e(String val) {
            e = val;
            return this;
        }

        public Builder f(String val) {
            f = val;
            return this;
        }

        public BuilderMode build() {
            return new BuilderMode(this);
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

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public static void main(String[] args) {
        BuilderMode bm = BuilderMode.newBuilder().a("a").b("b").c("c").build();
        System.out.println(bm);
    }
}