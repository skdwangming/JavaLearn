import java.io.*;

public class SerializableMain {
    public static void main(String[] args) throws Exception {
        //序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("demo.obj"));
        objectOutputStream.writeObject(new SerializableDemo());
        objectOutputStream.close();

        //反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("demo.obj"));
        SerializableDemo se = (SerializableDemo)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(se.toString());
    }
}
