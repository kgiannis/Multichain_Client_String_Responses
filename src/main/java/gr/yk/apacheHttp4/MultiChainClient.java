package gr.yk.apacheHttp4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.ClientProtocolException;

/**
 * Demonstration of RPC calls to MultiChain.
 * Comment or Uncomment lines with <MultichainApiCommand> objects invoke commands.
 * 
 * @author Karavasilis Ioannis
 *
 */
public class MultiChainClient {
	
	public static void main(String[] args) throws AuthenticationException, ClientProtocolException, IOException, URISyntaxException {
		RpcClient client = new RpcClient();
		Object[] params = new Object[] {true};
		
		// Prepare different statements to use - no parameters
//		MultichainApiCommand getinfo = MultichainApiCommand.prepareCall("getinfo", null, UUID.randomUUID(), MultichainConfig.CHAIN_NAME);
//		MultichainApiCommand listaddresses = MultichainApiCommand.prepareCall("listaddresses", null, UUID.randomUUID(), MultichainConfig.CHAIN_NAME);
//		MultichainApiCommand liststreams = MultichainApiCommand.prepareCall("liststreams", null, UUID.randomUUID(), MultichainConfig.CHAIN_NAME);
		
		// Prepare statement with parameters
//		String[] params = new String[] {"root"};
//		MultichainApiCommand getstreaminfo = MultichainApiCommand.prepareCall("getstreaminfo", params, UUID.randomUUID(), MultichainConfig.CHAIN_NAME);
		
		// Addresses
		MultichainApiCommand getAddresses = MultichainApiCommand.prepareCall("getaddresses", params, UUID.randomUUID(), MultichainConfig.CHAIN_NAME);
		
		// Response from RPC Call 
		String multichainResponse = client.call(getAddresses);
		
		// Pretty Print response from RPC Call
		CustomUtils.showResponse(multichainResponse);
	}
	
	
}
