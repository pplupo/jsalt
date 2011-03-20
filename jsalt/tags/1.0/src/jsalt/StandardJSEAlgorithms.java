package jsalt;

public enum StandardJSEAlgorithms {
	
	MD2("MD2"),
	MD5("MD5"),
	SHA1("SHA-1"),
	SHA256("SHA-256"),
	SHA384("SHA-384"),
	SHA512("SHA-512");
	
	private String name;

	private StandardJSEAlgorithms(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
	
	
}
