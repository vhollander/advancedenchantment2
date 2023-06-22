package me.pstockholm.aegis2;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.pstockholm.aegis2.enchants.*;
import me.pstockholm.aegis2.tools.Chinese;


public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("advancedenchantments-2");
	public static AEEnchantable Enchants[] = {new SpringsEnchantment(), new AntiGravity(), new Bleed(), new EnderWalker(), new Experience(), new Haste(),
	new AutoSmelt(), new Wither(), new Oxygenate(), new TakeOff(), new JellyLeg(), new Blind(), new Aquatic(), new Glowing(), new Etheral(), new Confusion(),
	new Insomnia(), new Obliterate(), new Clarity(), new Gears(), new RocketEscape(), new EnderShift(), new Reaper(), new SkillSwipe(), new Famine(),
	new Execute(), new Pummel(), new Poisoned(), new Berserk(), new Angelic(), new Demonic(), new Corrupt(), new Blessed(), new Implants(), new Obsidianshield(),
	new Valor(), new Stormcaller(), new Ravenous(), new Ward(), new Voodoo(), new Molten(), new Curse(), new LavaWalker(), new Insanity(), new Lifesteal(), new Abiding(),
	new Overload(), new Enlighted(), new Disappear(), new Unholy(), new Deathbringer(), new Stun(), new Poison(), new EnderSlayer(), new NetherSlayer(), new SmokeBomb(),
	new UndeadRuse(), new Frozen(), new Cactus(), new Metaphysical()};


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
			Chinese.register();
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "springs"), Enchants[0]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "antigravity"), Enchants[1]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "bleed"), Enchants[2]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "enderwalker"), Enchants[3]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "experience"), Enchants[4]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "haste"), Enchants[5]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "autosmelt"), Enchants[6]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "wither"), Enchants[7]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "oxygenate"), Enchants[8]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "takeoff"), Enchants[9]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "jellylegs"), Enchants[10]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "blind"), Enchants[11]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "aquatic"), Enchants[12]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "glowing"), Enchants[13]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "etheral"), Enchants[14]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "confusion"), Enchants[15]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "insomnia"), Enchants[16]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "obliterate"), Enchants[17]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "clarity"), Enchants[18]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "gears"), Enchants[19]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "rocketescape"), Enchants[20]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "endershift"), Enchants[21]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "reaper"), Enchants[22]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "skillswipe"), Enchants[23]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "famine"), Enchants[24]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "execute"), Enchants[25]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "pummel"), Enchants[26]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "poisoned"), Enchants[27]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "berserk"), Enchants[28]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "angelic"), Enchants[29]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "demonic"), Enchants[30]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "corrupt"), Enchants[31]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "blessed"), Enchants[32]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "implants"), Enchants[33]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "obsidianshield"), Enchants[34]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "valor"), Enchants[35]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "stormcaller"), Enchants[36]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "ravenous"), Enchants[37]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "ward"), Enchants[38]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "voodoo"), Enchants[39]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "molten"), Enchants[40]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "curse"), Enchants[41]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "lavawalker"), Enchants[42]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "insanity"), Enchants[43]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "lifesteal"), Enchants[44]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "abiding"), Enchants[45]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "overload"), Enchants[46]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "enlighted"), Enchants[47]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "disappear"), Enchants[48]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "unholy"), Enchants[49]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "deathbringer"), Enchants[50]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "stun"), Enchants[51]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "poison"), Enchants[52]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "enderslayer"), Enchants[53]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "netherslayer"), Enchants[54]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "smokebomb"), Enchants[55]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "undeadruse"), Enchants[56]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "frozen"), Enchants[57]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "cactus"), Enchants[58]);
			Registry.register(Registries.ENCHANTMENT, new Identifier("advancedenchants", "metaphysical"), Enchants[59]);

	}

}