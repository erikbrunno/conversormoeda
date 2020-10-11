package com.bcb.conversaomoeda.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataUtil {

	public static String obterDataComoString(LocalDate data) {
		
		StringBuilder dataComoString = new StringBuilder();
		dataComoString.append(data.getMonthValue()).append("-");
		dataComoString.append(data.getDayOfMonth()).append("-");
		dataComoString.append(data.getYear());
		return dataComoString.toString();
	}
	
}
