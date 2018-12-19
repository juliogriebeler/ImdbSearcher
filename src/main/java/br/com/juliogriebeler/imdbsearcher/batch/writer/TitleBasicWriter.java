package br.com.juliogriebeler.imdbsearcher.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.juliogriebeler.imdbsearcher.model.TitleBasic;
import br.com.juliogriebeler.imdbsearcher.repository.TitleBasicRepository;

/**
 * The Class StockPriceAggregator.
 * 
 * @author Julio
 */
public class TitleBasicWriter implements ItemWriter<TitleBasic> {

	@Autowired
	private TitleBasicRepository repository;

	private static final Logger log = LoggerFactory.getLogger(TitleBasicWriter.class);

	@Override
	public void write(List<? extends TitleBasic> titleBasicProcesseds) throws Exception {
		System.out.println("Entrando no writer");
		repository.saveAll(titleBasicProcesseds);

		System.out.println("QTD Saida: " + titleBasicProcesseds.size() + "<<<<<<<");

		System.out.println("Saindo do writer");
		//titleBasicProcesseds.forEach(t -> {});
			// ADD OR UPDATE
			// System.out.println(">> "+ t.toString());
			// if (titleBasicStore.containsKey(t.getTconst())) {
			// // update
			// System.out.println("UPDATE");
			// log.debug("Updating Title Basic");
			//
			//
			// } else {
			// // add new
			// System.out.println("NEW");
			// log.debug("Adding Title Basic");
			// }
	}

}
