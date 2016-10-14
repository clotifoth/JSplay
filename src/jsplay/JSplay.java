package jsplay;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clotifoth
 * @param <K> Key
 * @param <V> Value
 */
public class JSplay<K extends Comparable, V> {
    Node root;
    
    
    public boolean contains(K key) 
    {
        return get(key) != null;
    }
    
    public V get(K key) 
    {
        root = splay(root, key);
        int cmp = key.compareTo(root.key);
        if (cmp == 0) return (V)root.value;
        else          return null;
    }    
    
    /**
     * This method inserts an element into the given splay.
     * @param key
     * @param value
     */
    
    public void put(K key, V value)
    {
        /*
            No elements added; simply make our new value the root.
        */
        if(root == null) root = new Node(key, value);
        /*
            Otherwise, we've got to splay to the key, and either insert a new 
            node at the key or update the current value at the key.
        */
        else
        {
            root = splay(root, key);
        

            int keyComparison = key.compareTo(root.key);
            Node n = new Node(key, value);

            if(keyComparison < 0) // New node with current root to the right.
            {
                n.left = root.left;
                n.right = root;
                root.left = null;
                root = n;
            }
            else if(keyComparison > 0) // New node with current root to the left.
            {
                n.right = root.right;
                n.left = root;
                root.right = null;
                root = n;
            }
            else // Key present- update value.
            {
                root.value = value;
            }
        }
    }
    
    /**
     * If a node with K is present, it is brought to the root of the splay;
     * otherwise, the last node along our search path is at the root.
     */
    public Node splay(Node r, K key)
    {
        if(r == null) return null; // GIGO
        
        int keyComparison = key.compareTo(r.key);
        
        if(keyComparison < 0)
        {
            /* If r.left is null, it is the smallest element already. */
            if(r.left == null) return r;
            int secondComparison = key.compareTo(r.left.key);
            if(secondComparison < 0)
            {
                r.left.left = splay(r.left.left, key); // Zig Zig
                r = rotateRight(r);
            }
            else if(secondComparison > 0)
            {
                r.left.right = splay(r.left.right, key); // Zig Zag
                if(r.left.right != null) r.left = rotateLeft(r.left);
            }
            
            if(r.left == null) return r;
            else return rotateRight(r);
        }
        else if(keyComparison > 0)
        {
            /* If r.right is null, it is the largest element already. */
            if(r.right == null) return r;
            
            int secondComparison = key.compareTo(r.right.key);
            if(secondComparison < 0)
            {
                r.right.left = splay(r.right.left, key); // Zig Zig
                if(r.right.left != null) r.right = rotateRight(r.right);
            }
            else if(secondComparison > 0)
            {
                r.right.right = splay(r.right.right, key); // Zig Zag
                r = rotateLeft(r);
            }
            
            if(r.right == null) return r;
            else return rotateLeft(r);
        }
        else // Our desired node is already at root.
        {
            return r;
        }
    }
    
    /*
        Public wrappers.
    */
    public int height() { return height(root); }
    
    public int size() { return size(root); }
    
    /*
        A few useful utility functions.
    */
    private int height(Node x) 
    {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    
    private int size(Node x) 
    {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    private Node rotateRight(Node r) {
        Node t = r.left;
        r.left = t.right;
        t.right = r;
        return t;
    }

    // left rotate
    private Node rotateLeft(Node r) {
        Node t = r.right;
        r.right = t.left;
        t.left = r;
        return t;
    }
    
    /*
        Breadth-first search to return an output String with the contents of
        the splay.
    */
    public String toString()
    {
        if(root == null) return "null";
        StringBuilder output = new StringBuilder();
        inOrderReport(root, output);
        return output.toString();
        
    }
    private void inOrderReport(Node n, StringBuilder app)
    {
        if(n.left != null) inOrderReport(n.left, app);
        app.append("Key: ").append(n.key.toString()).append("\n");
        app.append("Value: ").append(n.value.toString()).append("\n");
        
        app.append("Left Key: ");
        if(n.left != null) app.append(n.left.key.toString()).append("\n");
        else app.append("null").append("\n");
        
        app.append("Right Key: ");
        if(n.right != null) app.append(n.right.key.toString()).append("\n\n");
        else app.append("null").append("\n\n");
        
        if(n.right != null) inOrderReport(n.right, app);
    }
}
