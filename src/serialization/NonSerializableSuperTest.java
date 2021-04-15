package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializableSuperTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerializableSubClass sp = new SerializableSubClass("Phoenix", "5A", 1, "Aravind");
		FileOutputStream serializationFile = new FileOutputStream("D:\\myserialize.ser");
		ObjectOutputStream oos = new ObjectOutputStream(serializationFile);
		oos.writeObject(sp);
		oos.close();
		FileInputStream sFile = new FileInputStream("D:\\myserialize.ser");
		ObjectInputStream ois = new ObjectInputStream(sFile);
		SerializableSubClass sp2 = (SerializableSubClass) ois.readObject();
		ois.close();
		System.out.println("From Deserialization" + sp2.toString());
	}

}
