package eu.mshade.axolotl.provider

import eu.mshade.enderframe.world.World

interface WorldProvider {

    fun getWorlds(): List<World>

    fun getWorld(name: String): World?

}