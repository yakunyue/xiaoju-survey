package com.xiaojusurvey.engine.extensions.filehandler;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class FileUtil {

    /**
     * @param originalFilename 原文件名
     * @return 文件唯一名
     */
    public static String generateUniqueFilename(String originalFilename) {
        String suffix = getFileExtension(originalFilename);
        String uniqueFilename = UUID.randomUUID().toString().replace("-", "");
        return StringUtils.isBlank(suffix) ? uniqueFilename : uniqueFilename + suffix;
    }

    /**
     * @param originalFilename 原文件名
     * @return 原文件拓展名
     */
    public static String getFileExtension(String originalFilename) {
        int dotIndex = originalFilename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == originalFilename.length() - 1) {
            return "";
        } else {
            return originalFilename.substring(dotIndex);
        }
    }
}
