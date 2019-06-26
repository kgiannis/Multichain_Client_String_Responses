package gr.yk.apacheHttp4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * RPC Client for interacting with MultiChain
 * 
 * @author Karavasilis Ioannis
 *
 */
public class RpcClient {

	/**
	 * Invoke RPC call to MultiChain
	 *  
	 * @param requestBody: the request body with the necessary information for the RPC call (command, params, id, chainname). 
	 * @return a string representation of the response from MultiChain 
	 */
	public String call(MultichainApiCommand requestBody) throws ClientProtocolException, IOException, AuthenticationException, URISyntaxException {
		// Initiate Closable HTTP client
		CloseableHttpClient client = HttpClients.createDefault();
		
		// Prepare for POST at specified URI
	    HttpPost httpPost = new HttpPost(MultichainConfig.uri());
	    
	    // Set Basic Authorization for POST Request 
	    UsernamePasswordCredentials creds = MultichainConfig.initBasicCredentials();
	    httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
	    httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "text/plain");
	    
	    
	    /**
	     * Experimental code
	     */
//	    byte[] encodedAuth = Base64.getEncoder().encode(creds.getPassword().getBytes());
//	    String authHeader = "Basic " + new String(encodedAuth);
//	    HttpUriRequest request = RequestBuilder.post()
//	    		  .setUri(MultichainConfig.uri())
//	    		  .setHeader(HttpHeaders.AUTHORIZATION, authHeader)
//	    		  .setHeader(HttpHeaders.CONTENT_TYPE, "text/plain")
//	    		  .setEntity(new StringEntity(requestBody.toString()))
//	    		  .build();
	 
	    // Set POST Body as String
	    httpPost.setEntity(new StringEntity(requestBody.toString()));
	    
	    // Execute Call
	    CloseableHttpResponse response = client.execute(httpPost);
	    
	    // Get Response From MultiChain
	    HttpEntity entity = response.getEntity();
	    String jsonResponse = EntityUtils.toString(entity, StandardCharsets.UTF_8);
	    
	    return jsonResponse;
	}
}
