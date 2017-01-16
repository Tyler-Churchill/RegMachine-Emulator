package machine.emulator.memory;

@SuppressWarnings("serial")
public
class InvalidRegister extends Exception {
	public InvalidRegister() { super(); }
	  public InvalidRegister(String message) { super(message); }
	  public InvalidRegister(String message, Throwable cause) { super(message, cause); }
	  public InvalidRegister(Throwable cause) { super(cause); }
}
