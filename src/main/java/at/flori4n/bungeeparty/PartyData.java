package at.flori4n.bungeeparty;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PartyData {
    private static PartyData instance;
    private ProxiedPlayer partyLeader;

    public static void setInstance(PartyData instance) {
        PartyData.instance = instance;
    }

    public ProxiedPlayer getPartyLeader() {
        return partyLeader;
    }

    public void setPartyLeader(ProxiedPlayer partyLeader) {
        this.partyLeader = partyLeader;
    }

    public static PartyData getInstance(){
        if (instance==null){
            instance=new PartyData();
        }
        return instance;
    }
}
