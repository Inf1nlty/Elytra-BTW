package btw.community.elytra;

import api.BTWAddon;

import com.inf1nlty.elytra.ElytraItems;
import com.inf1nlty.elytra.ElytraRecipes;
import com.inf1nlty.elytra.ElytraNetwork;

public class ElytraAddon extends BTWAddon {
    @Override
    public void initialize() {

        ElytraItems.registerItems();
        ElytraRecipes.registerRecipes();
        ElytraNetwork.register(this);
    }
}