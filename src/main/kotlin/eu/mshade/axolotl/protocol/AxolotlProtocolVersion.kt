package eu.mshade.axolotl.protocol

enum class AxolotlProtocolVersion(private val id: Int) {

    UNKNOWN(-1),
    STONE(0);

    companion object{
        private val protocolVersionById = mutableMapOf<Int, AxolotlProtocolVersion>()

        init {
            for (protocolVersion in values()) {
                protocolVersionById[protocolVersion.id] = protocolVersion
            }
        }

        fun getProtocolVersion(id: Int): AxolotlProtocolVersion {
            return protocolVersionById[id]?: UNKNOWN
        }
    }

    fun getVersion(): Int {
        return id
    }

}