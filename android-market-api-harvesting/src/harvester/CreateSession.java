package harvester;

import java.io.IOException;
import com.gc.android.market.api.MarketSession;

public class CreateSession {
	public MarketSession session; 
		CreateSession(){
			try{
				GetLoginCredentials gpw = new GetLoginCredentials();
				session = new MarketSession();
				session.login(gpw.getEmail(), gpw.getPassword());
			}
			catch(IOException e){
				System.out.println("Exception decrypting password");
			}
			
		}
	}

