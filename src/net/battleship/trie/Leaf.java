package net.battleship.trie;

/**
 * Created by m.zilenas on 2017-02-22.
 */
class Leaf<V>
{
    V value;

    public V getValue()
    {
        return value;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

    public Leaf()
    {
    }

    public Leaf(V value)
    {
        setValue(value);
    }
}
