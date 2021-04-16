package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationProxyPattTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerializationProxyPattern sp = new SerializationProxyPattern("Aravind");
		FileOutputStream serializationFile = new FileOutputStream("C:\\myserialize.ser");
		ObjectOutputStream oos = new ObjectOutputStream(serializationFile);
		oos.writeObject(sp);
		oos.close();
		FileInputStream sFile = new FileInputStream("C:\\myserialize.ser");
		ObjectInputStream ois = new ObjectInputStream(sFile);
		SerializationProxyPattern sp2 = (SerializationProxyPattern) ois.readObject();
		ois.close();
		System.out.println("From Deserialization" + sp2.getMyName());

	}

}
