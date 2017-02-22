package net.battleship;

import net.battleship.arpabet.ArpabetSymbol;
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
        String symbol = null;
        while (scanner.hasNext())
        {
            if (symbol == null)
            {
                symbol = scanner.next();
            }

            arpabetWord.append(symbol);

            if (getTrie().hasWord(arpabetWord))
            {
                //found
                //Let's see if when we append next phoneme we have valid word, then take next phoneme.
                while (scanner.hasNext())
                {
                    symbol = scanner.next();
                    ArpabetWord nextWord = ArpabetWord.fromString(arpabetWord.toString()).append(symbol);
                    if (getTrie().hasWord(nextWord))
                    {
                        arpabetWord = nextWord;
                    }
                    else
                    {
                        sb.append(getTrie().getWord(arpabetWord)).append(" ");
                        arpabetWord = ArpabetWord.fromString(symbol);
                        break;
                    }
                }
            }
            symbol = null;
        }
        return sb.toString();
    }
}
