package at.flori4n.bungeeparty;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PartyCommand extends Command {
    public PartyCommand() {
        super("party");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("party.start")){
            sender.sendMessage(new ComponentBuilder("you are not allowed to perform this action").create());
            return;
        }
        switch (args[0]){
            case "start":
                ProxiedPlayer proxiedPlayer = ProxyServer.getInstance().getPlayer(sender.getName());
                PartyData.getInstance().setPartyLeader(proxiedPlayer);
                ProxyServer.getInstance().getPlayers().forEach(p ->{p.connect(proxiedPlayer.getServer().getInfo());});
                sender.sendMessage(new ComponentBuilder("starting party").create());
                break;
            case "stop":
                PartyData.getInstance().setPartyLeader(null);
                sender.sendMessage(new ComponentBuilder("stopping party").create());
                break;
            default:
                sender.sendMessage(new ComponentBuilder("invalidCommand").create());
        }
    }
}
