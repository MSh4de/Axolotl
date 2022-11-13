package eu.mshade.axolotl.provider

import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.chunk.Chunk

interface ChunkProvider {

    fun provide(world: World, x: Int, z: Int): Chunk



}