package annotation.person;

import annotation.Nation;

/**
 * Created by wch on 18-8-16.
 */
public class HanPerson extends Person {

    @Nation()
    private String nation;

    public HanPerson() {
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
