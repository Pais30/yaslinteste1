/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Dividas;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author antoniojoaozimila
 */
public class CRUD {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static FicheiroDat ficheiro = new FicheiroDat();
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Object> arraydividas = ficheiro.leitura("devedores.dat");
    static int cont=0;
    static Date dataAtual = new Date();
    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static String dataFormatada = dateFormat.format(dataAtual);
    static EstatisticasTXT estaTXT = new EstatisticasTXT();
    static int quantidade;
    
    

    public void RegistarDevedor() {
    	
        int id =arraydividas.size();
        String nomeDevedor = "";
        String apelidoDevedor = "";
        String data =dataFormatada;
;
        String estadoDivida = "Não Pago";
        double valorDivida = 0;
        double valorAPagar = 0;
        System.out.println("INFORME A QUANTIDADE DE DEVEDORES A REGISTRAR:.");
        quantidade=entrada.nextInt();
        
         for(int i=0;i<quantidade;i++) {
        	 System.out.println("INFORME O NOME DO DEVEDOR:. "+(i+1));
             nomeDevedor = entrada.next();
             System.out.println("INFORME O APELIDO DO DEVEDOR:. "+(i+1));
             apelidoDevedor = entrada.next();
             System.out.println("INFORME O VALOR DA DIVIDA (MT):. "+(i+1));
             valorDivida = entrada.nextDouble();
             if (valorDivida <= 100) {
                 valorAPagar = valorDivida + valorDivida * 0.4;
             } else if (valorDivida <= 500) {
                 valorAPagar = valorDivida + valorDivida * 0.3;
             } else if (valorDivida <= 1000) {
                 valorAPagar = valorDivida + valorDivida * 0.2;
             } else if (valorDivida > 1000) {
                 valorAPagar = valorDivida + valorDivida * 0.15;

             }
             if (valorDivida<0 || valorDivida>5000) {
             	System.out.println("VALOR DA DIVIDA INVALIDO");
             	break;
             }
             // adicionando no array de objecto
             arraydividas.add(new Dividas(id, nomeDevedor, apelidoDevedor, data, estadoDivida, valorDivida, valorAPagar));
             //guardando no ficheiro de objecto
             ficheiro.escrever(arraydividas, "devedores.dat");
             id++; 
         }

       
        System.out.println("DEVEDOR(A)(S) REGISTADO(S) COM SUCESSO...");
    }

    public void ler() {
        
        System.out.println(ficheiro.leitura("devedores.dat").toString());
    }
    
    public void buscar() {
    	System.out.println("INFOME O NOME DO DEVEDOR.");
    	String nome =entrada.nextLine();
    	for(Object item:arraydividas) {
    	String nomeF = (String) ((Dividas) item).getNomeDevedor();
    		if(nome.equalsIgnoreCase(nomeF)) {
    			System.out.print(item.toString());
    			break;
    		}else {
    			System.out.println("DEVEDOR NÃO ENCONTRADO");
    		}
    	}
    }
    
    public void pagamento() {
    	System.out.println("INFORME O NOME DO DEVEDOR QUE IRÁ PAGAR A DIVIDA.");
        String nome=entrada.next();
        String estadoEdit="Pago";
        String nomeF="";
        String apelidoF="";
        double valorDividaF=0;
        double valorAPagarF=0;
       
        String dataEdit=dataFormatada;
        int posicaoAtual=0;
        for(Object item:arraydividas) {
        	 nomeF = (String) ((Dividas) item).getNomeDevedor();
        	if(nome.equalsIgnoreCase(nomeF)) {
        		posicaoAtual=(Integer) ((Dividas) item).getId();
            	 apelidoF=(String) ((Dividas) item).getApelidoDevedor();
            	 valorDividaF= (Double) ((Dividas) item).getValorDivida();
            	 valorAPagarF =(Double) ((Dividas) item).getValorAPagar();
            	System.out.print(posicaoAtual);
      
   break;
        	}
        	cont++;
        	}
        arraydividas.add(posicaoAtual, new Dividas(posicaoAtual,nomeF,apelidoF,dataEdit,estadoEdit,valorDividaF,valorAPagarF));
        arraydividas.remove(posicaoAtual+1);
        ficheiro.escrever(arraydividas, "devedores.dat");
    System.out.println("PAGAMENTO EFECTUADO COM SUCESSO...");
        
    }
    
    public void estatisticas() throws IOException {
    
    	double somaD=0; //soma das dividas
    	double somaDP=0; //soma das dividas pagas
    	double media=0;
    	double maiorD=0;
    	double menorD=0;
    	String nomeMaiorD="";
    	String nomeMenorD="";
    	for(Object item:arraydividas) {
    		double valorDivida= (Double) ((Dividas) item).getValorDivida();
    		String estado=(String) ((Dividas) item).getEstadoDivida();
    		somaD=somaD+valorDivida;
    		
    		if(estado.equalsIgnoreCase("pago")) {
    			somaDP=somaDP+valorDivida;
    		}
    		if(valorDivida>maiorD) {
    			maiorD=valorDivida;
    			nomeMaiorD=(String)((Dividas) item).getNomeDevedor();
    		}
    		if(valorDivida<menorD) {
    			menorD=valorDivida;
    			nomeMenorD=(String) ((Dividas) item).getNomeDevedor();
    		}
    	}
    	
    	media=somaD/arraydividas.size();
    	
    	System.out.println("VALOR TOTAL EM DIVIDAS:. "+somaD);
    	System.out.println("MEDIA DAS DIVIDAS:. "+media);
    	System.out.println("VALOR TOTAL DAS DIVIDAS PAGAS:. "+somaDP);
    	System.out.println("DEVEDOR COM MAIOR DIVIDA:. "+nomeMaiorD+" COM:. "+maiorD);
    	System.out.println("DEVEDOR COM MENOR DIVIDA:."+nomeMenorD+" COM:."+menorD);
    	
    	estaTXT.escritaM("Estatisticas.txt",somaD,media,somaDP,nomeMaiorD,maiorD,nomeMenorD,menorD);
    	
    ////Brindo ficheiro txt
    	try{
  		   Runtime.getRuntime().exec("cat /home/antoniojoaozimila/Documents/AGIOTA_SOFIA/Estatisticas.txt");
  		   
  		}catch(IOException c){
  		   System.out.println(c);
  		   
  		}
    	
    }
    
  

    

}
