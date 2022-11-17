package me.trqnquility.detective.compressor.implementation

import com.github.luben.zstd.Zstd
import me.trqnquility.detective.compressor.DetectiveCompressor


object ZstdCompressor: DetectiveCompressor {

    private const val ZSTD_COMPRESSION_LEVEL = 6
    private const val DECOMPRESSED_MAXIMUM_ARRAY_LENGTH = 100000000

    override fun compress(input: ByteArray): ByteArray {
        return Zstd.compress(input, ZSTD_COMPRESSION_LEVEL)
    }

    override fun decompress(input: ByteArray): ByteArray {
        val dst = ByteArray(DECOMPRESSED_MAXIMUM_ARRAY_LENGTH)
        Zstd.decompress(dst, input)
        return dst
    }
}