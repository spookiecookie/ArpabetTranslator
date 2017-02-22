package net.battleship.trie;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by m.zilenas on 2017-02-21.
 */
class Node<K>
{
    Collection<Node> children = new LinkedList<Node>();

    Node(String nodeKey)
    {
        setKey(nodeKey);
    }

    String key;
    String getKey() { return key; }
    private void setKey(String key) { this.key = key; }

    String word = null; //if set then this is the word we have traveled for
    String getWord() { return word; }
    void setWord(String word) { this.word = word; }

    Node getChildFor(String key)
    {
        Node ret = null;
        for (Node node : getChildren())
        {
            if (node.getKey().equalsIgnoreCase(key))
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
    boolean hasChildKey(String key)
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

    void addChild(Node node)
    {
        getChildren().add(node);
    }

    private Collection<Node> getChildren()
    {
        return children;
    }

}
