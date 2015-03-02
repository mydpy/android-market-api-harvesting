package harvester;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetLoginCredentials {
	static final String path = "/home/cloudera/git/android-market-api-harvesting/android-market-api-harvesting/data/mylesdanielbaker";
	private String password;
	private String email = "mylesdanielbaker@gmail.com"; 
	private String androidId; 
	static int ch; 
	
	public GetLoginCredentials() throws IOException{
		File file = new File(path);
	    StringBuffer stringBuffer = new StringBuffer("");
	    try {
	        FileInputStream fileInputStream = new FileInputStream(file);
	        try {
	            while((ch = fileInputStream.read())!= -1){
	                stringBuffer.append((char)ch);  
	            }
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    password = stringBuffer.toString(); 
	}
	
	public void decryptPassword(String secret){
		//To-Do
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail(){
		return email; 
	}
	
	public String getAndroidId(){
		return androidId; 
	}

}
