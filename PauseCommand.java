package com.playerCommand;

import com.playerMain.*;

public class PauseCommand implements Command{
	Main pMain;
	public PauseCommand(Main pMain) {
		super();
		this.pMain =pMain;
	}
	
	public void execute(int x ) {}
	
	@Override
	public void execute() {
		pMain.pause();
	}
}
