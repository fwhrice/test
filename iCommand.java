package com.playerCommand;

public class iCommand {
	Command playCommand;
	Command pauseCommand;
	Command stopCommand;
	Command exitCommand;
	Command volumeCommand;
	
	public void PlayCommand(Command playCommand) {
		this.playCommand =playCommand;
	}
	
	public void StopCommand(Command stopCommand) {
		this.stopCommand =stopCommand;
	}
	
	public void PauseCommand(Command pauseCommand) {
		this.pauseCommand =pauseCommand;
	}
	
	public void ExitCommand(Command exitCommand) {
		this.exitCommand =exitCommand;
	}
	
	public void VolumeCommand(Command volumeCommand) {
		this.volumeCommand =volumeCommand;
	}
	
	public void PlayCommand() {
		playCommand.execute();
	}
	
	public void StopCommand() {
		stopCommand.execute();
	}
	
	public void PauseCommand() {
		pauseCommand.execute();
	}
	
	public void ExitCommand() {
		exitCommand.execute();
	}
	
	public void VolumeCommand() {
		volumeCommand.execute();
	}

}
