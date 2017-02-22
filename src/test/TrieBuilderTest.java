package test;

import net.battleship.TrieBuilder;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by m.zilenas on 2017-02-21.
 */
public class TrieBuilderTest
{
    @Before
    public void init()
    {

    }

    @Test
    public void testInit()
            throws IOException
    {
        TrieBuilder tb = new TrieBuilder("src\\test\\cmudict.0.7a.txt");
    }
}
