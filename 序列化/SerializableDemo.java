import java.io.Serializable;

public class SerializableDemo implements Serializable {
    private static final long serialVersionUID = 1L;
    String name = "王铭";
    transient String sex = "男";
    int age = 24;
    static int salary = 100;

    @Override
    public String toString() {
        return "SerializableDemo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
