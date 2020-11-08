package me.kingofmars4.hoc.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import me.kingofmars4.hoc.files.FileLobbys;
import me.kingofmars4.hoc.files.Gamedata;
import me.kingofmars4.hoc.utils.U;

public class LobbyManager {
	
	private static LobbyManager lm;
	
	private final Map<UUID, Location> locs = new HashMap<UUID, Location>();
	private final Map<UUID, ItemStack[]> inv = new HashMap<UUID, ItemStack[]>();
    private final Map<UUID, ItemStack[]> armor = new HashMap<UUID, ItemStack[]>();
	
    private final List<Lobby> Lobbys = new ArrayList<Lobby>();
    private final List<String> countriesNames = new ArrayList<String>();
    
    public static int LobbySize = 0;
    
    private LobbyManager() {}
    
    public List<Lobby> getLobbys() {
		return Lobbys;
    }
    
    public static LobbyManager get() {
        if (lm == null)
            lm = new LobbyManager();
        return lm;
    }
    
    public Lobby getLobby(int i){
        for (Lobby a : this.Lobbys) {
            if (a.getId() == i) {
                return a;
            }
        }
        return null;
    }
    
    public Lobby createLobby(Location l,int lobby) {     
        
        Lobby a = new Lobby(l, lobby);
        this.Lobbys.add(a);

        return a;
    }
    
    public void loadLobbySize() {
    	int max = 0; int i;
    	if (FileLobbys.get().isConfigurationSection("Lobbys")) {
    		for (String key: FileLobbys.get().getConfigurationSection("Lobbys").getKeys(true)) {
    			i = Integer.parseInt(key);
    			if (i > max) { max = i; }
    		}
    		LobbySize = max;
    	}
    	
    	countriesNames.add("USA");
    	countriesNames.add("Germany");
    }
    
    public void loadLobbys () {
    	for (int i = 1; i<=LobbySize; i++) {
    		Lobby l = new Lobby(this.deserializeLoc(FileLobbys.get().getString("Lobbys."+i)), i);
            this.Lobbys.add(l);
    		Bukkit.broadcastMessage("CARREGOU O LOBBY: "+l.getId());
    		for (int o = 1; o<=countriesNames.size(); o++) {
    			l.getCountries().add(new Countrie(countriesNames.get(o-1), null, i));
    		}
    		
    		for (String key : Gamedata.get().getConfigurationSection("Territories").getKeys(true)) { if (!key.contains(".")) {
    			int population = Gamedata.get().getInt("Territories."+key+".Population");
    			Countrie owner = this.getCountrie(l, Gamedata.get().getString("Territories."+key+".Owner"));
    			l.getTerritories().add(new Territorie(key, owner, population));
    			}
    		}
    	}
    }
    
    public void sendMessages(Lobby l, String s) {
    	for (Player p : l.getPlayers()) {
    		p.sendMessage(U.color(s));
    	}
    }
    
    
    public Countrie getCountrie(Lobby l, String name) {
    	for (Countrie c : l.getCountries()) {
    		if (c.getName().equals(name)) {
    			return c;
    		}
    	}
    	return null;
    }
    
    public Territorie getTerritorie(Lobby l, String name) {
    	for (Territorie t : l.getTerritories()) {
    		if (t.getName().equals(name)) {
    			return t;
    		}
    	}
    	return null;
    }
    
    public Lobby getPlayerLobby(Player p) {
    	for (Lobby l: this.Lobbys) {
    		if (l.getPlayers().contains(p)) {
    			return l;
    		}
    	}
		return null;
    }
    
    
    public boolean isLobby(int i) {
    	if (i <= LobbySize) {
    		return true;
    	}
		return false;
    }
    
    
    public boolean isInLobby(Player p) {
        for (Lobby a : this.Lobbys) {
            if (a.getPlayers().contains(p))
                return true;
        }
        return false;
    }
    
    public Countrie getPlayerCountrie(Player p, Lobby l) {
    	for (Countrie c : l.getCountries()) {
    		if (c.getPlayer().contains(p.getUniqueId())) {
    			return c;
    		}
    	}
		return null;
    }
    
    public void addTerritorie(Territorie t, int i) {
    	Lobby a = this.getLobby(i);
    	a.getTerritories().add(t);
    }
    
    public void addPlayer(Player p, int i) {
    	ItemStack compass = U.createItemStack(Material.COMPASS, "&aOpen Menu");
    	ItemStack leaveGame = U.createItemStack(Material.REDSTONE_TORCH_ON, "&cLeave Lobby");
        Lobby a = this.getLobby(i);
        
        a.getPlayers().add(p);
        
        inv.put(p.getUniqueId(), p.getInventory().getContents());
        armor.put(p.getUniqueId(), p.getInventory().getArmorContents());
 
        p.getInventory().setArmorContents(null);
        p.getInventory().clear();
        
        locs.put(p.getUniqueId(), p.getLocation());
        p.teleport(a.getSpawn());
        p.getInventory().addItem(compass);
		p.getInventory().setItem(8, leaveGame);
    }
    
    public void removePlayer(Player p) {
        Lobby a = null;

        // Searches each arena for the player
        for (Lobby l : this.Lobbys) {
            if (l.getPlayers().contains(p))
                a = l;
        }

        if (a == null) {
            p.sendMessage("Invalid operation!");
            return;
        }

        a.getPlayers().remove(p);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        
        p.getInventory().setContents(inv.get(p.getUniqueId()));
        p.getInventory().setArmorContents(armor.get(p.getUniqueId()));
        
        inv.remove(p.getUniqueId());
        armor.remove(p.getUniqueId());

        p.teleport(locs.get(p.getUniqueId()));
        locs.remove(p.getUniqueId());
        p.setFireTicks(0);
        p.updateInventory();
    }
    
    public boolean hasCountrie(Lobby l, Player p) {
    	for (Countrie c : l.getCountries()) {
    		if (c.getPlayer().contains(p.getUniqueId())) {
    			return true;
    		}
    	}
    	return false;
    }
    
    // UTILS
    public String serializeLoc(Location l){
        return l.getWorld().getName() + "," + l.getBlockX() + "," + l.getBlockY() + "," + l.getBlockZ();
    }

    public Location deserializeLoc(String s){
    	String[] st = s.split(",");
        return new Location(Bukkit.getWorld(st[0]), Integer.parseInt(st[1]), Integer.parseInt(st[2]), Integer.parseInt(st[3]));
    }
}
