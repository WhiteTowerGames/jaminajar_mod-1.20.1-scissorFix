package io.github.jaminajar.jaminajarmod.items.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;


public class ScissorbladeItem extends ToolItem implements Vanishable {
	static boolean ScissorMode = true;
	/// I added a couple of fields mirroring the behavior of {@link SwordItem}.
	private final float attackDamage;
	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

	/// The constructor now also mirrors what {@link SwordItem#SwordItem(ToolMaterial, int, float, Settings)  SwordItem} does.
	/// You should ***definitely*** do this for your other custom weapons and tools as well.
	public ScissorbladeItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
		super(material, settings);
		this.attackDamage = (float)attackDamage + material.getAttackDamage();
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(
				EntityAttributes.GENERIC_ATTACK_DAMAGE,
				new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION)
		);
		builder.put(
				EntityAttributes.GENERIC_ATTACK_SPEED,
				new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION)
		);
		this.attributeModifiers = builder.build();

	}

	/// Added a couple of assertions and simplified the conditions here because they looked at me funny.
	public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity player = context.getPlayer();
		assert player != null;
		if (player.isSneaking()){
			ModeChange();
		}
		return null;
	}
	static void ModeChange(){
		ScissorMode =!ScissorMode;
		int j;
		if(ScissorMode){
			j = 2;
		} else if(!ScissorMode){
			j = 0;
		}
	}

	/// I added this method because SwordItem seems to call it in order to actually apply the attributes
	/// during runtime.
	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}
}



