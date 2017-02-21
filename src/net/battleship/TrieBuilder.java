package net.battleship;

import net.battleship.arpabet.ArpabetWord;
import net.battleship.trie.Trie;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class TrieBuilder
{
    Trie trie ;
    public Trie getTrie()
    {
        return trie;
    }
    private void setTrie(Trie trie)
    {
        this.trie = trie;
    }

    //Translations
    Map<String, List<String>> translations = new Hashtable<String, List<String>>();

    public TrieBuilder(String path)
            throws IOException
    {
        setTrie(new Trie());
        init(path);
    }

    private void init(String path)
            throws InvalidPathException, IOException
    {
        Path file = Paths.get(path);
        InputStream is = new FileInputStream(file.toFile());
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bur = new BufferedReader(isr);

        String line = "";
        String lastWord = "";
        while ((line = bur.readLine()) != null)
        {
            //skip
            if (line.startsWith(";;;"))
                continue;

            String word = line.substring(0, line.indexOf(" "));

            //Is an alternative: has number between parenthesis
            if (word.endsWith(")"))
            {
                word = line.substring(0, line.indexOf("("));
            }

            String translation = line.substring(line.indexOf(" ") + 1);

            ArpabetWord<String> arpabetWord = ArpabetWord.fromString(translation);
            getTrie().add(word, arpabetWord);
        }
    }
}
