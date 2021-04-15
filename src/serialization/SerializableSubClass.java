package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableSubClass extends NonSerializableSuperClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private int rollnumber;
	private String name;

	public SerializableSubClass(String school, String section, int rollnumber, String name) {
		super(school, section);
		this.rollnumber = rollnumber;
		this.name = name;
	}

	@Override
	public String toString() {
		return "SerializableSubClass [rollnumber=" + rollnumber + ", name=" + name + ", school=" + getSchool()
				+ ", section=" + getSection() + "]";
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeUTF(getSchool());
		oos.writeUTF(getSection());
	}

	/*
	 * DESERIALIZE: use to read additional things/custom deserialization logic
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		/*
		 * school=ois.readUTF(); section=ois.readUTF();
		 */
		initialize(ois.readUTF(), ois.readUTF());

	}
}
