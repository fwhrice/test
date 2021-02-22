package com.playerCommand;

import com.playerMain.*;

public class StopCommand implements Command{
	Main pMain;
	public StopCommand(Main pMain) {
		super();
		this.pMain =pMain;
	}

	public void execute(int x ) {}
	
	@Override
	public void execute() {
		pMain.stop();
	}
}
