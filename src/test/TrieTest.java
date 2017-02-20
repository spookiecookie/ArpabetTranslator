package test;

import net.battleship.Trie;
import net.battleship.TrieBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class TrieTest
{
    TrieBuilder tb;

    @Before
    public void init()
    {
        try
        {
            tb = new TrieBuilder("src\\test\\cmudict.0.7a.txt");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddWord() throws Exception
    {
        Trie trie = tb.getTrie();
        String value = "ABACUS";
        List<String> translation =  Arrays.asList("AE1", "B", "AH0", "K", "AH0", "S");

        String value2 = "ABBENHAUS";
        List<String> translation2 = Arrays.asList("AE1", "B", "AH0", "N", "HH", "AW2", "S");

        String value3 = "AB";
        List<String> translation3 = Arrays.asList("AE1", "B");

        String value4 = "AB";
        List<String> translation4 = Arrays.asList("EY1", "B", "IY1");
//        trie.add(value, translation);
//        trie.add(value2, translation2);

        assertEquals(value, trie.getValue(translation));
        assertEquals(value2, trie.getValue(translation2));
        assertEquals(value3, trie.getValue(translation3));
        assertEquals(value4, trie.getValue(translation4));
    }
}