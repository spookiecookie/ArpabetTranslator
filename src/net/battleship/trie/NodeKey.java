package net.battleship.trie;

/**
 * Created by m.zilenas on 2017-02-21.
 */
class NodeKey
{
    String key;

    public NodeKey(String key)
    {
        setKey(key);
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof NodeKey))
        {
            return false;
        }
        return ((NodeKey) object).getKey().equalsIgnoreCase(getKey());
    }
}
