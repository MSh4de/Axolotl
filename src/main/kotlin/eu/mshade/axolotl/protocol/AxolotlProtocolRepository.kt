package eu.mshade.axolotl.protocol

import org.slf4j.LoggerFactory

object AxolotlProtocolRepository {

    private val LOGGER = LoggerFactory.getLogger(AxolotlProtocolRepository::class.java)
    private val axolotlProtocolByAxolotlProtocolVersion = mutableMapOf<AxolotlProtocolVersion, AxolotlProtocol>()

    fun register(axolotlProtocol: AxolotlProtocol) {
        LOGGER.info("Register axolotl protocol {}", axolotlProtocol.getAxolotlProtocolVersion())
        axolotlProtocolByAxolotlProtocolVersion[axolotlProtocol.getAxolotlProtocolVersion()] = axolotlProtocol
    }

    fun getProtocol(version: AxolotlProtocolVersion?): AxolotlProtocol? {
        return axolotlProtocolByAxolotlProtocolVersion[version]
    }

    fun getProtocol(version: Int): AxolotlProtocol? {
        return getProtocol(AxolotlProtocolVersion.getProtocolVersion(version))
    }

    fun getProtocols(): MutableCollection<AxolotlProtocol> {
        return axolotlProtocolByAxolotlProtocolVersion.values
    }


}