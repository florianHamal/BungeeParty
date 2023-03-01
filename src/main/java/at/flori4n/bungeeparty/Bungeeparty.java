package at.flori4n.bungeeparty;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;


public final class Bungeeparty extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ProxyServer.getInstance().getPluginManager().registerCommand(this,new PartyCommand());
        ProxyServer.getInstance().getPluginManager().registerListener(this,new Listeners());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
