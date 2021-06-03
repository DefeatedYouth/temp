package cn.exrick.xboot.modules.stm.service.impl;

import cn.exrick.xboot.modules.stm.service.FileService;
import cn.exrick.xboot.modules.stm.vo.FileUploadVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/9P
 * @desc
 */
@Service("FileService")
@Transactional
public class FileServiceImpl implements FileService {

    @Value("${applocal.uploadfilepath}")
    private String uploadFilePath;

    @Override
    public FileUploadVo upload(MultipartFile file, String prefix) throws IOException {
        String filePrefix = uploadFilePath + prefix;
        String filename = file.getOriginalFilename();
        // 生成新的文件名
        String realPath = filePrefix + "/" + UUID.randomUUID().toString().replace("-", "") + filename.substring(filename.lastIndexOf("."));
        File dest = new File(realPath);
        // 判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        // 保存文件
        file.transferTo(dest);
        String name = dest.getName();
        //需要配置 nginx 代理访问 TODO
        return FileUploadVo.builder()
                .httpPath(filePrefix+"/" + name)
                .path(prefix + "/" +name)
                .build();
    }
}
