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
public class main {
    
    public static void main(String[] args)
    {
        JSplay<Integer, String> s = new JSplay();
        
        s.put(1, "3E-3D-29-2D-DC-20");
        s.put(4, "96-70-EC-23-5E-6A");
        s.put(42, "6D-E8-9F-46-57-9C");
        s.put(90, "0B-34-51-1C-76-D5");
        s.put(50, "DE-AD-BE-EF-76-D5");
        
        System.out.println("AFTER PUTTING ALL ELEMENTS:");
        System.out.println(s.toString());
        s.get(1);
        s.get(90);
        s.get(42);
        System.out.println("AFTER GETTING ELEMENTS:");
        System.out.println(s.toString());
        
    }
}
