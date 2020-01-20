package Questao03;

import java.util.ArrayList;

public class Armazen {
	ArrayList<Buffer> amaz = new ArrayList<>();

	public void add(Buffer b) {
		amaz.add(b);
	}

	public Buffer getBuffer(String ip) {
		for (Buffer clientBuffer : amaz) {
			if (clientBuffer.ip.equals(ip)) {
				return clientBuffer;
			}
		}
		return null;
	}

	public boolean checking(String ip) {
		for (Buffer clientBuffer : amaz) {
			if (clientBuffer.ip.equals(ip)) {
				return true;
			}
		}
		return false;
	}
}
