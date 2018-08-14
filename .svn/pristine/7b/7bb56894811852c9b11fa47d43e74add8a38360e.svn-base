package com.eshore.wbtimer.core.utils;

import java.io.File;

/**
 * 描述: 文件工具类
 *
 * @author Yangjinming
 * @create 2018-01-10 18:49
 */
public class FileUtil {
    public static boolean deleteRecursively(File root) {
        if (root != null && root.exists()) {
            if (root.isDirectory()) {
                File[] children = root.listFiles();
                if (children != null) {
                    for (File child : children) {
                        deleteRecursively(child);
                    }
                }
            }
            return root.delete();
        }
        return false;
    }
}
