package me.kingofmars4.hoc.utils.registers.territories;

import me.kingofmars4.hoc.files.Gamedata;

public class NA_Territories {
	
	public static void loadDefaults() {
		Gamedata.get().set("Territories.Alaska.Owner", "USA"); Gamedata.get().set("Territories.Alaska.Population", 710231);
		Gamedata.get().set("Territories.Arizona.Owner", "USA"); Gamedata.get().set("Territories.Arizona.Population", 6392017+2763825); // ARIZONA + UTAH
		Gamedata.get().set("Territories.Carolina.Owner", "USA"); Gamedata.get().set("Territories.Carolina.Population", 9535483+4625364); // NORTH CAROLINA + SOUTH CAROLINA
		Gamedata.get().set("Territories.California.Owner", "USA"); Gamedata.get().set("Territories.California.Population", 37253956+2700551); // CALIFORNIA + NEVADA
		Gamedata.get().set("Territories.Colorado.Owner", "USA"); Gamedata.get().set("Territories.Colorado.Population", 5029196+1826341+2853118); // COLORADO + NEBRASKA + KANSAS
		Gamedata.get().set("Territories.Dakota.Owner", "USA"); Gamedata.get().set("Territories.Dakota.Population", 672591+814180); // NORTH DAKOTA + SOUTH DAKOTA
		Gamedata.get().set("Territories.Florida.Owner", "USA"); Gamedata.get().set("Territories.Florida.Population", 18801310+4779736+9687653); // FLORIDA + ALABAMA + GEORGIA
		Gamedata.get().set("Territories.Kentucky.Owner", "USA"); Gamedata.get().set("Territories.Kentucky.Population", 4339367+6346105); // KENTUCKY + TENNESSEE
		Gamedata.get().set("Territories.Hawai.Owner", "USA"); Gamedata.get().set("Territories.Hawai.Population", 1360301);
		Gamedata.get().set("Territories.Illinois.Owner", "USA"); Gamedata.get().set("Territories.Illinois.Population", 12830632+5988927); // ILLINOIS + MISSOURI
		Gamedata.get().set("Territories.Iowa.Owner", "USA"); Gamedata.get().set("Territories.Iowa.Population", 3046355+5686986+5303925); // IOWA + WINSCONSIN + MINNESOTA
		Gamedata.get().set("Territories.Louisiana.Owner", "USA"); Gamedata.get().set("Territories.Louisiana.Population", 4533372+2915918+2967297); // LOUISIANA + ARKANSAS + MISSISSIPPI
		Gamedata.get().set("Territories.Montana.Owner", "USA"); Gamedata.get().set("Territories.Montana.Population", 989415+1567582+563626); // MONTANA + IDAHO + WYOMING
		Gamedata.get().set("Territories.NewYork.Owner", "USA"); Gamedata.get().set("Territories.NewYork.Population", 19378102+12702379+1328361+6547629+625741+8791894);
		Gamedata.get().set("Territories.Ohio.Owner", "USA"); Gamedata.get().set("Territories.Ohio.Population", 11536504+9883640+6483802); // OHIO + MICHIGAN + INDIANA
		Gamedata.get().set("Territories.Oregon.Owner", "USA"); Gamedata.get().set("Territories.Oregon.Population", 38310074+6724540); // OREGON + WASHINGTON
		Gamedata.get().set("Territories.Texas.Owner", "USA"); Gamedata.get().set("Territories.Texas.Population", 25145561+3751351+2059179); // TEXAS + OKLAHOMA + NOVO MEXICO
		Gamedata.get().set("Territories.Washington.Owner", "USA"); Gamedata.get().set("Territories.Washington.Population", 8001024+1852994+5773552+897934+601723);
		
	}

}
