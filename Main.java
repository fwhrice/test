package com.playerMain;

import com.playerView.*;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.embedded.DefaultAdaptiveRuntimeFullScreenStrategy;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class Main {
	
	static mainWindow frame;
	static controlFrame cFrame;
	public  static void main(String[] args) {
		//�������ã���vlc sdk���뵽eclipse
		NativeLibrary.addSearchPath(
		RuntimeUtil.getLibVlcLibraryName(), "D:\\vlc player\\VLC");
		//�����·����vlc�İ�װ·��
		Native.load(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
		boolean found = new NativeDiscovery().discover();
		System.out.println(found);
		System.out.println(LibVlc.INSTANCE.libvlc_get_version());
		
		//�����߳�
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				try {
					frame =new mainWindow();
					frame.setVisible(true);
					String[] optionDecode = {"--subsdec-encoding=GB18030"};
					frame.getMediaPlayer().playMedia("D:\\premiere\\growl_1.mpg");
				}catch(Exception e) {
					e.printStackTrace();//׷�ٴ�ӡ�쳣��Ϣ
				}
			}
		});
	}
	
	//���ļ�
	public void openFile() {
		JFileChooser fchooser =new JFileChooser();
		int c =fchooser.showOpenDialog(null);//�����ļ�ѡ������λ�ã�nullΪ��Ļ����
		//�ж��Ƿ�ȷ�����ļ�
		if(c ==JFileChooser.APPROVE_OPTION) {
			File file =fchooser.getSelectedFile();//�ļ���ѡ��
			//���Ÿ�·���µ���Ƶ
			frame.getMediaPlayer().playMedia(file.getAbsolutePath()/*�����ļ��ľ���·��*/);
		}
	}
	//����
	public void play() {
		frame.getMediaPlayer().play();
	}
	
	//��ͣ
	public void pause(){
		frame.getMediaPlayer().pause();
	}
	
	//��������
	public void setVolume(int v) {
		frame.getMediaPlayer().setVolume(v);
	}
	
	//ֹͣ
	public void stop() {
		frame.getMediaPlayer().stop();
	}
	
	//�˳�������
	public void exit() {
		frame.getMediaPlayer().release();
		System.exit(0);
	}
}
























