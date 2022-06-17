package org.homebrew;

import java.io.*;
import java.rmi.*;  

public interface FileInterface extends Remote
{
	public String[] list() throws RemoteException;
}



