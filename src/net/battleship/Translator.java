package net.battleship;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class Translator
{
    public String translate(String text)
            throws  IOException
    {
        TrieBuilder tb;
        tb = new TrieBuilder("src\\test\\cmudict.0.7a.txt");
        Trie trie = tb.getTrie();
        Scanner scanner = new Scanner(text);
        List<String> codes = new LinkedList<>();
        StringBuilder translated = new StringBuilder();
        while (scanner.hasNext())
        {
            codes.add(scanner.next());
            Trie.Node leafNode = trie.getLeafNode(codes);
            if (!leafNode.getLeaves().isEmpty())
            {
                translated.append(trie.getValue(codes));
                codes.clear();
            }
        }
        return translated.toString();
    }
}
