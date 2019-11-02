
//C&C server 


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;


import tcdIO.Terminal;


public class Client extends Node {
	static final int DEFAULT_PORT = 50000;
	static final int DEFAULT_DST_PORT = 50001;
	static final String DEFAULT_DST_NODE = "localhost";	
	ArrayList<Worker> listOfWorkers = new ArrayList<Worker>();

	Terminal terminal;
	InetSocketAddress dstAddress;
	/*
	 * 
	 */
	Client(Terminal terminal, int port, String dstHost, int dstPort) {
		try {
			this.terminal= terminal;
			socket= new DatagramSocket(port);
			listener.go();
			dstAddress= new InetSocketAddress(dstHost, dstPort);

		}
		catch(java.lang.Exception e) {e.printStackTrace();}
	}

	/**
	 * Assume that incoming packets contain a String and print the string.
	 */
	public synchronized void onReceipt(DatagramPacket packet) {
		try {
			//StringContent content = new StringContent(packet);
			//terminal.println(content.toString()); //print input from Broker
		
			
			// You could test here if the String says "end" and terminate the
			// program with a "this.notify()" that wakes up the start() method.
			
			DatagramPacket response;
			response = (new StringContent("OK")).toDatagramPacket();
			response.setSocketAddress(packet.getSocketAddress());
			socket.send(response);
		}
		catch(Exception e) {e.printStackTrace();}
	}

	
	public synchronized void start() throws Exception {
			//terminal.println("Waiting for contact");
			byte[] data = null;
			DatagramPacket packet = null;		
			data = (terminal.readString("Work Description to send: ")).getBytes();		
			terminal.println("Sending packet...");
			packet = new DatagramPacket(data, data.length, dstAddress);
			socket.send(packet);
			terminal.println("Packet sent");
			//this.wait();
	}
	
	/*
	 * 
	 */
	public static void main(String[] args) {
		try {					
			Terminal terminal= new Terminal("C&C Server");
			(new Client(terminal, DEFAULT_PORT, DEFAULT_DST_NODE, DEFAULT_DST_PORT)).start();
			terminal.println("Program completed");
		} catch(java.lang.Exception e) {e.printStackTrace();}
	}
}
