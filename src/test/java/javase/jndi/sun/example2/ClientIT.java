package javase.jndi.sun.example2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClientIT {
	@Test
    public void test1() throws Exception {
        assertEquals("EN", Client.getValue());
	}
	
}