/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author antoniojoaozimila
 */
public class FicheiroDat {
     
    public static void escrever(ArrayList<Object> lista,String nomeArq){
			
		File arquivo = new File(nomeArq);
		
		try{
			
			arquivo.delete();
			arquivo.createNewFile();
			
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arquivo));
			output.writeObject(lista);
			
			
			output.close();
			
		}
		catch(IOException c){
			System.out.println(c);
			
		}
	}
	
	public static ArrayList<Object> leitura(String nomeAquivo){
	
		ArrayList<Object> lista = new ArrayList<>();
		
		
		try{
			
			File arquivo = new File(nomeAquivo);
			
			
			if(arquivo.exists()){
				
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(arquivo));
				
				lista = (ArrayList<Object>) objectInputStream.readObject();
			
				objectInputStream.close();
				
			}
			
			
		}
		catch(IOException e){
			System.out.print(e);
			
		}
		catch(ClassNotFoundException x){
			System.out.println(x);
			
		}
		
		
	return (lista);	
	}
}
