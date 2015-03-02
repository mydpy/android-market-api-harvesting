package demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetEncryptedPassword {

	private String password;
	static int ch; 
	
	public GetEncryptedPassword(){
		password = null; 
	}
	
	public GetEncryptedPassword(String path) throws IOException{
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
		
	}

	public String getPassword() {
		return password;
	}

}
