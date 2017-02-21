package net.battleship.trie;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by m.zilenas on 2017-02-21.
 */
class Node<K>
{
    Collection<Node> children = new LinkedList<Node>();
    /**
     * Node's value. Not required.
     */
    NodeValue<String> value = new NodeValue<String>();
    Leaf<K> leaf = new Leaf<>();

    public Node(String nodeKey)
    {
        setKey(new NodeKey(nodeKey));
    }

    NodeKey key;
    NodeKey getKey() { return key; }
    private void setKey(NodeKey key) { this.key = key; }

    Leaf<K> getLeaf()
    {
        return leaf;
    }

    void setLeaf(Leaf<K> leaf)
    {
        this.leaf = leaf;
    }

    public Node getChildFor(String key)
    {
        Node ret = null;
        for (Node node : getChildren())
        {
            if (node.getKey().equals(key))
            {
                ret = node;
                break;
            }
        }
        return ret;
    }

    /**
     * Look in children.
     *
     * @return
     */
    public boolean hasChildKey(String key)
    {
        for (Node node : getChildren())
        {
            if (node.getKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public void addChild(Node node)
    {
        getChildren().add(node);
    }

    private Collection<Node> getChildren()
    {
        return children;
    }

    static class Leaf<V>
    {
        V value;
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }

        public Leaf() { }
        public Leaf(V value)
        {
            setValue(value);
        }
    }
}
