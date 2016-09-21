package pkgShape;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Rectangle_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArea() {
		Rectangle rec1 = new Rectangle(3,4);
		double dActualArea = rec1.area();
		double dExpectedArea = 12;
		
		assertTrue(dActualArea == dExpectedArea);
	}

}
