package serialization;

import java.util.concurrent.atomic.AtomicReference;

public class NonSerializableSuperClass {
	private String school;
	private String section;

	// This enum and field are used to track initialization
	private enum State {
		NEW, INITIALIZING, INITIALIZED
	};

	private final AtomicReference<State> init = new AtomicReference<State>(State.NEW);

	public NonSerializableSuperClass(String school, String section) {
		super();
		/*
		 * this.school = school; this.section = section;
		 */
		initialize(school, section);
	}

	/**
	 * this was necessary to avoid InvalidClassException no valid constructor Q)
	 * When & why do we need parameter less constructor? A) When a super class
	 * is non serializable - The sub class is deserialized and since super class
	 * is not serializable,super class has to be constructed using a
	 * constructor. Runtime does not know about parameterized constructors.so we
	 * need a parameter less constructor
	 */
	public NonSerializableSuperClass() {
		super();
	}

	/**
	 * The initialization method has the same parameters as the normal
	 * constructor and establishes the same invariants.
	 **/

	protected final void initialize(String school, String section){
		if (!init.compareAndSet(State.NEW, State.INITIALIZING))
			throw new IllegalStateException(
			"Already initialized");
			this.school = school;
			this.section = section;
			// Do anything else the original constructor did
			init.set(State.INITIALIZED);
	}
	
	
	// These methods provide access to internal state so it can
	// be manually serialized by subclass's writeObject method.
	protected final String getSchool() { checkInit(); return school; }
	protected final String getSection() { checkInit(); return section; }
	
	// Must call from all public and protected instance methods
	private void checkInit() {
	if (init.get() != State.INITIALIZED)
	throw new IllegalStateException("Uninitialized");
	}
	
}
