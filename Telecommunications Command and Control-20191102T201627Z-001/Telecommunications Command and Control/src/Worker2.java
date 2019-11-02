import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import tcdIO.Terminal;

/**
 *
 * Worker class
 * 
 * An instance accepts user input
 *
 */
public class Worker2 extends Node {
	static final int DEFAULT_SRC_PORT = 50003;
	static final int DEFAULT_DST_PORT = 50001;
	static final String DEFAULT_DST_NODE = "localhost";

	Terminal terminal;
	InetSocketAddress dstAddress;

	/**
	 * Constructor
	 * 
	 * Attempts to create socket at given port and create an InetSocketAddress for
	 * the destinations
	 */
	Worker2(Terminal terminal, String dstHost, int dstPort, int srcPort) {
		try {
			this.terminal = terminal;
			dstAddress = new InetSocketAddress(dstHost, dstPort);
			socket = new DatagramSocket(srcPort);
			listener.go();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Assume that incoming packets contain a String and print the string.
	 */
	public synchronized void onReceipt(DatagramPacket packet) {
		StringContent content = new StringContent(packet);
		this.notify();
		terminal.println("Broker: " + content.toString());
		
	}

	/**
	 * Sender Method
	 * 
	 */
	public synchronized void start() throws Exception {
		terminal.println("Broker: What's your name?");
		String name = terminal.readString("");
		terminal.println("Broker: Hi " + name);
		terminal.println("Broker: Are you available for work?");	//get prompt from worker
		byte[] data = null;
		DatagramPacket packet = null;
		//this.wait();
		data = (terminal.readString("String to send: ")).getBytes();
		packet = new DatagramPacket(data, data.length, dstAddress);
		socket.send(packet);
		terminal.println("Packet sent");

	}

	/**
	 * Test method
	 * 
	 * Sends a packet to a given address
	 */
	public static void main(String[] args) {
		try {
			Terminal terminal = new Terminal("Worker2");
			(new Worker2(terminal, DEFAULT_DST_NODE, DEFAULT_DST_PORT, DEFAULT_SRC_PORT)).start();
			terminal.println("Program completed");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}