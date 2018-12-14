package br.com.juliogriebeler.imdbsearcher.batch.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class FxMarketPricesStore.
 *
 * @author Julio
 */
public class FxMarketPricesStore {
	
	private Map<String, StockPriceDetails> stockPrices = new HashMap<String, StockPriceDetails>();

	public boolean containsKey(Object key) {
		return stockPrices.containsKey(key);
	}

	public StockPriceDetails put(String key, StockPriceDetails value) {
		return stockPrices.put(key, value);
	}

	public Collection<StockPriceDetails> values() {
		return stockPrices.values();
	}

	public StockPriceDetails get(Object key) {
		return stockPrices.get(key);
	}

}
