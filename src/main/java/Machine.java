import java.util.ArrayList;
import java.util.Map;

public class Machine {	
	private short tapeLimit = 20;
	private int head = 0;
	private String state = "s1";
	private ArrayList<String> tape = new ArrayList<String>();
	
	public Machine() {
		this.initializeTape();
	}
	
	private void initializeTape() {
		for (int i = 0; i < tapeLimit; i++) {
			this.tape.add("b");
		}
	}
	
	private void logState() {
		System.out.println(String.format("%s: %s", this.state, String.join("", this.tape)));
		
		String buffer = "   ";
		for (int j = 0; j <= this.head; j++) {
			buffer = buffer + " ";
		}
		System.out.println(buffer + "^");
	}
	
	void execute(Map<String, Instruction> instructions) {
		for (int i = 0; i < tapeLimit; i++) {
			this.logState();
			String instructionKey = String.format("%s_%s", this.state, this.tape.get(this.head));
			Instruction instruction = instructions.get(instructionKey);
			if (instruction == null) {
				System.out.println(String.format("REJECTED: %s does not have a corresponding instruction key", instructionKey));
				return;
			}
			String write = instruction.getWrite();
			this.tape.set(this.head, write);
			this.state = instruction.getNextState();
			this.head = instruction.getMove().equals("l") ? this.head - 1 : this.head + 1;
		}
	}
}