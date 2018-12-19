package br.com.juliogriebeler.imdbsearcher.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.juliogriebeler.imdbsearcher.model.TitleBasic;

@Repository
public interface TitleBasicRepository extends ElasticsearchRepository<TitleBasic, String>{

	List<TitleBasic> findByTconst(String tconst);

}
