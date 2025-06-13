package wg.mstorcedeira.domain;

import java.util.HashMap;
import java.util.Map;

public class ListCb {
	
	private static Map<String, CBAbstract> ListCabos = new HashMap<>();
	
	
	public static void iniciar() {
		
		ListCabos.put("cb50mm", new CB50mm());
		
	}
	
	public static CBAbstract getInstance(String cb) {
		
		return ListCabos.get(cb);
	}
	
	public Map<String,CBAbstract> getObject(){
		
		return ListCabos;
	}

}
