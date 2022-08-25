package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicPasswordFieldUI;

import Models.Dividas;
import Models.Usuarios;

public class CRUDusers {
	static FicheiroDat ficheiro = new FicheiroDat();

	static ArrayList<Object> arrayfuncionarios = ficheiro.leitura("funcionarios.dat");
	static Scanner entrada = new Scanner(System.in);

	public void registarFuncionario() {
		int id = arrayfuncionarios.size();
		System.out.println("USER NAME.");
		String userName = entrada.nextLine();
		System.out.print("PASSWORD.");
		String passWord = entrada.nextLine();
		arrayfuncionarios.add(new Usuarios(id, userName, passWord));
		ficheiro.escrever(arrayfuncionarios, "funcionarios.dat");
		System.out.println("==>FUNCIONARIO REGISTADO COM SUCESSO<==");

	}

	public Boolean login() {
		String inserirNome = "";
		String inserirSenha = "";
        System.out.println("========================================");
		System.out.println(":..................LOGIN...............:");
		System.out.println("========================================");
		System.out.println("");
		System.out.println("");
		System.out.println("INFORME O NOME DO USUARIO.");
		inserirNome = entrada.nextLine();
		System.out.println("INFORME A PALAVRA PASSE.");
		inserirSenha = entrada.nextLine();
		for (Object item : arrayfuncionarios) {
			String userNameF = (String) ((Usuarios) item).getUserName();
			String passwordF = (String) ((Usuarios) item).getPassWord();
			if (userNameF.equalsIgnoreCase(inserirNome) && passwordF.equalsIgnoreCase(inserirSenha)) {
				System.out.println("");
				System.out.println("==>USUARIO LOGADO COM SUCESSO<==");
				
				return true;
			}

		}
		return false;
	}
}
