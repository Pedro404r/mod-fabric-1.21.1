package com.whoami.mods;

import com.whoami.mods.datagen.ModBlockTagProvider;
import com.whoami.mods.datagen.ModLootTableProvider; 
import com.whoami.mods.datagen.ModRecipeProvider;    
import com.whoami.mods.datagen.ModModelProvider;     
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
      FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

      pack.addProvider(ModBlockTagProvider::new);
      pack.addProvider(ModLootTableProvider::new);
      pack.addProvider(ModRecipeProvider::new);
      pack.addProvider(ModModelProvider::new); 

  }
}