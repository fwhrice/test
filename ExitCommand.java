package com.playerCommand;

import com.playerMain.*;

public class ExitCommand implements Command{
	Main pMain;
	public ExitCommand(Main pMain) {
		super();
		this.pMain =pMain;
	}
	
	public void execute(int x ) {}
	
	@Override
	public void execute() {
		pMain.exit();
	}
}
