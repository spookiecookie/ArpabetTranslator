package net.battleship;

import net.battleship.arpabet.ArpabetWord;
import net.battleship.trie.Trie;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class Translator
{
    Trie trie;
    public Trie getTrie()
    {
        return trie;
    }

    public Translator(String path)
            throws IOException
    {
        TrieBuilder tb = new TrieBuilder(path);
        trie = tb.getTrie();
    }

    public String translate(String text)
            throws  IOException
    {
        Scanner scanner = new Scanner(text);
        StringBuilder sb = new StringBuilder();
        ArpabetWord<String> arpabetWord = new ArpabetWord<>();
        while (scanner.hasNext())
        {
            String symbol = scanner.next();
            arpabetWord.append(symbol);

            System.out.println("Translating : "+ arpabetWord);
            if (getTrie().hasWord(arpabetWord))
            {
                //found
                sb.append(getTrie().getWord(arpabetWord)).append(" ");
                arpabetWord = new ArpabetWord<>();
            }
        }
        return sb.toString();
    }
}
