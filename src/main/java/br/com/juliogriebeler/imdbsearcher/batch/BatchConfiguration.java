package br.com.juliogriebeler.imdbsearcher.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.juliogriebeler.imdbsearcher.batch.listener.JobCompletionNotificationListener;
import br.com.juliogriebeler.imdbsearcher.batch.model.TitleBasicIn;
import br.com.juliogriebeler.imdbsearcher.batch.model.TitleBasicProcessed;
import br.com.juliogriebeler.imdbsearcher.batch.processor.TitleBasicProcessor;
import br.com.juliogriebeler.imdbsearcher.batch.reader.TitleBasicReader;
import br.com.juliogriebeler.imdbsearcher.batch.writer.TitleBasicWriter;

/**
 * The Class BatchConfiguration.
 * 
 * @author Julio
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	/* TODO */
//	@Bean
//	public TitleBasicStore fxMarketPricesStore() {
//		return new TitleBasicStore();
//	}

	// FxMarketEventReader (Reader)
	@Bean
	public TitleBasicReader titleBasicReader() {
		return new TitleBasicReader();
	}

	// FxMarketEventProcessor (Processor)
	@Bean
	public TitleBasicProcessor titleBasicEventProcessor() {
		return new TitleBasicProcessor();
	}

	// StockPriceAggregator (Writer)
	@Bean
	public TitleBasicWriter titleBasicAggregator() {
		return new TitleBasicWriter();
	}

	// JobCompletionNotificationListener (File loader)
	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionNotificationListener();
	}

	// Configure job step
	@Bean
	public Job titleBasicETLJob() {
		return jobBuilderFactory.get("Title Basic ETL Job").incrementer(new RunIdIncrementer()).listener(listener())
				.flow(etlStep()).end().build();
	}

	@Bean
	public Step etlStep() {
		return stepBuilderFactory.get("Extract -> Transform -> Aggregate -> Load").<TitleBasicIn, TitleBasicProcessed> chunk(10000)
				.reader(titleBasicReader()).processor(titleBasicEventProcessor())
				.writer(titleBasicAggregator())
				.build();
	}

}
