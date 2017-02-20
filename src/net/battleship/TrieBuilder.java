package net.battleship;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class TrieBuilder
{
    Path file;

    public Trie getTrie()
    {
        return trie;
    }

    public void setTrie(Trie trie)
    {
        this.trie = trie;
    }

    Trie trie ;

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

            Scanner scanner = new Scanner(translation);

            List<String> list = new LinkedList<String>();
            while (scanner.hasNext())
            {
                list.add(scanner.next());
            }

            getTrie().add(word, list);
        }
    }
}
