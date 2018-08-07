package metadata;

public interface MetadataValue {
	
	String asString();
	
	Object value();
	
	void remove();

}
