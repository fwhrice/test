package com.playerView;

import com.playerMain.*;
import com.playerCommand.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;


public class mainWindow extends JFrame{
	JPanel contentPane;//播放页面容器
	JMenuBar menuBar;//菜单栏
	JMenu mFile,mSetting,mHelp;//菜单
	JMenuItem mOpenFile,mExit;//菜单目录
	JPanel controlPanel;//控制页面容器
	JPanel controlButtonPanel;//控制按钮容器
	JButton bPlay,bStop;//播放，暂停按钮
	JButton bfullScreen;//全屏按钮
	JSlider volumeSlider;//音量调节滑块
	JProgressBar progress;//视频进度条
	
	int flag =0;//判断是否全屏
	
	EmbeddedMediaPlayerComponent playerComponent;//媒体播放器组件
	
	public static void mian(String args[]) {}
	//构造方法，创建播放器的主界面
	public mainWindow() {
		Main pMain =new Main();
		Command playCommand =new PlayCommand(pMain);
		Command exitCommand =new ExitCommand(pMain);
		Command pauseCommand =new PauseCommand(pMain);
		Command stopCommand =new StopCommand(pMain);
		Command volumeCommand =new VolumeCommand(pMain);
		
		iCommand icommand =new iCommand();
		icommand.PlayCommand(playCommand);
		icommand.PauseCommand(pauseCommand);
		icommand.StopCommand(stopCommand);
		icommand.ExitCommand(exitCommand);
		icommand.VolumeCommand(volumeCommand);
		
		//播放器标题
		setTitle("MyPlayer");
		//执行关闭播放器操作
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,80,900,600);
		contentPane =new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		//创建菜单
		menuBar =new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		//设置菜单
		mFile =new JMenu("文件");
		menuBar.add(mFile);
		mSetting =new JMenu("设置");
		menuBar.add(mSetting);
		mHelp =new JMenu("帮助");
		menuBar.add(mHelp);
		//设置子菜单
		mOpenFile =new JMenuItem("打开文件");
		mFile.add(mOpenFile);
		mExit =new JMenu("退出");
		mFile.add(mOpenFile);
		//为打开文件添加鼠标事件
		mOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pMain.openFile();
			}
		});
		//播放器界面
		JPanel pPanel =new JPanel();
		contentPane.add(pPanel,BorderLayout.CENTER);
		pPanel.setLayout(new BorderLayout(0,0));
		
		playerComponent =new EmbeddedMediaPlayerComponent();
		pPanel.add(playerComponent,BorderLayout.CENTER);
		//添加控制区域
		controlPanel =new JPanel();
		pPanel.add(controlPanel);
		//controlPanel.setLayout(new BorderLayout(0,0));
		//添加进度条
		progress =new JProgressBar();
		pPanel.add(progress,BorderLayout.SOUTH);
		progress.setStringPainted(true);//进度条显示字符串
		//添加播放按钮
		bPlay =new JButton(">");
		//播放按钮与暂停按钮切换
		//添加鼠标事件
		/*bPlay.addMouseListener(new MouseAdapter() {
			public void clikMouse(MouseEvent e) {
				if(bPlay.getText()==">") {
					
				}
			}
		});*/
		controlPanel.add(bPlay);
		bStop =new JButton("●");
		controlPanel.add(bStop);
		//添加音量拖条
		volumeSlider =new JSlider();
		volumeSlider.setValue(60);
		volumeSlider.setMaximum(100);
		controlPanel.add(volumeSlider);
	}
	//获取视频实例
	public EmbeddedMediaPlayer getMediaPlayer() {
		return playerComponent.getMediaPlayer();
	}
	//获取组件实例
	public JProgressBar getProgressBar() {
		return progress;
	}
	
	public JMenuBar getmenuBar() {
		return menuBar;
	}
	
	public JPanel getControlPanel() {
		return controlPanel;
	}
	
	public JPanel getControlButtonPanel() {
		return controlButtonPanel;
	}
	
	public JButton getbPlay() {
		return bPlay;
	}
	
	public JButton getbStop() {
		return bStop;
	}
	
	public JSlider getVolumeSlider() {
		return volumeSlider;
	}
	//设置全屏参数
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public EmbeddedMediaPlayerComponent getPlayComponent() {
		return playerComponent;
	}
	
}
