import supersymmetry.api.event.MobHordeEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import techguns.entities.npcs.Bandit;
import net.minecraft.entity.item.EntityFallingBlock;

new MobHordeEvent((player) -> {EntityZombie zombie = new EntityZombie(player.world);
			        zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 1));
				return zombie;}, 5, 10, "zombie_medium")
	.setAdvancementUnlock(new ResourceLocation("gregtech:steam/1_first_tools"))
	.setNightOnly(true)
	.setTimer(144000, 216000)		// 2 - 3 hours
	.setCanUsePods(false)

new MobHordeEvent((player) -> {EntityZombie zombie = new EntityZombie(player.world); 
			        zombie.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 999999, 1));
			        zombie.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 999999, 1));
			        zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 1));
				return zombie;}, 6, 12, "zombie_hard")
	.setAdvancementUnlock(new ResourceLocation("gregtech:steam/16_steel_boiler"))
	.setNightOnly(true)
	.setTimer(144000, 216000)		// 2 - 3 hours
	.setCanUsePods(false)

new MobHordeEvent((player) -> {Bandit bandit = new Bandit(player.world); bandit.addRandomArmor(0); return bandit;}, 2, 4, "bandit_medium")
	.setAdvancementUnlock(new ResourceLocation("gregtech:low_voltage/23_lv_assembler"))
	.setTimer(72000, 216000)	        // 1 - 3 hours


String ScriptNBT = "{Block:\"reccomplex:spawn_script\",Time:1,TileEntityData:{redstoneTriggerable:1b,spawnTriggerable:1b,script:{scripts:[{id:\"command\",script:{commands:[{command:\"kill @e[type=susy:drop_pod,c=1,r=2]\",weight:1.0d}]}},{id:\"command\",script:{commands:[{command:\"/setblock ~ ~1 ~ air\",weight:1.0d}]}},{id:\"strucGen\",script:{structureListID:\"Mortar_Cluster\",structureShift_y:0,structureShift_x:0,structures:[],simpleMode:0b,structureShift_z:0}}]}}}";

new MobHordeEvent((player) -> {}, 10, 10, "mortar_cluster")
    .beScriptBlock(ScriptNBT)
