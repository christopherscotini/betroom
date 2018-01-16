package com.gamaset.betroom.infra.constants;

public class ExceptionConstants {
	
	public static final String COULD_NOT_PROCESS_JOB_RUN_PRODUCTS_PERIOD_RANGE_EXCEEDED = "Could not process request to run job process. The Period has to be up to one year";
	public static final String COULD_NOT_PROCESS_JOB_RUN_PRODUCTS_CHRONOLOGY_DATE_ERROR = "Could not process request to run job process. The Start date was after the End date, so the Start and End fields were swapped";
	public static final String COULD_NOT_PROCESS_VALIDATE_PERIOD_DAYS_ERROR = "Could not process request. Period of days out of bound. Period sent {%S}, Send Period between 0 and 365 days";
	public static final String FAIL_TO_PROCESS_PUT_MATCH = "Fail to process PUT match in cache.";	
}
