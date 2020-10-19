package me.kingofmars4.hoc.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.configuration.InvalidConfigurationException;
import me.kingofmars4.hoc.Main;
import me.kingofmars4.hoc.countries.America;
import me.kingofmars4.hoc.countries.Germany;

public class gamedata {
	private Main plugin;
	private CommentedYamlConfiguration config;
	@SuppressWarnings("unused")
	private String newline = System.getProperty("line.separator");
	 
	public gamedata(Main plugin){
		this.plugin = plugin;
	}
	
	public void reload(){
		loadConfig();
	}
	
    private void loadConfig(){ 
        File f = new File(plugin.getDataFolder(), "database.yml"); 
         
        if(!f.exists()) { 
            try { 
                f.createNewFile(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
         
        config = new CommentedYamlConfiguration();        

        try { 
            config.load(f); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } catch (InvalidConfigurationException e) { 
            e.printStackTrace(); 
        } 
  	
    	addComment("GameData",
				"#################################################",
				"    # DO NOT TOUCH THIS UNLESS YOU KNOW WHAT YOU DOING #",
				"#################################################");
    	
    	//LOAD OWNED TERRITORIES
    		// USA
    			addDefault("Countries.USA.Territories", America.territories);
		    	
		    	
	    		// GERMANY
			    	addDefault("Countries.Germany.Territories",Germany.territories);
    	
    	
    	//LOAD WORLD TERRITORIES
		    	// USA
			    	addDefault("Territories.Alaska.Population", 731545);
			    	addDefault("Territories.Arizona.Population", 13564831);
			    	addDefault("Territories.California.Population", 51344853);
			    	addDefault("Territories.Carolina.Population", 15636798);
			    	addDefault("Territories.Colorado.Population", 13451880);
			    	addDefault("Territories.Dakota.Population", 1646721);
			    	addDefault("Territories.Florida.Population", 36998345);
			    	addDefault("Territories.Illinois.Population", 21964319);
			    	addDefault("Territories.Indiana.Population", 29718166);
			    	addDefault("Territories.Louisiana.Population", 10642747);
			    	addDefault("Territories.Michigan.Population", 21448923);
			    	addDefault("Territories.Montana.Population", 3434602);
			    	addDefault("Territories.NewYork.Population", 34298615);
			    	addDefault("Territories.PacificIslands.Population", 1870563);
			    	addDefault("Territories.Pennsylvania.Population", 28703623);
			    	addDefault("Territories.Texas.Population", 35049681);
			    	addDefault("Territories.Virginia.Population", 10327666);
			    	
			   // GERMANY
			    	addDefault("Territories.Baden.Population", 11100394);
			    	addDefault("Territories.Bavaria.Population", 13124737);
			    	addDefault("Territories.Berlin.Population", 3669491);
			    	addDefault("Territories.Brandenburg.Population", 2521893);
			    	addDefault("Territories.Bremen.Population", 681202);
			    	addDefault("Territories.Hamburg.Population", 1847253);
			    	addDefault("Territories.Hesse.Population", 6288080);
			    	addDefault("Territories.Holstein.Population", 2896712);
			    	addDefault("Territories.Mecklenburg.Population", 1609675);
			    	addDefault("Territories.Rhineland.Population", 4084844);
			    	addDefault("Territories.Saarland.Population", 990509);
			    	addDefault("Territories.Saxony.Population", 14279706);
			    	addDefault("Territories.Thuringia.Population", 2143145);
			    	addDefault("Territories.Westphalia.Population", 17932651);
    	
        // Write back config 
        try { 
            config.save(f); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
	
	public CommentedYamlConfiguration getConfig() {	
		return config;
	}
	
	private boolean hasPath(String path) {
		return config.isSet(path);
	}
	
	private void addComment(String path, String... comment) {
			config.addComment(path, comment);		
	}
	
	private void addDefault(String path, Object defaultValue) {
		if (path.equals("Version"))
			config.set(path, plugin.getDescription().getVersion());
		if (!hasPath(path))
			config.set(path, defaultValue);		
	}
}