package com.github.cao.awa.trtr.information.compressor;

public interface InformationCompressor {
    byte[] EMPTY_BYTES = new byte[0];

    /**
     * Compress for a data
     *
     * @param bytes Data source
     * @return Compress result
     */
    byte[] compress(byte[] bytes);

    /**
     * Decompress for a data
     *
     * @param bytes Data source
     * @return Decompress result
     */
    byte[] decompress(byte[] bytes);
}
