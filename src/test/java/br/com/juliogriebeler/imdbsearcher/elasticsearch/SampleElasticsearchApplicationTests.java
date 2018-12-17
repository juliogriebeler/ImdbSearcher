package br.com.juliogriebeler.imdbsearcher.elasticsearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.rule.OutputCapture;

import br.com.juliogriebeler.imdbsearcher.SampleElasticsearchApplication;

public class SampleElasticsearchApplicationTests {

	@Rule
	public final OutputCapture output = new OutputCapture();

	@Test
	public void testDefaultSettings() {
		try {
			new SpringApplicationBuilder(SampleElasticsearchApplication.class).run();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			if (!elasticsearchRunning(ex)) {
				return;
			}
			throw ex;
		}
		assertThat(this.output.toString()).contains("firstName='Alice', lastName='Smith'");
	}

	private boolean elasticsearchRunning(Exception ex) {
		Throwable candidate = ex;
		while (candidate != null) {
//			if (candidate instanceof NoNodeAvailableException) {
//				return false;
//			}
			candidate = candidate.getCause();
		}
		return true;
	}

}
