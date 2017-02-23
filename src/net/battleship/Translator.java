package net.battleship;

import net.battleship.arpabet.ArpabetSymbol;
import net.battleship.arpabet.ArpabetWord;
import net.battleship.trie.Trie;

import java.io.IOException;
import java.util.*;

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

    static class PhonemesDeliver
    {
        List<String> phonemesCache = new LinkedList<String>();
        public List<String> getPhonemesCache() { return phonemesCache; }
        public void setPhonemesCache(List<String> phonemesCache) { this.phonemesCache = phonemesCache; }
        Scanner scanner;

        public PhonemesDeliver(String source)
        {
            scanner = new Scanner(source);
            while(scanner.hasNext())
            {
                getPhonemesCache().add(scanner.next());
            }
        }

        public ListIterator<String> listIterator()
        {
            return getPhonemesCache().listIterator();
        }

        public ListIterator<String> listIterator(int index)
        {
            return getPhonemesCache().listIterator(index);
        }
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
        StringBuilder sb = new StringBuilder();

        ArpabetWord<String> arpabetWord = new ArpabetWord<>();
        PhonemesDeliver pd = new PhonemesDeliver(text);

        ListIterator<String> li = pd.listIterator();

        while (li.hasNext())
        {
            arpabetWord.append(li.next());
            if (getTrie().hasWord(arpabetWord))
            {
                ArpabetWord<String> longestWord = arpabetWord;
                if (li.hasNext())
                {
                    //found
                    ListIterator<String> lif = pd.listIterator(li.nextIndex());
                    int longestWordOffset = li.nextIndex();
                    int phonemeCount = 0;
                    boolean foundLonger = false;
                    ArpabetWord<String> candidate = ArpabetWord.fromString(longestWord.toString());
                    while (lif.hasNext() && phonemeCount < 10)
                    {
                        String nextPhoneme = lif.next();
                        phonemeCount++;
                        candidate.append(nextPhoneme);
                        if (getTrie().hasWord(candidate))
                        {
                            longestWord = ArpabetWord.fromString(candidate.toString());
                            longestWordOffset = lif.nextIndex();
                            foundLonger = true;
                        }
                    }

                    if (foundLonger)
                    {
                        //reset list to position
                        li = pd.listIterator(longestWordOffset);
                    }
                }
                sb.append(getTrie().getWord(longestWord)).append(" ");
                arpabetWord = new ArpabetWord<>();
            }
        }
        return sb.toString();
    }
}
