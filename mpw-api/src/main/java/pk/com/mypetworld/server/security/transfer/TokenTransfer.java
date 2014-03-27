package pk.com.mypetworld.server.security.transfer;



public class TokenTransfer {

	private final String token;


	public TokenTransfer(String token) {

		this.token = token;
	}


	public String getToken() {

		return this.token;
	}

}
