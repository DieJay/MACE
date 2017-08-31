/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivetia.mace.commands;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.trivetia.mace.Mace;

/**
 *
 * @author Dj
 */
public class CommandSpatialAdd extends CommandBase 
{
            
    public CommandSpatialAdd()
    {
        aliases = Lists.newArrayList("mace");
    }
    private final List<String> aliases;
    
    @Override
    public int getRequiredPermissionLevel()
    {
	return 2;
    }

    @Override
    public String getName() 
    {
        return "mace";
    }    
    
    @Override
    public String getUsage(ICommandSender sender) 
    {
        return "/mace < dunno1 | dunno2 >";
    }

    @Override
    public List<String> getAliases() 
    {
        return aliases;
    }

    @Override
    public void execute( MinecraftServer server, ICommandSender sender,  String[] args) throws CommandException
    {
        if (sender instanceof EntityPlayer) {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "Hey " + ((EntityPlayer) sender).getDisplayNameString()));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }
    
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos)
    {
        List<String> suggestions = new ArrayList<>();

        if (args.length == 1)
        {
            suggestions.add("dunno1");
            suggestions.add("dunno2");
        }

        return getListOfStringsMatchingLastWord(args, suggestions);
    }
    
}
