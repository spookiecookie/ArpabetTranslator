package net.battleship.trie;

/**
 * Created by m.zilenas on 2017-02-21.
 */
class NodeValue<V>
{
    V value;

    public NodeValue(V value)
    {
        setValue(value);
    }

    public NodeValue()
    {
    }

    public V getValue()
    {
        return value;
    }

    public NodeValue setValue(V value)
    {
        this.value = value;
        return this;
    }
}
