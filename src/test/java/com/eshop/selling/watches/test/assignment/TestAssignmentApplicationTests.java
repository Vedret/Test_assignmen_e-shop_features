package com.eshop.selling.watches.test.assignment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.eshop.selling.watches.test.assignment.dao.WatchDao;
import com.eshop.selling.watches.test.assignment.entity.Watch;

@SpringBootTest
class TestAssignmentApplicationTests {

	@Autowired
	private WatchDao watchDao;

	@BeforeEach
	// Save watch to database
	public void setUp() throws Exception {
		BigDecimal price = new BigDecimal(250000);
		Watch watch = new Watch("Prim", price, "A watch with a water fountain picture",
				"R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=");
		watchDao.save(watch);
	}

	@Test
	void testGettingWatchToDatabase() throws IOException {
		// Get object from database and check if price equals
		Watch watchA = watchDao.findByTitle("Prim");
		assertEquals(250000, watchA.getPrice());
	}

	// Delete watch from database
	@AfterEach
	public void tearDown() throws Exception {
		this.watchDao.deleteAll();

	}

}
