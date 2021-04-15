package serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;



//1. Implement Serializable
public class SerializationBasic implements java.io.Serializable{

	/**
	 * 2.declare version UID to a non-generated value
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/***
	 * 3. fields not necessary to be serialized are to be transient
	 */
	private transient String className="SerializationBasic";
	
	/*
	 * SERIALIZE:used to write additional things/custom serialization logic
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException{
		
	}
	
	/*
	 * DESERIALIZE: use to read additional things/custom deserialization logic
	 */
	private void readObject(ObjectOutputStream oos) throws IOException{
		
	}
	
	//writeExternal() and readExternal()  
	/*
	 * implemente Externalizable. ..you have full control
	 */
	
	
	
	/*
	 * used to return a different object while deserializing
	 * @return
	 */
	private Object readResolve(){
		return null;
	}
	
	/*
	 * used to write a different object while serializing
	 * @return 
	 */
	private Object writeReplace() {
		return null;
	}
}
