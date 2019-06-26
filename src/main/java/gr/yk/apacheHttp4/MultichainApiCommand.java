package gr.yk.apacheHttp4;

import java.util.UUID;

/**
 * Objects of this class are the commands we use to interact with MultiChain
 * <command> is the name of the command (e.g: getinfo)
 * <params> is the array of parameters we are passing. It can be null if no params are used.
 * <id> is the id we use for the RPC call
 * <chainName> is the name of the chain
 * 
 * @author Karavasilis Ioannis
 *
 */
public class MultichainApiCommand {

	private String method;
	private Object[] params;
	private UUID id;
	private String chainName;
	
	public static MultichainApiCommand prepareCall(String method, Object[] params, UUID id, String chainName) {
		return new MultichainApiCommand(method, params, id, chainName);
	}
	
	private MultichainApiCommand(String method, Object[] params, UUID id, String chainName) {
		super();
		this.method = method;
		this.params = params;
		this.id = id;
		this.chainName = chainName;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getChainName() {
		return chainName;
	}
	public void setChainName(String chainName) {
		this.chainName = chainName;
	}
	
	@Override
	public String toString() {
		return "{\"method\"" + ":" + "\"" + method + "\"" 
				+ "," + "\"params\"" + ":" +  (params == null ? "[]" : CustomUtils.separateParamsWithCommas(params))
				+ "," + "\"id\"" + ":" + "\"" + id + "\"" 
				+ "," + "\"chain_name\"" + ":" + "\"" + chainName + "\"" + "}";
	}
	
}
