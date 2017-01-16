package machine.emulator.cmd;

@SuppressWarnings("serial")
public 	class InvalidCommand extends Exception {
	public InvalidCommand() { super(); }
	  public InvalidCommand(String message) { super(message); }
	  public InvalidCommand(String message, Throwable cause) { super(message, cause); }
	  public InvalidCommand(Throwable cause) { super(cause); }
}

