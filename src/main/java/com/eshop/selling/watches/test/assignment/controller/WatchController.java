package com.eshop.selling.watches.test.assignment.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.eshop.selling.watches.test.assignment.dao.WatchDao;
import com.eshop.selling.watches.test.assignment.entity.Watch;

@RestController
public class WatchController {

	@Autowired
	private WatchDao watchDao;

	// Using MediType.All_VALUE to change input format with request header
	@PostMapping(value = "/saveWatch", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)

	// Returning status codes via ResponseEntity
	@ResponseBody
	public ResponseEntity<String> saveWatchJson(@Valid @RequestBody Watch watch) {

		// Get watch from the database and check if already exists
		Watch ifWatchExists = watchDao.findByTitle(watch.getTitle());
		if (ifWatchExists != null) {
			return new ResponseEntity<String>("Watch already exists in database", HttpStatus.CONFLICT);
		}
		//Save watch to database and respond
		watchDao.save(watch);
		return new ResponseEntity<String>("Created", HttpStatus.CREATED);
	}

}
