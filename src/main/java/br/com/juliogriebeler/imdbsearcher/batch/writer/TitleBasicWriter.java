package br.com.juliogriebeler.imdbsearcher.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import br.com.juliogriebeler.imdbsearcher.batch.model.TitleBasicProcessed;

/**
 * The Class StockPriceAggregator.
 * 
 * @author Julio
 */
public class TitleBasicWriter implements ItemWriter<TitleBasicProcessed> {

//	@Autowired
//	private TitleBasicStore titleBasicStore;

	private static final Logger log = LoggerFactory.getLogger(TitleBasicWriter.class);

	@Override
	public void write(List<? extends TitleBasicProcessed> titleBasicProcesseds) throws Exception {
		titleBasicProcesseds.forEach(t -> {
			// ADD OR UPDATE
			//System.out.println(">> "+ t.toString());
//			if (titleBasicStore.containsKey(t.getTconst())) {
//				// update
//				System.out.println("UPDATE");
//				log.debug("Updating Title Basic");
//				
//				
//			} else {
//				// add new
//				System.out.println("NEW");
//				log.debug("Adding Title Basic");
//			}
		});
	}

}
