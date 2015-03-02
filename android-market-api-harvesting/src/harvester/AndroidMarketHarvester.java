package harvester;

import java.io.IOException;
import com.gc.android.market.api.*;
import com.gc.android.market.api.MarketSession.*; 
import com.gc.android.market.api.model.Market.*;

public class AndroidMarketHarvester {
	
	public static void FindApplication(String appId, boolean comments){
		MarketSession session = new MarketSession(); 
		try{
			GetLoginCredentials gpw = new GetLoginCredentials();
			session.login(gpw.getEmail(), gpw.getPassword());
		}
		catch(IOException e){
			System.out.println("Exception decrypting password");
		}

		AppsRequest appsRequest = AppsRequest.newBuilder()
		                                .setStartIndex(0).setEntriesCount(10)
										.setAppId(appId)
		                                .setWithExtendedInfo(true)
		                                .build();
	
		session.append(appsRequest, new Callback<AppsResponse>() {
	         @Override
	         public void onResult(ResponseContext context, AppsResponse response) {
	                  System.out.println("Response : " + response);
	                  
	         }
		});
	
		if(comments){
			CommentsRequest commentsRequest = CommentsRequest.newBuilder()
	                .setAppId(appId)
	                .setStartIndex(0)
	                .setEntriesCount(10)
	                .build();
	
			session.append(commentsRequest, new Callback<CommentsResponse>() {
					@Override
					public void onResult(ResponseContext context, CommentsResponse response) {
							System.out.println("Response : " + response);
							// response.getComments(0).getAuthorName()
							// response.getComments(0).getCreationTime()
							// ...
					}
			});
		}
		session.flush();
	}
	
	public static void main(String[] args) {
		String actionPotato = "net.sunflat.android.actionpotato"; 		
		FindApplication(actionPotato, false); 

	}

}
