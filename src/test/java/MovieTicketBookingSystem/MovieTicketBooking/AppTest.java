package MovieTicketBookingSystem.MovieTicketBooking;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;

import com.cpg.movieticketbooking.service.UserServiceImpl;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static UserServiceImpl usd;
	@BeforeClass
	public static void initTest() {
		usd=new UserServiceImpl();
	}
	
	@Test
   public void testValidation() {
		boolean flag=usd.signIn("vaibhav", "123");
		assertEquals(true,flag);
		
	}
	

}
