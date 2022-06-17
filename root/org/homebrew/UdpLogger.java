package org.homebrew;

import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.Boolean;

public class UdpLogger
{
	public int loggerPort;
	public String loggerServer;
	public boolean loggerInitialized;
	public DatagramSocket loggerSocket;
	private byte[] loggerSendBytes;
	private String loggerErrorMessage;

	public UdpLogger(String server,int port)
	{
		try
		{
			loggerSocket=new DatagramSocket();
			loggerPort=port;
			loggerServer=server;
			loggerSendBytes=new byte[4096];
			loggerInitialized=true;
			loggerErrorMessage="No error";	
		}
		catch(Exception e)
		{
			loggerInitialized=false;
			loggerErrorMessage=e.getMessage();
		}
	}
	public boolean isInitialized()
	{
		return loggerInitialized;
	}
	public String getLastError()
	{
		return loggerErrorMessage;
	}
	private void sendUdpMessage(String message)
	{
		try
		{
			loggerSendBytes=message.getBytes();
			DatagramPacket sendPacket=new DatagramPacket(loggerSendBytes, loggerSendBytes.length, InetAddress.getByName(loggerServer), loggerPort);
			loggerSocket.send(sendPacket);
		}
		catch(Exception e)
		{
			loggerErrorMessage=e.getMessage();
		}
	}
	public void debug(String msg)
	{
		//tested on powerdvd only
		String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String message="[PROSPERO][DEBUG]["+className+"]["+methodName+"]["+lineNumber+"] "+msg+"\n";
		sendUdpMessage(message);
	}
	public void error(String msg)
	{
		String message="[PROSPERO][ERROR] "+msg+"\n";
		sendUdpMessage(message);
	}
	public void info(String msg)
	{
		String message="[PROSPERO][INFO] "+msg+"\n";
		sendUdpMessage(message);
	}
	/*public static void main(String[] args) throws Exception
	{
		UdpLogger log=new UdpLogger("192.168.1.12",18194);
		System.out.println(log.getLastError());
		log.info("jander jar");
		log.error("jander jur");
		log.debug("jander jir");
	}*/
}
