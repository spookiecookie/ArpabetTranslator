package test.net.battleship.trie;

import net.battleship.trie.Trie;
import net.battleship.TrieBuilder;
import net.battleship.arpabet.ArpabetWord;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class TrieTest
{
    TrieBuilder tb;

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
    public void add() throws Exception
    {
        Trie trie = new Trie();
    }

    @Test
    public void hasValue() throws Exception
    {

    }

    @Test
    public void getValue() throws Exception
    {

    }

    @Test
    public void testAddWord() throws Exception
    {
        Trie trie = tb.getTrie();
        String value = "ABACUS";
        ArpabetWord translation =  ArpabetWord.fromString("AE1 B AH0 K AH0 S");

        String value2 = "ABBENHAUS";
        ArpabetWord translation2 = ArpabetWord.fromString("AE1 B AH0 N HH AW2 S");

        String value3 = "AB";
        ArpabetWord translation3 = ArpabetWord.fromString("AE1 B");

        String value4 = "AB";
        ArpabetWord translation4 = ArpabetWord.fromString("EY1 B IY1");
//        trie.add(value, translation);
//        trie.add(value2, translation2);

        assertEquals(value, trie.getValue(translation));
        assertEquals(value2, trie.getValue(translation2));
        assertEquals(value3, trie.getValue(translation3));
        assertEquals(value4, trie.getValue(translation4));
    }
}