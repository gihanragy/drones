package com.musula.backend.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemoryUtils {
    public static void printMemoryInfo(String desc) {
        Runtime rt = Runtime.getRuntime();
        long maxHeap = rt.maxMemory() / (1024 * 1024);
        long total = rt.totalMemory() / (1024 * 1024);
        long free = rt.freeMemory() / (1024 * 1024);
        log.info("{} Max heap {} Total mem {} mb Available {} mb used mem {} mb ", desc, maxHeap, total, free, (total - free));

    }
}
