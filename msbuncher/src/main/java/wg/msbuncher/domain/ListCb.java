package wg.msbuncher.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListCb {
	
	private static Map<String,CBAbstract> listaCabos = new HashMap<>();
	
	public static void iniciar() {
		
		listaCabos.put("cb50mm", new CB50mm());
		
	}
	
	public static CBAbstract getInstance(String cb) {
		
		return listaCabos.get(cb);
	}
	
	public Map<String,CBAbstract> getObjeto() {
		
		return listaCabos;
		
		
	}

}
