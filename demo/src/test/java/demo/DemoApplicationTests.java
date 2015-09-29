package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import demo.Booking;
import demo.ReservationRepositoty;

import java.util.List;

import org.junit.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	ReservationRepositoty reservationRepository;
//	
	@Test
	public void contextLoads() {
		
		Assert.assertNotNull("=> The reservationRepository should not be null <=", reservationRepository);
		
	}
//	
	@Test
	@Sql({"/resources/data.sql"})
	public void LoadingResultsInDatabase(){
		
		List<Booking> bookings = reservationRepository.findAll();
		
		Assert.assertNotNull("=>booking list should not be null<=", bookings);
		Assert.assertTrue("=>The Size of booking list must not be Zero <=", bookings.size() > 0 );
	}
	
	
	@Test
	public void findByBookingName()
	{
		List<Booking> bookings = reservationRepository.findByBookingName("LiveLessons");
		
		Assert.assertNotNull("=>booking list should not be null<=", bookings);
		Assert.assertTrue("=>The Size of booking list By Name must not be Zero <=", bookings.size() > 0 );
		Assert.assertTrue("=> The size with name Livelessons should be 1", bookings.size()==1);
	}

}
