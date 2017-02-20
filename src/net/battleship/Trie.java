package net.battleship;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class Trie
{
    Node root = new Node("root");

    public boolean hasValue(List<String> codes)
    {
        Node node = root;
        for (String code : codes)
        {
            if (node.hasValue(code))
            {
                node = node.getChildFor(code);
            }
            else
            {
                //Node not found
                return false;
            }
        }
        return true;
    }

    public void add(String value, List<String> codes)
    {
        Node node = root;
        for(String code : codes)
        {
            if (node.hasValue(code))
            {
                node = node.getChildFor(code);
            }
            else
            {
                Node newNode = new Node(code);
                node.addNode(newNode);
                node = newNode;
            }
        }

        //On the last node set it's value.
        node.addLeaf(value);
    }

    public Node getLeafNode(List<String> code)
    {
        Node node = root;
        for (String str : code)
        {
            if (node.hasValue(str))
            {
                node = node.getChildFor(str);
            }
        }
        //Breaks if not found in dictionary.
        return node;
    }

    public String getValue(List<String> code)
    {
        Node node = root;
        for (String str : code)
        {
            if (node.hasValue(str))
            {
                node = node.getChildFor(str);
            }
        }
        //Breaks if not found in dictionary.
        return node.getLeafValue();
    }

    public static class Node
    {
        Collection<Node> children = new LinkedList<Node>();

        public List<String> getLeaves()
        {
            return leaves;
        }

        public void setLeaves(List<String> leaves)
        {
            this.leaves = leaves;
        }

        List<String> leaves = new LinkedList<>();

        public Node()
        {
        }

        public String getLeafValue()
        {
            return getLeaves().get(0);
        }

        public void addLeaf(String value)
        {
            getLeaves().add(value);
        }

        public Node(String value)
        {
            setValue(value);
        }

        public Node getChildFor(String str)
        {
            Node ret = null;
            for(Node node : getChildren())
            {
                if (node.getValue().equalsIgnoreCase(str))
                {
                    ret = node;
                    break;
                }
            }
            return ret;
        }

        public String getValue()
        {
            return value;
        }

        String value;

        /**
         * Look in children.
         * @return
         */
        public boolean hasValue(String value)
        {
            for(Node node : getChildren())
            {
                if (node.getValue().equalsIgnoreCase(value))
                {
                    return true;
                }
            }
            return false;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        private void addNode(Node node)
        {
            getChildren().add(node);
        }

        public Collection<Node> getChildren()
        {
            return children;
        }
    }
}
