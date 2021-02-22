package com.playerCommand;

public interface Command {
	//执行播放暂停线程
	public void execute();
	//执行调节音量的线程
	public void execute(int x);
}
