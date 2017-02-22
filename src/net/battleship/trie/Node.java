package net.battleship.trie;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by m.zilenas on 2017-02-21.
 */
class Node<K>
{
    Collection<Node> children = new LinkedList<Node>();
    Leaf<K> leaf = new Leaf<>();

    public Node(String nodeKey)
    {
        setKey(nodeKey);
    }

    String key;
    String getKey() { return key; }
    private void setKey(String key) { this.key = key; }

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
            if (node.getKey().equalsIgnoreCase(key))
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

}
