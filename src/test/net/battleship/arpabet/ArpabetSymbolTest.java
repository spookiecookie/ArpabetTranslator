package test.net.battleship.arpabet;

import net.battleship.arpabet.ArpabetSymbol;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by m.zilenas on 2017-02-21.
 */
public class ArpabetSymbolTest
{
    @Test
    public void getSymbol() throws Exception
    {
        ArpabetSymbol as = new ArpabetSymbol("IY1");
        assertEquals("IY1", as.getSymbol());
    }

    @Test
    public void testToString() throws Exception
    {
        ArpabetSymbol as = new ArpabetSymbol("IY1");
        assertEquals("IY1", as.toString());
    }

    @Test
    public void equals() throws Exception
    {
        ArpabetSymbol as = new ArpabetSymbol("IY1");
        ArpabetSymbol as2 = new ArpabetSymbol("IY1");
        ArpabetSymbol as3 = new ArpabetSymbol("AH0");
        assertTrue(as.equals(as2));
        assertFalse(as.equals(as3));
    }
}
