package com.digytal.open.util.model;

import java.io.File;

import com.digytal.open.util.config.Configuracao;

public enum Conexao {
	HSQL_LOCAL("sa","sa","org.hsqldb.jdbcDriver","org.hibernate.dialect.HSQLDialect"){
		@Override
		public String getUrl() {
			return String.format("jdbc:hsqldb:file:%s/database/%s/%sdb",Configuracao.getRoot(),Configuracao.lowercase(), Configuracao.lowercase()).replace(File.separator, "/").replaceAll("C:", "");
		}
	},
	HSQL("sa","sa","org.hsqldb.jdbcDriver","org.hibernate.dialect.HSQLDialect"){
		@Override
		public String getUrl() {
			return String.format("jdbc:hsqldb:hsql://localhost:%s/%sdb",Configuracao.hsqlPorta(), Configuracao.lowercase());
		}
	},
	POSTGRES("postgres","postgres","org.postgresql.Driver","org.hibernate.dialect.PostgreSQLDialect"){
		@Override
		public String getUrl() {
			return String.format("jdbc:postgresql://localhost:5432/%sdb", Configuracao.lowercase());
		}
	},
	MYSQL("root","root","com.mysql.jdbc.Driver","org.hibernate.dialect.MySQL5InnoDBDialect"){
		@Override
		public String getUrl() {
			return String.format("jdbc:mysql://localhost:3306/%sdb?useSSL=false", Configuracao.lowercase());
		}
	},
	WEBSERVICE("","","",""){
		@Override
		public String getProfile() {
			return "WEBSERVICE";
		}
		@Override
		public boolean isApi() {
			return true;
		}
		@Override
		public String getUrl() {
			return String.format("localhost:8080/%s-web-api/", Configuracao.lowercase());
		}
	},
	;
	private String usuario;
	private String senha;
	private String driver;
	private String dialeto;
	public static final Conexao[] CONEXOES = new Conexao[] {HSQL,POSTGRES,WEBSERVICE};
	private Conexao(String usuario, String senha, String driver,String dialeto) {
		this.usuario = usuario;
		this.senha = senha;
		this.dialeto = dialeto;
		this.driver = driver;
	}
	public String getUrl() {
		return "";
	}
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	public String getDialeto() {
		return dialeto;
	}
	public String getDriver() {
		return driver;
	}
	public String getProfile() {
		return "DATABASE";
	}
	public boolean isApi() {
		return false;
	}
	public String getDdlUpdate() {
		return "update";
	}
}
