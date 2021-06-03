package cn.exrick.xboot.modules.stm.service;

import cn.exrick.xboot.modules.stm.vo.FileUploadVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/9
 * @desc
 */
public interface FileService {
    FileUploadVo upload(MultipartFile file, String prefix) throws IOException;
}
