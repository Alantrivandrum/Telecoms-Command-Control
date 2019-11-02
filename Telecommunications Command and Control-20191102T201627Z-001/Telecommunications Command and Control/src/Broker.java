import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import tcdIO.Terminal;

public class Broker extends Node {
	static final int DEFAULT_SRC_PORT = 50001;
	static final int DEFAULT_DST_PORT = 50000;
	static final int DEFAULT_DST_PORT_WORKER = 50002;
	static final String DEFAULT_DST_NODE = "localhost";

	Terminal terminal;
	InetSocketAddress dstAddress;
	InetSocketAddress dstAddressWorker;

	/**
	 * Constructor
	 * 
	 * Attempts to create socket at given port and create an InetSocketAddress for
	 * the destinations
	 */
	Broker(Terminal terminal, String dstHost, int dstPort, int srcPort, int dstPortWorker) {
		try {
			this.terminal = terminal;
			dstAddress = new InetSocketAddress(dstHost, dstPort);
			dstAddressWorker = new InetSocketAddress(dstHost, dstPortWorker);
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
		
		terminal.println( content.toString());
		terminal.println("\n");
		if ((content.toString().trim().equalsIgnoreCase("Yes"))) {
			
			
		}
	}

	/**
	 * Sender Method
	 * 
	 */
	public synchronized void start() throws Exception {
		byte[] data = null;
		DatagramPacket packet = null;
		DatagramPacket packetWorker = null;
		this.wait();
		data = (terminal.readString("Input to send: ")).getBytes();
		terminal.println("Sending packet...");
		packet = new DatagramPacket(data, data.length, dstAddress);
		packetWorker = new DatagramPacket(data, data.length, dstAddressWorker);
		socket.send(packet);
		socket.send(packetWorker);
		terminal.println("Packet sent");

	}

	/**
	 * Test method
	 * 
	 * Sends a packet to a given address
	 */
	public static void main(String[] args) {
		try {
			Terminal terminal = new Terminal("Broker");
			(new Broker(terminal, DEFAULT_DST_NODE, DEFAULT_DST_PORT, DEFAULT_SRC_PORT, DEFAULT_DST_PORT_WORKER))
					.start();
			terminal.println("Program completed");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
