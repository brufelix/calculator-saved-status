package Questao03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientStates extends Thread {
	Socket client;
	DataInputStream in;
	DataOutputStream out;
	Buffer buffer;
	String[] vector;
	String data;

	public ClientStates(Socket s, Buffer b) throws IOException {
		client = s;
		buffer = b;
		in = new DataInputStream(client.getInputStream());
		out = new DataOutputStream(client.getOutputStream());
		this.start();
	}

	public boolean isOperator(String args) {
		String[] Op = { "/", "*", "-", "+" };
		for (String operator : Op) {
			if (operator.equals(args))
				return true;
		}
		return false;
	}

	public void run() {
		Calculator calc = new Calculator();
		while (true) {
			try {
				data = in.readUTF();
				vector = data.split(" ");
				if (vector[0].equals(".exit")) {
					client.close();
					System.out.println("Você saiu!");
				}
				if (isOperator(vector[0])) {
					buffer.operator = vector[0];
					buffer.cont++;
				} else if (buffer.cont == 1) {
					buffer.value1 = Double.parseDouble(vector[0]);
					buffer.cont++;
				} else {
					buffer.value2 = Double.parseDouble(vector[0]);
					String result = calc.calculator(buffer.operator, buffer.value1, buffer.value2);
					buffer.cont = 0;
					out.writeUTF(result);
				}
			} catch (Exception e) {
			}
		}
	}
}