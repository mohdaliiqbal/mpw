package pk.com.mypetworld.server.security.transfer;



public class TokenTransfer {

	private final String token;
	private final String userId;

	public TokenTransfer(String token, String userId) {
		this.userId = userId;
		this.token = token;
	}


	public String getToken() {
		return this.token;
	}


	public String getUserId() {
		return userId;
	}

}
