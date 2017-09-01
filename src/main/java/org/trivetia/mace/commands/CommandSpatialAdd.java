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

/**
 *
 * @author Dj
 */
public class CommandSpatialAdd extends CommandBase 
{
    
    private final String commandName = "maceSpatial";
    
    public CommandSpatialAdd()
    {
        aliases = Lists.newArrayList(commandName, "mS");
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
        return commandName;
    }    
    
    @Override
    public String getUsage(ICommandSender sender) 
    {
        return "/" + commandName + "< name>";
    }

    @Override
    public List<String> getAliases() 
    {
        return aliases;
    }

    @Override
    public void execute( MinecraftServer server, ICommandSender sender,  String[] args) throws CommandException
    {
        if (sender instanceof EntityPlayer)
        {
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
            suggestions.add("dunno");
        }

        return getListOfStringsMatchingLastWord(args, suggestions);
    }
    
}
