package serialization;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableObj implements java.io.Externalizable {

	String my_name;

	/**
	 * THE FRAMEWORK REQUIRED A PARAMETER LESS CONSTRUCTOR.
	 * http://www.jusfortechies.com/java/core-java/externalization.php when an
	 * Externalizable object is reconstructed, an instance is created first
	 * using the public no-arg constructor, then the readExternal method is
	 * called
	 */
	public ExternalizableObj() {

	}

	public ExternalizableObj(String my_name) {
		super();
		this.my_name = my_name;
	}

	/**
	 * 
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		this.my_name = in.readUTF();
	}

	public String getMy_name() {
		return my_name;
	}

	/**
	 * The default serializable format includes metadata of the current class, its super classes and so on  along with data
	 * The externalizable object can decide the format of the serialized object.
	 * Has performance improvements
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		// out.writeBytes(my_name);
		out.writeUTF(my_name);
	}

}
