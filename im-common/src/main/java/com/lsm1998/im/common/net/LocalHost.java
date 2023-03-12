package com.lsm1998.im.common.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class LocalHost
{
    /**
     * 获取本机IP地址
     *
     * @return ip
     * @throws SocketException
     */
    public static String localHost() throws SocketException
    {
        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip;
        while (allNetInterfaces.hasMoreElements())
        {
            NetworkInterface netInterface = allNetInterfaces.nextElement();
            if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp())
            {
                continue;
            }
            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements())
            {
                ip = addresses.nextElement();
                if (ip instanceof Inet4Address)
                {
                    return ip.getHostAddress();
                }
            }
        }
        return null;
    }
}
