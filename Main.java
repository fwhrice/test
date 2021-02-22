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
		//环境配置，将vlc sdk导入到eclipse
		NativeLibrary.addSearchPath(
		RuntimeUtil.getLibVlcLibraryName(), "D:\\vlc player\\VLC");
		//导入的路径是vlc的安装路径
		Native.load(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
		boolean found = new NativeDiscovery().discover();
		System.out.println(found);
		System.out.println(LibVlc.INSTANCE.libvlc_get_version());
		
		//创建线程
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				try {
					frame =new mainWindow();
					frame.setVisible(true);
					String[] optionDecode = {"--subsdec-encoding=GB18030"};
					frame.getMediaPlayer().playMedia("D:\\premiere\\growl_1.mpg");
				}catch(Exception e) {
					e.printStackTrace();//追踪打印异常信息
				}
			}
		});
	}
	
	//打开文件
	public void openFile() {
		JFileChooser fchooser =new JFileChooser();
		int c =fchooser.showOpenDialog(null);//弹出文件选择器的位置，null为屏幕中央
		//判断是否确认了文件
		if(c ==JFileChooser.APPROVE_OPTION) {
			File file =fchooser.getSelectedFile();//文件被选中
			//播放该路径下的视频
			frame.getMediaPlayer().playMedia(file.getAbsolutePath()/*返回文件的绝对路径*/);
		}
	}
	//播放
	public void play() {
		frame.getMediaPlayer().play();
	}
	
	//暂停
	public void pause(){
		frame.getMediaPlayer().pause();
	}
	
	//调节音量
	public void setVolume(int v) {
		frame.getMediaPlayer().setVolume(v);
	}
	
	//停止
	public void stop() {
		frame.getMediaPlayer().stop();
	}
	
	//退出播放器
	public void exit() {
		frame.getMediaPlayer().release();
		System.exit(0);
	}
}
























