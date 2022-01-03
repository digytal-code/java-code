package java.code.desktop.desktop.ss.sql;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

public abstract class SSTipoDados {
    public static final int TEXTO = Types.VARCHAR;
    public static final int FLUTUANTE_DUPLO = Types.DOUBLE;
    public static final int FLUTUANTE_PADRAO = Types.FLOAT;
    public static final int INTEIRO_LONGO = Types.BIGINT;
    public static final int INTEIRO_PADRAO = Types.INTEGER;
    public static final int INTEIRO_PEQUENO = Types.SMALLINT;
    public static final int DATA = Types.DATE;
    public static final int HORA = Types.TIME;
    public static final int DATA_HORA = Types.TIMESTAMP;
    public static final int SIM_NAO = Types.BOOLEAN;
    public static final int CARACTERE = Types.CHAR;
    public static final int BYTE = Types.TINYINT;
    public static final int MOEDA = Types.REAL;
    public static final int MEMORANDO = Types.LONGVARCHAR;
    public static final int NUMERO = Types.NUMERIC;
            
    public static int verifica(Object valor){
        if (valor instanceof String)
            return Types.VARCHAR;
        if (valor instanceof Double)
            return Types.DOUBLE;
        if (valor instanceof Float)
            return Types.FLOAT;
        if (valor instanceof Long)
            return Types.BIGINT;
        if (valor.getClass() == Integer.class)
            return Types.INTEGER;
        if (valor.getClass() == Short.class)
            return Types.SMALLINT;
        if (valor.getClass() == Byte.class)
            return Types.TINYINT;
        if (valor.getClass() == Date.class)
            return Types.DATE;
        if (valor.getClass() == Time.class)
            return Types.TIME;
        if (valor.getClass() == Timestamp.class)
            return Types.TIMESTAMP;
        return 0;
    }
    
}
