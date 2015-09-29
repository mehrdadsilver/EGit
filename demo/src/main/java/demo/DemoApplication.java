package demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
    
    
}
//dsfdsfdsfdf
interface ReservationRepositoty extends JpaRepository<Booking, Long>{
	
	
	//find by booking_name
	List<Booking> findByBookingName(String BookingName);
	
}


@Entity
class Booking
{
	@Id 
	@GeneratedValue
	private Long id;
	
	Booking(){ } //jpa require this consruction
	
	public Booking(Long id, String bookingName, int bookingSize) {
		super();
		this.id = id;
		this.bookingName = bookingName;
		this.bookingSize = bookingSize;
	}

	public Long getId() {
		return id;
	}

	public String getBookingName() {
		return bookingName;
	}

	public int getBookingSize() {
		return bookingSize;
	}

	private String bookingName;
	
	private int bookingSize;
}
