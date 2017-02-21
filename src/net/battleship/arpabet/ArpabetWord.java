package net.battleship.arpabet;

import java.util.*;

/**
 * Trie's helper class.
 */
public class ArpabetWord<V>
{
    List<ArpabetSymbol> symbols = new LinkedList<>();
    public List<ArpabetSymbol> getSymbols() { return symbols; }
    private void setSymbols(List<ArpabetSymbol> symbols) { this.symbols = symbols; }

    public ArpabetWord() {}
    public ArpabetWord(List<ArpabetSymbol> symbols) { setSymbols(symbols); }

    /**
     * Constructor method.
     * @param word
     * @return
     */
    public static ArpabetWord fromString(String word)
    {
        ArpabetWord arpabetWord = new ArpabetWord();
        String[] symbols = word.split("\\s");
        for (String symbol : symbols)
        {
            arpabetWord.append(symbol);
        }
        return arpabetWord;
    }

    public void append(String symbol)
    {
        getSymbols().add(new ArpabetSymbol(symbol));
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (ListIterator<ArpabetSymbol> iterator = getSymbols().listIterator(); iterator.hasNext();)
        {
            ArpabetSymbol symbol = iterator.next();
            sb.append(symbol.toString());
            if (iterator.hasNext())
                sb.append(" ");
        }
        return sb.toString();
    }
}
