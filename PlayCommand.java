package com.playerCommand;

import com.playerMain.*;

public class PlayCommand implements Command{
	Main pMain;
	public PlayCommand(Main pMain) {
		super();
		this.pMain =pMain;
	}

	public void execute(int x ) {}
	
	@Override
	public void execute() {
		pMain.play();
	}
}