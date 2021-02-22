package com.playerCommand;

import com.playerMain.*;

public class VolumeCommand implements Command{
	Main pMain;
	public VolumeCommand(Main pMain) {
		super();
		this.pMain =pMain;
	}
	
	public void execute() {}
	
	@Override
	public void execute(int x) {
		pMain.setVolume(x);
	}
}
