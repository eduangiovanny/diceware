import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;


public class diceware { 

public static void main(String[] args)
{
	int a = 0;
	int i;
	int k;
        String arg;
        boolean flag = false;
	
	String codigo="";
	Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        
	if (args.length == 1 )
        {
            arg = args[0];
	    if (arg.equals("5") || arg.equals("6") || arg.equals("7")) 
	    {
		if(args.length == 1)
		{
		   flag = true;
		   System.out.println("Numero de palabras ="+arg);
		int n = Integer.parseInt(arg);	
		String[] vector_palabras = new String[n];
		vector_palabras[0] = "" ;	
		for(i=1;i<=n;i++)
		{
		codigo="";

		  for(k=1;k<6;k++)
		  {
		    
		    	Random r = new Random();
		    int dado = r.nextInt(6)+1;
		    	codigo=codigo+dado;
		  }
		try {
		      File f = new File("lista_diceware.txt");
		      //creamos un Scanner para leer el fichero
		      entrada = new Scanner(f);
		      //mostramos el texto a buscar
		      
		      while (entrada.hasNext()) 
		      { //mientras no se llegue al final del fichero
			linea = entrada.nextLine();  //se lee una línea
			if (linea.contains(codigo)) 
			{   //palabra buscado se muestra por pantalla
			    String palabras = linea.substring(6);
			    System.out.println("Codigo "+i+ ":"+codigo+" -> "+palabras);
			    vector_palabras[0]=vector_palabras[0]+palabras;	
			    contiene = true;
			}
			numeroDeLinea++; //se incrementa el contador de líneas
	              }
			
         	    } 
                     catch (FileNotFoundException e) 
		     {
            		System.out.println(e.toString());
                     }  
		     catch (Exception e) 
		     {
            		System.out.println(e.toString());
		     } 
		     finally 
		     {
            		if (entrada != null) 
			{
                	  entrada.close();
			}
		     }		
		}
		System.out.println("Su frase secreta es: "+vector_palabras[0]);
		
	     }
				
		else
		{
		   flag = false;
		}
            }
	    else
            {
		System.err.println("--------------- UNIVERSIDAD DE MANIZALES --------------------");
		System.err.println("----------- Generador de contraseñas Diceware ---------------\n");
		System.err.println("Elaborado por:");
		System.err.println("            Diana Lorena Cortes - dlorec@hotmail.com");
		System.err.println("            Eduan Giovanny Arcila - eduang@umanizales.edu.co\n\n");
		System.err.println("Sintaxis: java diceware <numerodepalabras>\n");
		System.err.println("<Informacion>");
		System.err.println("El valor de <numerodepalabras> debe ser 5, 6 o 7\n");
		System.err.println("<Ejemplo>");
		System.err.println("    java diceware 6\n");

            }	
        }
	else
	{
            if (1 != args.length && flag==false)
	    {
		System.err.println("--------------- UNIVERSIDAD DE MANIZALES --------------------");
		System.err.println("----------- Generador de contraseñas Diceware ---------------\n");
		System.err.println("Elaborado por:");
		System.err.println("            Diana Lorena Cortes - dlorec@hotmail.com");
		System.err.println("            Eduan Giovanny Arcila - eduang@umanizales.edu.co\n\n");
		System.err.println("Sintaxis: java diceware <numerodepalabras>\n");
		System.err.println("<Informacion>");
		System.err.println("El valor de <numerodepalabras> debe ser 5, 6 o 7\n");
		System.err.println("<Ejemplo>");
		System.err.println("    java diceware 6\n");
 	    }
            
	}
}
}
