package machine.emulator.memory;

public class Memory {

	private int[] registers;
	private int nReg;

	public Memory() {
		this.nReg = 2;
		registers = new int[nReg];
		registers[0] = 4;
		registers[1] = 1;
	}
	public void put(int regN, int val) {
		try {
			registers[regN] = val;
		} catch (IndexOutOfBoundsException e) {
			// lazy growth
			int[] rTemp = registers;
			int[] rNew = new int[nReg += 1];
			for (int x = 0; x < (nReg - 1); x++) {
				rNew[x] = rTemp[x];
			}
			registers = rNew;
			registers[regN] = val;
		}
	}
	
	public void clearMemory() {
		for(int x = 0; x < registers.length; x++) {
			registers[x] = 0;
		}
	}

	public int get(int regN) throws InvalidRegister {
		try {
			return registers[regN - 1];
		} catch (IndexOutOfBoundsException e) {
			throw new InvalidRegister("[ERROR] Tried getting an invalid register");
		}
	}
	
	public void set(int regN, int val) throws InvalidRegister {
		try {
			registers[regN - 1] = val;
		} catch (IndexOutOfBoundsException e) {
			throw new InvalidRegister("[ERROR] Tried setting an invalid register");
		}
	}
	
	public int getNumReg() {
		return nReg;
	}
	
	public void printState() {
		for(int y = 0; y < registers.length; y++) {
			System.out.print(registers[y] + "\t\t");
			if(y % registers.length - 1 == 0)
				System.out.print("\n");
		}
	}
	public void printRegNames() {
		for(int x = 0; x < registers.length; x++) {
			System.out.print("Reg" + (x + 1) + "\t\t");
			if(x % registers.length - 1 == 0)
				System.out.print("\n");
		}
	}
	
}
