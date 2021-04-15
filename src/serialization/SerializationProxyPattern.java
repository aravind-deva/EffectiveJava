package serialization;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class SerializationProxyPattern implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String myName;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public SerializationProxyPattern(String name) {
		myName = name;
	}

	/**
	 * step 1:serialize the proxy not the original
	 * 
	 * @return
	 */
	private Object writeReplace() {
		return new MyProxy(this);
	}

	private static class MyProxy implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String proxyName;

		/*
		 * constructor which takes enclosing class as the parameter
		 */
		MyProxy(SerializationProxyPattern sp) {
			this.proxyName = sp.myName;
		}

		/**
		 * Step2: deserialize -> return enclosing class
		 */
		private Object readResolve() {
			return new SerializationProxyPattern(this.proxyName);
		}
	}

	/**
	 * step3: Since the proxy was serialized , this read methods should never be called
	 * 
	 * @throws InvalidObjectException
	 */
	private void readObject() throws InvalidObjectException {
		throw new InvalidObjectException("Proxy required");

	}
}
