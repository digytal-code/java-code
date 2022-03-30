package digytal.azapy.model.enums;

public class Enums {
	public static <T> T item(Class<? extends Enumeracao> enumeracao, Object codigo){
		for(Enumeracao item: enumeracao.getEnumConstants()){
			if(codigo!=null && item.getCodigo().equals(codigo))
				return (T) item;
		}
		return null;
	}
}
