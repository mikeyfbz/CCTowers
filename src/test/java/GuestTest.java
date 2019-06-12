import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before(){
        guest = new Guest("Ben");
    }

    @Test
    public void guestHasAName(){
        assertEquals("Ben", guest.getName());
    }

}
