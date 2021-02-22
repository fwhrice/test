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
	JPanel contentPane;//����ҳ������
	JMenuBar menuBar;//�˵���
	JMenu mFile,mSetting,mHelp;//�˵�
	JMenuItem mOpenFile,mExit;//�˵�Ŀ¼
	JPanel controlPanel;//����ҳ������
	JPanel controlButtonPanel;//���ư�ť����
	JButton bPlay,bStop;//���ţ���ͣ��ť
	JButton bfullScreen;//ȫ����ť
	JSlider volumeSlider;//�������ڻ���
	JProgressBar progress;//��Ƶ������
	
	int flag =0;//�ж��Ƿ�ȫ��
	
	EmbeddedMediaPlayerComponent playerComponent;//ý�岥�������
	
	public static void mian(String args[]) {}
	//���췽����������������������
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
		
		//����������
		setTitle("MyPlayer");
		//ִ�йرղ���������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,80,900,600);
		contentPane =new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		//�����˵�
		menuBar =new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		//���ò˵�
		mFile =new JMenu("�ļ�");
		menuBar.add(mFile);
		mSetting =new JMenu("����");
		menuBar.add(mSetting);
		mHelp =new JMenu("����");
		menuBar.add(mHelp);
		//�����Ӳ˵�
		mOpenFile =new JMenuItem("���ļ�");
		mFile.add(mOpenFile);
		mExit =new JMenu("�˳�");
		mFile.add(mOpenFile);
		//Ϊ���ļ��������¼�
		mOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pMain.openFile();
			}
		});
		//����������
		JPanel pPanel =new JPanel();
		contentPane.add(pPanel,BorderLayout.CENTER);
		pPanel.setLayout(new BorderLayout(0,0));
		
		playerComponent =new EmbeddedMediaPlayerComponent();
		pPanel.add(playerComponent,BorderLayout.CENTER);
		//��ӿ�������
		controlPanel =new JPanel();
		pPanel.add(controlPanel);
		//controlPanel.setLayout(new BorderLayout(0,0));
		//��ӽ�����
		progress =new JProgressBar();
		pPanel.add(progress,BorderLayout.SOUTH);
		progress.setStringPainted(true);//��������ʾ�ַ���
		//��Ӳ��Ű�ť
		bPlay =new JButton(">");
		//���Ű�ť����ͣ��ť�л�
		//�������¼�
		/*bPlay.addMouseListener(new MouseAdapter() {
			public void clikMouse(MouseEvent e) {
				if(bPlay.getText()==">") {
					
				}
			}
		});*/
		controlPanel.add(bPlay);
		bStop =new JButton("��");
		controlPanel.add(bStop);
		//�����������
		volumeSlider =new JSlider();
		volumeSlider.setValue(60);
		volumeSlider.setMaximum(100);
		controlPanel.add(volumeSlider);
	}
	//��ȡ��Ƶʵ��
	public EmbeddedMediaPlayer getMediaPlayer() {
		return playerComponent.getMediaPlayer();
	}
	//��ȡ���ʵ��
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
	//����ȫ������
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
