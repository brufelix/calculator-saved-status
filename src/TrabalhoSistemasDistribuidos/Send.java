package Questao03;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Send extends Thread {
	private static Scanner input = new Scanner(System.in);
	Socket aclient;
	DataOutputStream out;
	String data;

	public Send(Socket client) throws IOException {
		aclient = client;
		out = new DataOutputStream(aclient.getOutputStream());
		this.start();
	}

	public void run() {
		try {
			while (true) {
				data = input.nextLine();
				out.writeUTF(data);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
