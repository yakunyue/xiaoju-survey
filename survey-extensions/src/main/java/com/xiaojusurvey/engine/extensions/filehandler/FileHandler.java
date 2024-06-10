package com.xiaojusurvey.engine.extensions.filehandler;

import java.io.File;

public interface FileHandler {
    String upload(String filePath);
    String upload(File file);
    String getDownloadUrl(String key);
}
