import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InstructionListJsonParser {
	public static HashMap<String, Instruction> parse(String path) {
		HashMap<String, Instruction> instructions = new HashMap<String, Instruction>();
		File file = new File(path);
		
		if (file.exists()) {
			InputStream inputStream = null;
			String jsonTxt = null;

			try {
				inputStream = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				jsonTxt = IOUtils.toString(inputStream, "UTF-8");
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(jsonTxt);
			
			try {
				JSONArray json = new JSONArray(jsonTxt);
				for (int i = 0; i < json.length(); i++) {
					Object instructionObject = json.get(i);
					JSONObject instructionJson = ((JSONObject)instructionObject);
					String write = instructionJson.getString("write");
					String move = instructionJson.getString("move");
					String nextState = instructionJson.getString("nextState");
					Instruction instruction = new Instruction(write, move, nextState);
					instructions.put(instructionJson.getString("key"), instruction);
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return instructions;
	}
}
