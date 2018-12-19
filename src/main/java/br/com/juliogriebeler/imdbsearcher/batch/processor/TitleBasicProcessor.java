package br.com.juliogriebeler.imdbsearcher.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import br.com.juliogriebeler.imdbsearcher.batch.model.TitleBasicIn;
import br.com.juliogriebeler.imdbsearcher.model.TitleBasic;
import br.com.juliogriebeler.imdbsearcher.utils.ValidationUtils;

/**
 * The Class FxMarketEventProcessor.
 * 
 * @author Julio
 */
public class TitleBasicProcessor implements ItemProcessor<TitleBasicIn, TitleBasic> {

	private static final Logger log = LoggerFactory.getLogger(TitleBasicProcessor.class);

	@Override
	public TitleBasic process(final TitleBasicIn titleBasic) throws Exception {

		final TitleBasic titleBasicProcessed = new TitleBasic();
		try {
		
			titleBasicProcessed.setTconst(titleBasic.getTconst());
			titleBasicProcessed.setPrimaryTitle(titleBasic.getPrimaryTitle());
			titleBasicProcessed.setOriginalTitle(titleBasic.getOriginalTitle());
			titleBasicProcessed.setTitleType(titleBasic.getTitleType());
			titleBasicProcessed.setAdult(Boolean.getBoolean(titleBasic.getIsAdult()));
			if(!ValidationUtils.isEmptyField(titleBasic.getStartYear())) {
				titleBasicProcessed.setStartYear(Long.parseLong(titleBasic.getStartYear()));
			}
			if(!ValidationUtils.isEmptyField(titleBasic.getEndYear())) {
				titleBasicProcessed.setEndYear(Long.parseLong(titleBasic.getEndYear()));
			}
			if(!ValidationUtils.isEmptyField(titleBasic.getRuntimeMinutes())) {
				titleBasicProcessed.setRuntimeMinutes(Long.parseLong(titleBasic.getRuntimeMinutes()));
			}
			List<String> genres = new ArrayList<String>();
			if(null!=titleBasic.getGenres()) {
				for (String genre : titleBasic.getGenres().split(",")) {
					genres.add(genre);
				}
			}
			titleBasicProcessed.setGenres(genres);
			log.trace("Converting (" + titleBasic + ") into (" + titleBasicProcessed + ")");
			
		} catch (Exception e) {
			System.out.println(titleBasic.toString());
			System.out.println(e.getMessage());
		}

		return titleBasicProcessed;
	}

}
