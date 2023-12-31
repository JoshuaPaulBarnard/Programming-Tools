package edu.srjc.Barnard.Joshua.Final.Idle_game.libclicker2.modifiers;

import edu.srjc.Barnard.Joshua.Final.Idle_game.libclicker2.World;

/**
 * Modifier for worlds
 */
public class WorldModifier extends Modifier
{
    double speedMultiplier;
    boolean disableActivators;

    public WorldModifier(World world) {
        super(world);
    }

    @Override
    protected void onEnable() {
        if (speedMultiplier != 1.0) {
            double speedMultiplierBefore = world.getSpeedMultiplier();
            double speedMultiplierAfter = speedMultiplier * speedMultiplierBefore;
            world.setSpeedMultiplier(speedMultiplierAfter);
        }

        if (disableActivators) {
            world.disableAutomators();
        }
    }

    @Override
    protected void onDisable() {
        if (speedMultiplier != 1.0) {
            double d = world.getSpeedMultiplier();
            d /= speedMultiplier;
            world.setSpeedMultiplier(d);
        }

        if (disableActivators) {
            world.enableAutomators();
        }
    }
}
