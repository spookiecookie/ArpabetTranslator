package net.battleship;

import net.battleship.arpabet.ArpabetWord;
import net.battleship.trie.Trie;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Pattern p = Pattern.compile("(?![;]{3})^(?<word>[^\\s(]*)(?:\\((?<num>\\d+)\\))?\\s+(?<translation>.*)$"); // try this pattern http://www.regexplanet.com/advanced/java/index.html
        while ((line = bur.readLine()) != null)
        {
            Matcher match = p.matcher(line);
            //skip
            if (!match.matches() || match.group("word") == null)
                continue;
            String word = match.group("word");
            String translation = match.group("translation");
            Integer number = null;
            if (match.group("num") != null)
            {
                number = Integer.valueOf(match.group("num"));
            }

            getTrie().add(word, ArpabetWord.fromString(translation));
        }
    }
}
