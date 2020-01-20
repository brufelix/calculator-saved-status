package Questao03;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		Socket client = null;
		Armazen amz = new Armazen();
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(Integer.parseInt(args[0]));
			while (true) {
				client = server.accept();
				if (amz.checking(String.valueOf(client.getInetAddress()))) {
					System.out.println("Conexão restabelecida");
					@SuppressWarnings("unused")
					ClientStates cs = new ClientStates(client, amz.getBuffer(String.valueOf(client.getInetAddress())));
				} else {
					System.out.println("Conexão estabelecida");
					Buffer b = new Buffer();
					b.setIp(String.valueOf(client.getInetAddress()));
					@SuppressWarnings("unused")
					ClientStates cs = new ClientStates(client, b);
					amz.add(b);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}