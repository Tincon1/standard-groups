package com.sbezboro.standardgroups.commands;

import org.bukkit.command.CommandSender;

import com.sbezboro.standardgroups.StandardGroups;
import com.sbezboro.standardgroups.managers.GroupManager;
import com.sbezboro.standardplugin.StandardPlugin;
import com.sbezboro.standardplugin.commands.BaseCommand;
import com.sbezboro.standardplugin.commands.SubCommand;
import com.sbezboro.standardplugin.model.StandardPlayer;

public class JoinCommand extends SubCommand {

	public JoinCommand(StandardPlugin plugin, BaseCommand command) {
		super(plugin, command, "join");
	}

	@Override
	public boolean handle(CommandSender sender, String[] args) {
		if (args.length != 1) {
			sender.sendMessage("You must specify which group name you would like to join.");
			return false;
		}
		
		StandardPlayer player = plugin.getStandardPlayer(sender);
		
		GroupManager groupManager = StandardGroups.getPlugin().getGroupManager();
		groupManager.joinGroup(player, args[0]);
		
		return true;
	}

	@Override
	public void showHelp(CommandSender sender) {
		sender.sendMessage("/g join <name> - attemp to join a group");
	}
	
}