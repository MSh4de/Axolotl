package eu.mshade.axolotl.provider

import eu.mshade.enderframe.UniqueId
import eu.mshade.enderframe.world.chunk.Chunk
import eu.mshade.enderframe.world.chunk.NibbleArray
import eu.mshade.enderframe.world.chunk.Palette
import eu.mshade.enderframe.world.chunk.Section

interface SectionProvider {

    fun provide(chunk: Chunk, y: Int, palette: Palette, blocks: IntArray, uniqueId: UniqueId, blockLight: NibbleArray, skyLight: NibbleArray): Section

}