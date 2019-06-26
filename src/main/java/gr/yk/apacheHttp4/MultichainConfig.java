package gr.yk.apacheHttp4;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.utils.URIBuilder;

/**
 * Configuration class for connecting to MultiChain
 * 
 * <SCHEME> is the SCHEME we use to connect to MultiChain
 * <HOST> is the HOST on which the MultiChain is running
 * <PORT> is the PORT you will use to connect to MultiChain
 * 
 * <USERNAME> and <PASSWORD> are the credentials you use to connect to MultiChain. 
 * Both can be seen in multichain.conf file
 * 
 * <CHAIN_NAME> is the name of the chain
 * 
 * @author Karavasilis Ioannis
 *
 */
public class MultichainConfig {

	static final String SCHEME = "http";
	static final String HOST = "10.211.146.179";
	static final int PORT = 4386;
	
	// Your username here, e.g: multichainrpc
	static final String USERNAME = "<Your username here>"; 
	// Your password here, e.g: B35oscPb6bcN7R3kM1PUVFsCZnB82bFHsuiA1UM3BTgJ
	static final String PASSWORD = "<Your password here>";
	
	static final String CHAIN_NAME = "chain1";
	
	/**
	 * Initialize Basic Credentials
	 * @return a UsernamePasswordCredentials object initialized with the credentials
	 */
	protected static UsernamePasswordCredentials initBasicCredentials() {
		return new UsernamePasswordCredentials(USERNAME, PASSWORD);
	}
	
	/**
	 * Initialize URI
	 * @return the URI to connect
	 */
	protected static URI uri() throws URISyntaxException {
		return new URIBuilder()
                .setScheme(SCHEME)
                .setHost(HOST)
                .setPort(PORT)
                .build();
	}
}
