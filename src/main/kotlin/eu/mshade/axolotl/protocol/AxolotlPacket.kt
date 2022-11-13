package eu.mshade.axolotl.protocol

import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag

interface AxolotlPacketIn {

    fun read(axolotlSession: AxolotlSession, compoundBinaryTag: CompoundBinaryTag)

}

interface AxolotlPacketOut {

    fun write(compoundBinaryTag: CompoundBinaryTag)

}


