/**
 * 
 */
package br.com.juliogriebeler.imdbsearcher.batch.item.file.transform;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;

/**
 * @author Julio
 *
 */
public class QuoteCustomDelimitedLineTokenizer extends DelimitedLineTokenizer {
	@Override
	public FieldSet tokenize(String line) {
		line = line.replace('"', '\"');
		line = line.replace("'", "\'");
		line = StringEscapeUtils.escapeHtml(line);
		return super.tokenize(line);
	}

	
}
