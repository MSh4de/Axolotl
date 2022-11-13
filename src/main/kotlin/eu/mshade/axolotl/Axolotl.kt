package eu.mshade.axolotl

import eu.mshade.axolotl.event.AxolotlEvent
import eu.mshade.axolotl.protocol.AxolotlPacketIn
import eu.mshade.axolotl.protocol.AxolotlPacketRegistry
import eu.mshade.mwork.event.EventBus

object Axolotl {

    val eventBus = EventBus<AxolotlEvent>()

}