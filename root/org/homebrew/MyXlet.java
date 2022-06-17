package org.homebrew;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.awt.*;
import java.net.*;

import javax.media.*;

import javax.tv.xlet.*;

import org.bluray.ui.event.HRcEvent;

import org.dvb.event.UserEvent;

import org.havi.ui.*;


public class MyXlet implements Xlet, ControllerListener {

	private HScene scene;
	private Container gui;
	private XletContext context;
	private final ArrayList messages = new ArrayList();
	public UdpLogger log;
	//change to your pc ip
	public String host="192.168.1.12";

	private void printStackTrace(Throwable e)
    {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String trace = sw.toString();
		if(trace.charAt(trace.length()-1) != '\n')
			trace += '\n';
		String line = "";
		for(int i = 0; i < trace.length(); i++)
		{
			char x = trace.charAt(i);
			if(x == '\n')
			{
				log.error(line);
				line = "";
			}
			else
				line += x;
		}
	}
	public void showDir(String pathName)
	{
		try
        {
        	log.info("[+] Creating File object with path "+pathName);
        	messages.add("[+] Creating File object with path "+pathName);
			FileImpl fatherPath=new FileImpl(pathName);
			log.info("[+] Creating FakeIxcProxy object...");
			messages.add("[+] Creating FakeIxcProxy object...");
			FakeIxcProxy ixc=new FakeIxcProxy(fatherPath);
			if(ixc!=null)
			{
				log.info("[+] FakeIxcProxy object created...");
				messages.add("[+] FakeIxcProxy object created...");
			}
			else
			{
				log.error("[+] FakeIxcProxy is null something is wrong...");
				messages.add("[+] FakeIxcProxy is null something was wrong...");
				return;
			}
			log.info("[+] Invoking list method with pInvokeMethod...");
			messages.add("[+] Invoking list method with pInvokeMethod...");
			String [] entryList=(String[])ixc.pInvokeMethod(new Object[]{}, "list", "()[Ljava/lang/String;");
        	if(entryList!=null)
        	{
        		for (int i=0;i<entryList.length;i++)
        		{		
        			log.info(entryList[i]);
        		}
        	}
        	else
        	{
        		log.error("[+] list return NULL");
        	}
        }
        catch(Exception e)
        {
			printStackTrace(e);
		}
	}
	
	public void initXlet(XletContext context) 
	{
		this.context = context;
		scene = HSceneFactory.getInstance().getDefaultHScene();
		try 
		{

			log=new UdpLogger(host,18194);
			log.info("[+] UdpLogger initialized..."); 
			messages.add("[+] UdpLogger initialized...");
			log.info("[+] Receive udp log in "+host+" with: socat udp-recv:18194 stdout");
			messages.add("[+] Receive udp log in "+host+" with: socat udp-recv:18194 stdout");
			gui = new Screen(messages);
			gui.setSize(1920, 1080); // BD screen size
			scene.add(gui, BorderLayout.CENTER);
			messages.add("[+] bd-jb by bigboss based on TheFlow and sleirsgoevy implementation");
			log.info("[+] bd-jb by bigboss based on TheFlow and sleirsgoevy implementation");
			log.info("[+] Escaping Java Sandbox...");
			messages.add("[+] Escaping Java Sandbox...");
			showDir("/app0");			
		} 
		catch (Exception e)
		{
			printStackTrace(e);
		}
		scene.validate();
	}

	public void startXlet()
	{
		gui.setVisible(true);
		scene.setVisible(true);
		gui.requestFocus();
	}

	public void pauseXlet()
	{
		gui.setVisible(false);
	}

	public void destroyXlet(boolean unconditional)
	{
		scene.remove(gui);
		scene = null;
	}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void numberKeyPressed(int value){}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void colorKeyPressed(int value){}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void popupKeyPressed(){}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void enterKeyPressed(){}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void arrowLeftKeyPressed(){}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void arrowRightPressed(){}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void arrowUpPressed(){}

	/**
	 * Subclasses should override this if they're interested in getting
	 * this event.
	 **/
	protected void arrowDownPressed(){}

	public void controllerUpdate(ControllerEvent arg0)
	{
		// TODO Auto-generated method stub	
	}
}