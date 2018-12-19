package br.com.juliogriebeler.imdbsearcher.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.juliogriebeler.imdbsearcher.batch.listener.JobCompletionNotificationListener;
import br.com.juliogriebeler.imdbsearcher.batch.model.TitleBasicIn;
import br.com.juliogriebeler.imdbsearcher.batch.processor.TitleBasicProcessor;
import br.com.juliogriebeler.imdbsearcher.batch.reader.TitleBasicReader;
import br.com.juliogriebeler.imdbsearcher.batch.writer.TitleBasicWriter;
import br.com.juliogriebeler.imdbsearcher.model.TitleBasic;

/**
 * The Class BatchConfiguration.
 * 
 * @author Julio
 */
@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public TitleBasicReader titleBasicReader() {
		return new TitleBasicReader();
	}

	@Bean
	public TitleBasicProcessor titleBasicEventProcessor() {
		return new TitleBasicProcessor();
	}

	@Bean
	public TitleBasicWriter titleBasicAggregator() {
		return new TitleBasicWriter();
	}

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
		return stepBuilderFactory.get("Extract -> Transform -> Aggregate -> Load")
				.<TitleBasicIn, TitleBasic>chunk(10000).reader(titleBasicReader()).processor(titleBasicEventProcessor())
				.writer(titleBasicAggregator()).build();
	}

}
