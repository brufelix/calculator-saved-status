package Questao03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Received {
	Socket client;
	DataInputStream in;
	String data;
	public Received(Socket s) throws IOException {
		this.client = s;
		in = new DataInputStream(client.getInputStream());
	}
	public void run() {
		try {
			while(true) {
				data = in.readUTF();
				System.out.println(data);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
