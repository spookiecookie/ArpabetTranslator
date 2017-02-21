package net.battleship.arpabet;

/**
 * Created by m.zilenas on 2017-02-21.
 */
public class ArpabetSymbol
{
    String symbol;
    public String getSymbol() { return symbol; }
    private void setSymbol(String symbol)
    {
        if (symbol == null)
            throw new NullPointerException("Symbol cannot be null.");
        this.symbol = symbol;
    }

    public ArpabetSymbol(String symbol) { setSymbol(symbol); }

    @Override
    public String toString()
    {
        return getSymbol();
    }

    @Override
    public boolean equals(Object object)
    {
        if (object == null)
            return false;
        if (!(object instanceof ArpabetSymbol))
            return false;
        return getSymbol().equals(((ArpabetSymbol) object).getSymbol());
    }

}
