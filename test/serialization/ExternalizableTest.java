package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ExternalizableObj sp = new ExternalizableObj("Shreshti");
		FileOutputStream serializationFile = new FileOutputStream("C:\\myserialize.ser");
		ObjectOutputStream oos = new ObjectOutputStream(serializationFile);
		oos.writeObject(sp);
		oos.close();
		FileInputStream sFile = new FileInputStream("C:\\myserialize.ser");
		ObjectInputStream ois = new ObjectInputStream(sFile);
		ExternalizableObj sp2 = (ExternalizableObj) ois.readObject();
		ois.close();
		System.out.println("From Deserialization" + sp2.getMy_name());

	}

}
