package com.daobei.service.impl;

import com.daobei.dto.SIPDto;
import com.daobei.service.SipService;
import org.springframework.stereotype.Service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Service
public class SipServiceImpl implements SipService {


    @Override
    public String sendSip(SIPDto sipDto) {
        try {
            // 要发送的信息
            String messg = sipDto.getMsg();
            // 建立Socket
            DatagramSocket socket = new DatagramSocket();
            // 建立收发容器
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            // 发送数据包
            sendData = messg.getBytes();
            InetAddress serverAddress = InetAddress.getByName(sipDto.getIp());
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, sipDto.getPort());
            System.out.println("开始发送");
            socket.send(sendPacket);
            System.out.println("发送结束");
            // 接收数据包
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("开始接收");
            socket.receive(receivePacket);
            System.out.println("接收结束");
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from Server: " + receivedMessage);
            // 关闭套接字
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
