/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsplay;

/**
 *
 * @author clotifoth
 */
public class Node<K extends Comparable<K>, V> {
    Node left;
    Node right;
    Node parent;
    
    K key;
    V value;
    
    public Node (K k, V v){
        key = k;
        value = v;
    }
    
}
