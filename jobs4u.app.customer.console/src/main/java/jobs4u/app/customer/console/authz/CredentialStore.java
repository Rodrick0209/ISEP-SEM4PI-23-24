package jobs4u.app.customer.console.authz;


import jobs4u.app.customer.console.followup.customer.client.FollowUpServerProxy;
import jobs4u.base.authz.CredentialHandler;

/**
 * Credential store to hold in memory the username and password collected during
 * login.
 *
 * @author Paulo Gandra de Sousa 2022.12.15
 */
public class CredentialStore {
	// holder of credential data
	// this is a global variable which is a bad smell
	private static String username;
	private static String password;

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static final CredentialHandler STORE_CREDENTIALS = (u, p, r) -> {
		CredentialStore.username = u;
		CredentialStore.password = p;
		FollowUpServerProxy followUpServerProxy = new FollowUpServerProxy();
		return followUpServerProxy.auth(u, p);
	};
}
