/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trigonometria;

/**
 *
 * @author CAD Alfred
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
       Angulo anguloA = new Angulo(60);
       Angulo anguloB = new Angulo(40);
       Angulo anguloC = new Angulo(50);
       Angulo prueba = new Angulo(45);
       // el area y tres angulos
       Triangulo test1 = new Triangulo(19.45,anguloA,anguloB,anguloC);
       // un lado y dos angulos funciona
       Triangulo test2 = new Triangulo(22, anguloB, anguloC);
        Triangulo test3 = new Triangulo ( 22, 25,anguloC);
        System.out.println(Triangulo.anguloFaltante(anguloA, anguloB));
       
        
        /** System.out.println("los grados en radianes son " + prueba.toRadianes() );
        System.out.println("Seno: " + prueba.getSeno());
        System.out.println("Coseno: " + prueba.getCoseno()); 
        System.out.println("Tangente: " + prueba.getTangente());
        System.out.println("Agudo: " + prueba.esAgudo());
        System.out.println("Recto: " + prueba.esRecto());
        System.out.println("Obtuso: "+ prueba.esObtuso());
        prueba.visualizar();
        System.out.println(test1.toString()+ "--->");
        System.out.println(test1.getTipoAngulos());
        System.out.println(test2.getTipoAngulos());
        test1.visualizar();***/
        //test3.visualizar();
        
        
    }
    
}
