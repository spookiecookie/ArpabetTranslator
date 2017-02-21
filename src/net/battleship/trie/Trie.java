package net.battleship.trie;

import net.battleship.arpabet.ArpabetWord;
import net.battleship.arpabet.ArpabetSymbol;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class Trie
{
    private Node root;

    public Trie()
    {
        root = new Node("root");
    }

    public void add(String value, ArpabetWord word)
    {
        Node node = root;
        for (Object arpabetSymbol : word.getSymbols())
        {
            String symbol = ((ArpabetSymbol) arpabetSymbol).getSymbol();
            if (node.hasChildKey(symbol))
            {
                node = node.getChildFor(symbol);
            } else
            {
                Node child = new Node<String>(symbol);
                node.addChild(child);
                node = child;
            }
        }

        //On the last node set it's key.
        node.setLeaf(new Node.Leaf<>(value));
    }

    /**
     * Gets leaf.
     *
     * @return
     */
    private Node getLeaf(ArpabetWord arpabetWord)
    {
        //Start from the root node...
        Node node = root;

        //...and descend deep down to the leaf node.
        for (Object as : arpabetWord.getSymbols())
        {
            ArpabetSymbol arpabetSymbol = (ArpabetSymbol) as;
            String key = arpabetSymbol.getSymbol();
            if (node.hasChildKey(key))
            {
                node = node.getChildFor(key);
            } else
            {
                //Breaks if not found in dictionary.
                throw new IllegalArgumentException("Not found.");
            }
        }

        return node;
    }

    /**
     * Tells whether a value exists.
     *
     * @return
     */
    public boolean hasValue(ArpabetWord arpabetWord)
    {
        Node node = root;
        for (Object o : arpabetWord.getSymbols())
        {
            String key = ((ArpabetSymbol) o).getSymbol();
            if (node.hasChildKey(key))
            {
                node = node.getChildFor(key);
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getValue(ArpabetWord arpabetWord)
    {
        return getLeaf(arpabetWord).getKey().getKey();
    }

}
