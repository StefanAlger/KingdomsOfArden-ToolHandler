package net.kingdomsofarden.andrew2060.toolhandler.cache.types;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.inventory.ItemStack;

public class CachedWeaponInfo {
    
    private double quality;
    private double bonusDamage;
    private double lifeSteal;
    private double critChance;
    private ItemStack item;
    private UUID[] mods;
    
    public CachedWeaponInfo(ItemStack item, double quality, double bonusDamage,double lifeSteal, double critChance) {
        this(item,quality,bonusDamage,lifeSteal,critChance,new UUID[] {});
    }
    public CachedWeaponInfo(ItemStack item, double quality, double bonusDamage,double lifeSteal, double critChance, UUID[] mods) {
        this.setQuality(quality);
        this.setBonusDamage(bonusDamage);
        this.setLifeSteal(lifeSteal);
        this.setCritChance(critChance);
        this.setItem(item);
        this.setMods(mods);
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getBonusDamage() {
        return bonusDamage;
    }

    private void setBonusDamage(double bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    public double getLifeSteal() {
        return lifeSteal;
    }

    private void setLifeSteal(double lifeSteal) {
        this.lifeSteal = lifeSteal;
    }

    public double getCritChance() {
        return critChance;
    }

    private void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public ItemStack getItem() {
        return item;
    }

    private void setItem(ItemStack item) {
        this.item = item;
    }

    public static CachedWeaponInfo fromString(ItemStack is, String parseable) {
        String[] parsed = parseable.split(":");
        double quality = Double.valueOf(parsed[0]);
        double bonusDamage = Double.valueOf(parsed[1]);
        double lifeSteal = Double.valueOf(parsed[2]);
        double critChance = Double.valueOf(parsed[3]);
        Set<UUID> coll = new HashSet<UUID>();
        for(int i = 4; i < parsed.length; i++) {
            coll.add(UUID.fromString(parsed[i]));
        }
        return new CachedWeaponInfo(is,quality,bonusDamage,lifeSteal,critChance,(UUID[]) coll.toArray());
    }

    public static CachedWeaponInfo getDefault(ItemStack is) {
        return new CachedWeaponInfo(is,0.00,0.00,0.00,0.00);
    }
    
    public UUID[] getMods() {
        return mods;
    }
    
    private void setMods(UUID[] mods) {
        this.mods = mods;
    }
    
    
    
}