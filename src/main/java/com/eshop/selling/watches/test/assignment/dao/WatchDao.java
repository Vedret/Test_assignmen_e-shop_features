package com.eshop.selling.watches.test.assignment.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.eshop.selling.watches.test.assignment.entity.Watch;

@Service
public interface WatchDao extends CrudRepository<Watch, Long>  {


	//Get watch by title from database
	public Watch findByTitle(String string);

	


}
