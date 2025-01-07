package rahulShettyAcademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsontoHashmap {
	
	public List<HashMap<String, String>> getDatafromJson() throws IOException {
		
		//convertJsonContent to String
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulShettyAcademy\\data\\SubmitOrder.json");
		String jsonContent = FileUtils.readFileToString(file,StandardCharsets.UTF_8);
		
		
		//convertStringtoHashmap
	    ObjectMapper objmapper = new ObjectMapper();
	    
	    List<HashMap<String,String>> data =  objmapper.readValue(file,new TypeReference<List<HashMap<String,String>>>() {});
	    return data;
		
		}
	    
	
	    
	
	
	

}
