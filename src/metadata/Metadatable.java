package metadata;

import java.util.HashMap;
import java.util.List;

public interface Metadatable {
	
	List<MetadataValue> getMetadata();
	
	boolean hasMetadata();
	
	void setMetadata();

}
