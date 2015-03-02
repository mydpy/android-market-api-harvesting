package demo;

import java.io.IOException;

import com.gc.android.market.api.*;
import com.gc.android.market.api.MarketSession.*; 
import com.gc.android.market.api.model.Market.*;

public class FindDevelopers {
	
	public static void main(String[] args) {
		String email = "mylesdanielbaker@gmail.com", password = null; 
		try{
			GetEncryptedPassword gpw = new GetEncryptedPassword("/home/cloudera/git/android-market-api-harvesting/android-market-api-harvesting/data/mylesdanielbaker");
			password = gpw.getPassword();
		}
		catch(IOException e){
			System.out.println("Exception decrypting password");
		}
	
		MarketSession session = new MarketSession();
		session.login(email,password);
		//session.getContext.setAndroidId(myAndroidId);

		String query = "Pet Ideas - Minecraft";
		String actionPotato = "net.sunflat.android.actionpotato"; 
		String lootDungeon = "com.dinjon.lootdungeon";
		String mimeGames = "com.minegames.pet";
		String sampleId = "7065399193137006744"; 
		
		
		String appId = mimeGames; 
		AppsRequest appsRequest = AppsRequest.newBuilder()
		                                .setQuery(query)
		                                .setStartIndex(0).setEntriesCount(10)
										//.setAppId(appId)
		                                .setWithExtendedInfo(true)
		                                .build();
		                       
		session.append(appsRequest, new Callback<AppsResponse>() {
		         @Override
		         public void onResult(ResponseContext context, AppsResponse response) {
		                  //response.getApp(0).getCreator();
		                  System.out.println("Response : " + response);
		                  
		         }
		});
		
		
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
		
		session.flush();
	}

}
