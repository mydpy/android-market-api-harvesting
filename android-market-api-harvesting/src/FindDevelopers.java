import com.gc.android.market.api.*;
import com.gc.android.market.api.MarketSession.*; 
import com.gc.android.market.api.model.Market.*; 
import java.util.Scanner; 
public class FindDevelopers {
		
	public static void main(String[] args) {
		
		String email = "mylesdanielbaker@gmail.com", password = null; 
        Scanner scanner1 = new Scanner( System.in );
        System.out.print("Enter your password: ");
        password = scanner1.nextLine();
        scanner1.close(); 
	    
		MarketSession session = new MarketSession();
		session.login(email,password);
		//session.getContext.setAndroidId(myAndroidId);

		String query = "maps";
		AppsRequest appsRequest = AppsRequest.newBuilder()
		                                .setQuery(query)
		                                .setStartIndex(0).setEntriesCount(10)
		                                .setWithExtendedInfo(true)
		                                .build();
		                       
		session.append(appsRequest, new Callback<AppsResponse>() {
		         @Override
		         public void onResult(ResponseContext context, AppsResponse response) {
		                  System.out.println("Connection success"); 
		                  response.getApp(0).getCreator();
		         }
		});
		
		
		CommentsRequest commentsRequest = CommentsRequest.newBuilder()
                 .setAppId("7065399193137006744")
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
