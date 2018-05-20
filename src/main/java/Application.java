import java.util.HashMap;

public class Application {
	public static void main(String[] args) {
		Machine machine = new Machine();
		
//		HashMap<String, Instruction> instructions = InstructionListJsonParser.parse("sb_instructions.json");
		HashMap<String, Instruction> instructions = InstructionListJsonParser.parse("adder_instructions.json");
		
		machine.execute(instructions);
	}
}