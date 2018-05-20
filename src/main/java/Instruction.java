public class Instruction {
    private final String write;
    private final String move;
    private final String nextState;
    
    public Instruction(String write, String move, String nextState) {
    	this.write = write;
    	this.move = move;
    	this.nextState = nextState;
    }
    
    public String getWrite() {
    	return this.write;
    }
    
    public String getMove() {
    	return this.move;
    }
    
    public String getNextState() {
    	return this.nextState;
    }
    
    public String toString() {
    	return String.format("write: %s; move: %s, next: %s", this.write, this.move, this.nextState);
    }
}