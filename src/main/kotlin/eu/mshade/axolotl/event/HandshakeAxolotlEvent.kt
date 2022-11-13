package eu.mshade.axolotl.event

import eu.mshade.axolotl.protocol.AxolotlProtocolVersion
import eu.mshade.axolotl.protocol.AxolotlSession

class HandshakeAxolotlEvent(val axolotlSession: AxolotlSession, val axolotlProtocolVersion: AxolotlProtocolVersion): AxolotlEvent