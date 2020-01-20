package Questao03;

import java.io.DataInputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket client = null;
		DataInputStream in;
		String data;
		try {
			client = new Socket("localhost", Integer.parseInt(args[1]));
			in = new DataInputStream(client.getInputStream());
			@SuppressWarnings("unused")
			Send s = new Send(client);
			while (true) {
				data = in.readUTF();
				System.out.println("Result: " + data);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}