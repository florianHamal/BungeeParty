package at.flori4n.bungeeparty;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Listeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PostLoginEvent event){
        ProxiedPlayer partyleader = PartyData.getInstance().getPartyLeader();
        if (partyleader==null) return;
        event.getPlayer().connect(partyleader.getServer().getInfo());
    }
    @EventHandler
    public void onPlayerDisconect(PlayerDisconnectEvent event){
        if (event.getPlayer()==PartyData.getInstance().getPartyLeader()){
            PartyData.getInstance().setPartyLeader(null);
        }
    }
}
