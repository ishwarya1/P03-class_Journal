package sg.edu.rp.soi.p03_classjournal;

import java.io.Serializable;

public class Module implements Serializable {
    private String name;
    private String code;
    public Module(String code, String name) {
        this.name = name;
        this.code = code;
    }
    public String getCode() { return code; }

    public String getName() { return name; }

}
