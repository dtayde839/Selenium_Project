import org.testng.annotations.DataProvider;

public class UserDataProvider 
{
	@DataProvider
	public object[][] dataset()
	{
		Object[][] dataset = new Object[5][2];
		
//		valid username valid password
		dataset[0][0] = "tayde411@gmail.com";
		dataset[0][1] = "tayde@839";
		
//		valid username invalid password
		dataset[1][0] = "tayde411@gmail.com";
		dataset[1][1] = "efefe839";
//		
////		invalid username valid password
//		dataset[2][0] = "wrwwt344@gmail.com";
//		dataset[2][1] = "tayde@839";
//
////		invalid username invalid password
//		dataset[3][0] = "abcdd@gmail.com";
//		dataset[3][1] = "12345";
//		
////		blank username and password
//		dataset[4][0] = "";
//		dataset[4][1] = "";
		
		return dataset;
	}
}
