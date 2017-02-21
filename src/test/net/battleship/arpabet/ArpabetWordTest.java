package test.net.battleship.arpabet;

import net.battleship.arpabet.ArpabetSymbol;
import net.battleship.arpabet.ArpabetWord;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by m.zilenas on 2017-02-21.
 */
public class ArpabetWordTest
{
    String s = "EY1 B IY1";
    String s2 = "AH0 B R IY2 V IY0 EY1 SH AH0 N";
    ArpabetWord arpabetWord = ArpabetWord.fromString(s);
    ArpabetWord arpabetWord2 = ArpabetWord.fromString(s2);

    @Test
    public void getSymbols() throws Exception
    {
        assertEquals
        (
            Arrays.asList
            (
                    new ArpabetSymbol("EY1"),
                    new ArpabetSymbol("B"),
                    new ArpabetSymbol("IY1")
            )
            , arpabetWord.getSymbols()
        );
    }

    @Test
    public void fromString() throws Exception
    {
        assertEquals(s, arpabetWord.toString());
    }

    @Test
    public void append() throws Exception
    {
        String app = "Z";
        arpabetWord2.append(app);
        assertEquals(s2 + " " + app, arpabetWord2.toString());
    }

    @Test
    public void testToString() throws Exception
    {
        ArpabetWord arpabetWord = ArpabetWord.fromString(s2);
        assertEquals(s2, arpabetWord.toString());
        assertNotEquals(s2+" ", arpabetWord.toString());
    }
}
