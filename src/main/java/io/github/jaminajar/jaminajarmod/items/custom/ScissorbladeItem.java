package io.github.jaminajar.jaminajarmod.items.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;


public class ScissorbladeItem extends ToolItem implements Vanishable {
	static boolean ScissorMode = true;

	public ScissorbladeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, settings);
	}

	public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity player = context.getPlayer();
		if (player.isSneaking()){
			ModeChange();
		}
		return null;
	}
	static void ModeChange(){
		ScissorMode =!ScissorMode;
		int j;
		if(ScissorMode==true){
			j = 2;
		} else if(ScissorMode==false){
			j = 0;
		}
	}
}



