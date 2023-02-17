package at.flori4n.bungeeparty;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PartyCommand extends Command {
    public PartyCommand() {
        super("party");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer proxiedPlayer = ProxyServer.getInstance().getPlayer(sender.getName());
        PartyData.getInstance().setPartyLeader(proxiedPlayer);
        ProxyServer.getInstance().getPlayers().forEach(p ->{p.connect(proxiedPlayer.getReconnectServer());});
    }
}
