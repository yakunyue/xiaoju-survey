package com.xiaojusurvey.engine.extensions.filehandler;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.util.Date;

@Component
@ConditionalOnProperty(name = "survey.oss.active", havingValue = "aliyun")
public class AliOssFileHandler implements FileHandler {

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.basePath}")
    private String basePath;

    @Value("${aliyun.oss.defExpireTime}")
    private Long defExpireTime;

    private OSS ossClient;

    @PostConstruct
    public void init() {
        DefaultCredentialProvider credentialProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        ossClient = new OSSClientBuilder().build(endpoint, credentialProvider);
    }

    @Override
    public String upload(String filePath) {
        File file = new File(filePath);
        return upload(file);
    }

    @Override
    public String upload(File file) {

        return upload(file, null);

    }

    /**
     * @param file    要上传的文件
     * @param prePath 上传路径
     * @return key
     */
    public String upload(File file, @Nullable String prePath) {
        try {
            String uniqueFilename = FileUtil.generateUniqueFilename(file.getName());
            String key = (StringUtils.isBlank(prePath) ? basePath : prePath) + uniqueFilename;
            ossClient.putObject(bucketName, key, file);
            return key;
        } catch (Throwable e) {
            throw new RuntimeException("Upload to aliyun OSS failed!", e);
        }
    }

    @Override
    public String getDownloadUrl(String key) {
        Date expiration = new Date(System.currentTimeMillis() + defExpireTime * 1000);
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url.toString();
    }
}
