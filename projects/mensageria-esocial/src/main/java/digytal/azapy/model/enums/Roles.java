package digytal.azapy.model.enums;

public enum  Roles {
    USER,
    ADMIN;
	public static final String PRE_USER= "hasRole('USER')";
	public static final String PRE_ADMIN= "hasRole('ADMIN')";
	public static final String PRE_USER_ADMIN= "hasAnyRole('ADMIN','USER')";
}
