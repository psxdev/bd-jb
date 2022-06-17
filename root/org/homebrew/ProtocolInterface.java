package org.homebrew;

import java.io.*;
import java.rmi.*;  


public interface ProtocolInterface
{
        javax.microedition.io.Connection prim_openProtocol(String path, String unused, int mode) throws IOException,RemoteException;
        void prim_realOpen() throws IOException, RemoteException;
        //int prim_readBytes(byte[] b,int offset,int size) throws IOException, RemoteException;
}
