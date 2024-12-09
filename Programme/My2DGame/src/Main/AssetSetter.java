package Main;

import Objects.OBJ_Axe;
import Objects.OBJ_Boots;

import Objects.OBJ_Chest;
import Objects.OBJ_Door;
import Objects.OBJ_Key;
import Objects.OBJ_Potion_Red;
import Objects.OBJ_Shield_Blue;
import entity.NPC_OldMan;
import monster.MON_GreenSlime;

public class AssetSetter {
GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp=gp;
		
	}
	public void setObject() {
		int i =0;
		gp.obj[i]=new OBJ_Key(gp);
		gp.obj[i].worldX=gp.titleSize*25;
		gp.obj[i].worldY=gp.titleSize*19;
		i++;
		gp.obj[i]=new OBJ_Key(gp);
		gp.obj[i].worldX=gp.titleSize*21;
		gp.obj[i].worldY=gp.titleSize*19;
		i++;
		gp.obj[i]=new OBJ_Key(gp);
		gp.obj[i].worldX=gp.titleSize*26;
		gp.obj[i].worldY=gp.titleSize*21;
		i++;
		gp.obj[i]=new OBJ_Axe(gp);
		gp.obj[i].worldX=gp.titleSize*33;
		gp.obj[i].worldY=gp.titleSize*21;
		i++;
		gp.obj[i]=new OBJ_Shield_Blue(gp);
		gp.obj[i].worldX=gp.titleSize*35;
		gp.obj[i].worldY=gp.titleSize*21;
		i++;
		gp.obj[i]=new OBJ_Potion_Red(gp);
		gp.obj[i].worldX=gp.titleSize*22;
		gp.obj[i].worldY=gp.titleSize*27;
		i++;
		
	}
	public void setNPC(){
	gp.npc[0]=new NPC_OldMan(gp);	
	gp.npc[0].worldX=gp.titleSize*21;
	gp.npc[0].worldY=gp.titleSize*21;
	
	}
	public void setMonster() {
		int i=0;
		gp.monster[i]=new MON_GreenSlime(gp);
		gp.monster[i].worldX=gp.titleSize*21;
		gp.monster[i].worldY=gp.titleSize*38;
		i++;
		gp.monster[i]=new MON_GreenSlime(gp);
		gp.monster[i].worldX=gp.titleSize*23;
		gp.monster[i].worldY=gp.titleSize*42;
		i++;
		gp.monster[i]=new MON_GreenSlime(gp);
		gp.monster[i].worldX=gp.titleSize*24;
		gp.monster[i].worldY=gp.titleSize*37;
		i++;
		gp.monster[i]=new MON_GreenSlime(gp);
		gp.monster[i].worldX=gp.titleSize*34;
		gp.monster[i].worldY=gp.titleSize*42;
		i++;
		gp.monster[i]=new MON_GreenSlime(gp);
		gp.monster[i].worldX=gp.titleSize*38;
		gp.monster[i].worldY=gp.titleSize*42;
		i++;
		
	}
}
