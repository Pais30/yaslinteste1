package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EstatisticasTXT {
public static  void escritaM(String caminho,double somaD, double media,double somaDP,String nomeMaiorD,double maiorD,String nomeMenorD,double menorD) throws IOException {
    	
    	BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(caminho,true));
    	
    	
    //	Scanner in = new Scanner(System.in);	
    	
    	
    //	bufferedwriter.append("======================RELATORIO====================");
    //	bufferedwriter.newLine();
    	bufferedwriter.append("    CODIGO: "+somaD+"\n");
    	bufferedwriter.newLine();
    	bufferedwriter.append("      NOME: "+media+"\n");
    	bufferedwriter.newLine();
        bufferedwriter.append("PRATILEIRA: "+somaDP+"\n");
    	bufferedwriter.newLine();

        bufferedwriter.append("   EDITORA: "+nomeMaiorD+"\n");
    	bufferedwriter.newLine();
        bufferedwriter.append("    CLASSE: "+maiorD+"\n");
    	bufferedwriter.newLine();
        bufferedwriter.append("    CLASSE: "+nomeMenorD+"\n");
     	bufferedwriter.newLine();
     	  bufferedwriter.append("    CLASSE: "+menorD+"\n");
       	bufferedwriter.newLine();
    	bufferedwriter.append("=====================================================================================================\n");
        bufferedwriter.newLine();
    	
    	
    	bufferedwriter.close();
    	
	
    	 
    
    	
    	
    }

}
