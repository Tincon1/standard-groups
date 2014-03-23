package com.sbezboro.standardgroups.commands;

import org.bukkit.command.CommandSender;

import com.sbezboro.standardgroups.StandardGroups;
import com.sbezboro.standardgroups.managers.GroupManager;
import com.sbezboro.standardplugin.StandardPlugin;
import com.sbezboro.standardplugin.commands.BaseCommand;
import com.sbezboro.standardplugin.commands.SubCommand;
import com.sbezboro.standardplugin.model.StandardPlayer;

public class RenameCommand extends SubCommand {

	public RenameCommand(StandardPlugin plugin, BaseCommand command) {
		super(plugin, command, "rename");
	}

	@Override
	public boolean handle(CommandSender sender, String[] args) {
		if (args.length != 1) {
			sender.sendMessage("You must specify a name to rename your group to.");
			return false;
		}
		
		StandardPlayer player = plugin.getStandardPlayer(sender);
		
		GroupManager groupManager = StandardGroups.getPlugin().getGroupManager();
		groupManager.rename(player, args[0]);
		
		return true;
	}

	@Override
	public void showHelp(CommandSender sender) {
		sender.sendMessage("/g rename <name> - rename your group");
	}
	
}