package br.com.juliogriebeler.imdbsearcher.batch.reader;

import java.nio.charset.StandardCharsets;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import br.com.juliogriebeler.imdbsearcher.batch.item.file.transform.QuoteCustomDelimitedLineTokenizer;
import br.com.juliogriebeler.imdbsearcher.batch.model.TitleBasicIn;
import br.com.juliogriebeler.imdbsearcher.utils.Constants;

/**
 * The Class TitleBasicReader.
 *
 * @author Julio
 */
public class TitleBasicReader extends FlatFileItemReader<TitleBasicIn> {

	private String[] NAMES = new String[] { "tconst", "titleType", "primaryTitle", "originalTitle", "isAdult",
			"startYear", "endYear", "runtimeMinutes", "genres" };
	private String FILENAME = "title_basics/data.tsv";

	public TitleBasicReader() {
		this.setResource(new ClassPathResource(FILENAME));
		this.setEncoding(StandardCharsets.UTF_8.name());
		this.setLinesToSkip(1);
		this.setLineMapper(getLineMapper());
	}

	private DefaultLineMapper<TitleBasicIn> getLineMapper() {
		DefaultLineMapper<TitleBasicIn> lineMapper = new DefaultLineMapper<TitleBasicIn>();
		lineMapper.setLineTokenizer(getLineTokenizer());
		lineMapper.setFieldSetMapper(getFieldsetMapper());
		return lineMapper;
	}

	private BeanWrapperFieldSetMapper<TitleBasicIn> getFieldsetMapper() {
		BeanWrapperFieldSetMapper<TitleBasicIn> fieldsetMapper = new BeanWrapperFieldSetMapper<TitleBasicIn>();
		fieldsetMapper.setTargetType(TitleBasicIn.class);
		return fieldsetMapper;
	}

	private DelimitedLineTokenizer getLineTokenizer() {
		QuoteCustomDelimitedLineTokenizer lineTokenizer = new QuoteCustomDelimitedLineTokenizer();
		lineTokenizer.setDelimiter(Constants.FIELD_DELIMITER);
		lineTokenizer.setNames(NAMES);
		lineTokenizer.setStrict(Boolean.FALSE);
		return lineTokenizer;
	}

}
