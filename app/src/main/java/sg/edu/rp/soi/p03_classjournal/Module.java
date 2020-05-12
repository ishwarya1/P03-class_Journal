package sg.edu.rp.soi.p03_classjournal;

import java.io.Serializable;

public class Module implements Serializable {
    private String name;
    private String code;
    public Module(String name, String code) {
        this.name = name;
        this.code = code;
    }
    public String getCode() { return code; }

    public String getName() { return name; }

}
