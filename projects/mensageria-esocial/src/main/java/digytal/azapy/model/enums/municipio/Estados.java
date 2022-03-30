package digytal.azapy.model.enums.municipio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import digytal.azapy.model.enums.municipio.ufs.Acre;
import digytal.azapy.model.enums.municipio.ufs.Alagoas;
import digytal.azapy.model.enums.municipio.ufs.Amapa;
import digytal.azapy.model.enums.municipio.ufs.Amazonas;
import digytal.azapy.model.enums.municipio.ufs.Bahia;
import digytal.azapy.model.enums.municipio.ufs.Ceara;
import digytal.azapy.model.enums.municipio.ufs.DistritoFederal;
import digytal.azapy.model.enums.municipio.ufs.EspiritoSanto;
import digytal.azapy.model.enums.municipio.ufs.Exterior;
import digytal.azapy.model.enums.municipio.ufs.Goias;
import digytal.azapy.model.enums.municipio.ufs.Maranhao;
import digytal.azapy.model.enums.municipio.ufs.MatoGrosso;
import digytal.azapy.model.enums.municipio.ufs.MatoGrossoSul;
import digytal.azapy.model.enums.municipio.ufs.MinasGerais;
import digytal.azapy.model.enums.municipio.ufs.Para;
import digytal.azapy.model.enums.municipio.ufs.Paraiba;
import digytal.azapy.model.enums.municipio.ufs.Parana;
import digytal.azapy.model.enums.municipio.ufs.Pernambuco;
import digytal.azapy.model.enums.municipio.ufs.Piaui;
import digytal.azapy.model.enums.municipio.ufs.RioGrandeNorte;
import digytal.azapy.model.enums.municipio.ufs.RioGrandeSul;
import digytal.azapy.model.enums.municipio.ufs.RioJaneiro;
import digytal.azapy.model.enums.municipio.ufs.Rondonia;
import digytal.azapy.model.enums.municipio.ufs.Roraima;
import digytal.azapy.model.enums.municipio.ufs.SantaCatarina;
import digytal.azapy.model.enums.municipio.ufs.SaoPaulo;
import digytal.azapy.model.enums.municipio.ufs.Sergipe;
import digytal.azapy.model.enums.municipio.ufs.Tocantins;

public class Estados {
	public static List<Municipio> CIDADES;
	static {
		CIDADES = new ArrayList<Municipio>();
		CIDADES.addAll(Arrays.asList(Acre.values()));
		CIDADES.addAll(Arrays.asList(Alagoas.values()));
		CIDADES.addAll(Arrays.asList(Amazonas.values()));
		CIDADES.addAll(Arrays.asList(Amapa.values()));
		CIDADES.addAll(Arrays.asList(Bahia.values()));
		CIDADES.addAll(Arrays.asList(Ceara.values()));
		CIDADES.addAll(Arrays.asList(DistritoFederal.values()));
		CIDADES.addAll(Arrays.asList(EspiritoSanto.values()));
		CIDADES.addAll(Arrays.asList(Goias.values()));
		CIDADES.addAll(Arrays.asList(Maranhao.values()));
		CIDADES.addAll(Arrays.asList(MinasGerais.values()));
		CIDADES.addAll(Arrays.asList(MatoGrossoSul.values()));
		CIDADES.addAll(Arrays.asList(MatoGrosso.values()));
		CIDADES.addAll(Arrays.asList(Para.values()));
		CIDADES.addAll(Arrays.asList(Paraiba.values()));
		CIDADES.addAll(Arrays.asList(Pernambuco.values()));
		CIDADES.addAll(Arrays.asList(Piaui.values()));
		CIDADES.addAll(Arrays.asList(Parana.values()));
		CIDADES.addAll(Arrays.asList(RioJaneiro.values()));
		CIDADES.addAll(Arrays.asList(RioGrandeNorte.values()));
		CIDADES.addAll(Arrays.asList(Rondonia.values()));
		CIDADES.addAll(Arrays.asList(Roraima.values()));
		CIDADES.addAll(Arrays.asList(RioGrandeSul.values()));
		CIDADES.addAll(Arrays.asList(SantaCatarina.values()));
		CIDADES.addAll(Arrays.asList(Sergipe.values()));
		CIDADES.addAll(Arrays.asList(SaoPaulo.values()));
		CIDADES.addAll(Arrays.asList(Tocantins.values()));
		CIDADES.addAll(Arrays.asList(Exterior.values()));
	}
	public static void main(String[] args) {
		System.out.println("Cidades --> " + CIDADES.size());
	}
	public static Municipio municipio(Integer ibge){
		for (Municipio c : CIDADES) {
			if (c.getCodigo().equals(ibge)) {
				return c;
			}
		}
		return null;
	}
	public static List<Municipio> municipios(String nome){
		List<Municipio>list = new ArrayList<Municipio>();
		for (Municipio c : CIDADES) {
			if (c.getNome().contains(nome.toUpperCase())) {
				list.add(c);
			}
		}
		return list;
	}
	public static void gerarScript(Municipio ... municipios ){
		for(Municipio municipio: municipios){
			System.out.println("INSERT INTO CIDADE()");
		}
	}
}
