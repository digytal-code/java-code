package com.digytal.open.util;

import java.util.Calendar;
import java.util.Locale;

public interface DataHoraConstants {
    Locale LOCALIZACAO = new Locale("pt", "BR");
    int DIA= Calendar.DAY_OF_MONTH;
    int MES=Calendar.MONTH;
    int ANO=Calendar.YEAR;
    int HORA=Calendar.HOUR_OF_DAY;
    int MINUTO=Calendar.MINUTE;
    int SEGUNDO=Calendar.SECOND;
    int AM_PM=Calendar.AM_PM;
}
