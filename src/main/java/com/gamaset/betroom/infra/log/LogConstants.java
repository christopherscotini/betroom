package com.gamaset.betroom.infra.log;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class LogConstants {

	/**
	 * Error messages
	 */
	public static final String ERROR_INSERT_OR_UPDATE_PRICE_HISTORY = "Error on insert or update price history.";
	public static final String COULD_NOT_DEFINE_CHRONOLOGY_DATE_RANGE = "Could not define chronology date range.";
	public static final String PERIOD_RANGE_EXCEEDED = "Period range exceeded.";
	public static final String PRICE_HISTORY_NOT_FOUND = "Price history not found.";
	
	/**
	 * Default Messages
	 */
	public static final String PRODUCTS_NOT_FOUND_FOR_THIS_DATE_RANGE = "Products not found for this date range.";
	public static final String NUMBER_PRODUCTS_FOUND_FOR_THIS_DATE_RANGE = "Products found for this date range.";

	public static final String SEARCHING_FOR_PRICE_HISTORY = "Searching for price history";
	public static final String CREATING_PRICE_HISTORY = "Creating price history";

	/**
	 * CACHE
	 */
	public static final String REDIS_DOWN = "REDIS DOWN";
	public static final String REDIS_UP = "REDIS UP";
	public static final String CACHE_SERIALIZATION = "Cache Serialization";

	/**
	 * Class
	 */
	public static final String CLASS_NAME = "className";
	public static final String CLASS_METHOD = "classMethod";

	/**
	 *
	 */
	public class ACCESS {
		public static final String HTTP_METHOD = "method";
		public static final String HTTP_STATUS = "httpStatus";

		private ACCESS() {
		}
	}

	/**
	*
	*/
	public class METRIC {
		public static final String VALIDATION_PERIOD_DATE_ERROR = "VALIDATE-PERIOD_DATE: ERROR";
		public static final String VALIDATION_DATE_RANGE_ERROR = "VALIDATE-DATE_RANGE: ERROR";
		public static final String CREATE_PRICE_HISTORY_ERROR = "CREATE-PRICE_HISTORY: ERROR";
		public static final String CREATE_PRICE_HISTORY_SUCCESS = "CREATE-PRICE_HISTORY: SUCCESS";
		public static final String CREATE_PRICE_HISTORY_SKIPPED = "CREATE-PRICE_HISTORY: SKIPPED";

		private METRIC() {
		}
	}

	/**
	 *
	 */
	public class PARAMETERS {
		public static final String START_DATE = "startDate";
		public static final String END_DATE = "endDate";
		public static final String MATCH_ID = "matchId";
		public static final String TEAM_ID = "teamId";

		private PARAMETERS() {
		}
	}

	/**
	 *
	 */
	public class FIELDS {
		/**
		 * ProductPrice
		 */
		public static final String FIELD_PRODUCT_ID = "productId";
		public static final String FIELD_NUMBER_OF_PRODUCTS_GROUPED = "numberProductsGrouped";
		public static final String FIELD_START_DATE = "startDate";
		public static final String FIELD_END_DATE = "endDate";
		public static final String FIELD_DATE = "date";
		public static final String FIELD_PERIOD = "period";
		public static final String FIELD_AGGREGATE = "aggregate";
		public static final String FIELD_MIN_PRICE = "minPrice";
		public static final String FIELD_MAX_PRICE = "maxPrice";
		public static final String FIELD_AVG_PRICE = "avgPrice";

		private FIELDS() {
		}
	}

	/**
	 *
	 */
	public class ACTION {

		private ACTION() {
		}
	}

}
