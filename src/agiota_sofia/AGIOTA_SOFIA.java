/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agiota_sofia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.CRUD;
import Controller.CRUDusers;
import Controller.FicheiroDat;
import Models.Dividas;

/**
 *
 * @author antoniojoaozimila
 */
public class AGIOTA_SOFIA {

    /**
     * @param args the command line arguments
     */
    static CRUD crud = new CRUD();
    static int opcao;
    static boolean chaves;
    static CRUDusers crudUseres = new CRUDusers();
    static Scanner entrada = new Scanner(System.in);
    static FicheiroDat ficheiro = new FicheiroDat();
    static ArrayList<Object> arrayfuncionarios = ficheiro.leitura("funcionarios.dat");
    public static void main(String[] args) throws IOException {
    	
    	System.out.println("====>BEM VINDO AO SISTEMA DE GESTÃO<====");
    	if(arrayfuncionarios.size()==0) {
    		System.out.println("==>NÃO TEMOS FUNCIONARIOS REGISTADOS<==");
    		System.out.println("");
    		System.out.println("REGISTE FUNCIONARIOS.");
    		crudUseres.registarFuncionario();
    		
    	}else {
    		chaves=crudUseres.login(); 
    		}
    		
    	if(chaves==true) {
    		 do{
          System.out.println("");
          System.out.println("================================");
          System.out.println(":------------MENU--------------:");
          System.out.println("================================");
          System.out.println("[1]Registar Dívidas");
          System.out.println("[2]Listar Devedores");
          System.out.println("[3]Procurar Devedores");
          System.out.println("[4]Registar Pagamento de Dívidas");
          System.out.println("[5]Visualizar Estatísticas");
          System.out.println("[6]Registar Funcionarios");
          System.out.println("[0]sair");
          System.out.println("");
          
          opcao=entrada.nextInt();
          switch(opcao){
                          case 1: crud.RegistarDevedor(); break;   
                          case 2: crud.ler();break;    
                          case 3: crud.buscar(); break;
                          case 4: crud.pagamento(); break;
                          case 5:crud.estatisticas(); break;
                          case 6: crudUseres.registarFuncionario(); break;
                          default:System.out.println("Saindo...");               
          
          }
           }while(opcao!=0);
    	}else {
    		System.out.println("==>O ACESSO FOI ACESSO NEGADO TENTE NOVAMENTE<==");
    	}
    	
       
    }

}
