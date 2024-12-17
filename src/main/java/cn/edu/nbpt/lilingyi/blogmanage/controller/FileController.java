package cn.edu.nbpt.lilingyi.blogmanage.controller;

import cn.edu.nbpt.lilingyi.blogmanage.Constants;
import cn.edu.nbpt.lilingyi.blogmanage.Result;
import cn.edu.nbpt.lilingyi.blogmanage.exception.BizException;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.enums.ErrorCode;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.enums.FileTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.storage.path}")
    private String fileStoragePath;
    @PostMapping
    public Result<List<String>> upload(@RequestParam MultipartFile [] multipartFiles){
        List<String> targetFileNames = new ArrayList<>();
        for(MultipartFile file:multipartFiles){
            File fileStoragePathFile = new File(fileStoragePath);
            if(!fileStoragePathFile.exists()){
                fileStoragePathFile.mkdirs();
            }
            String[] split = file.getOriginalFilename().split("\\.");
            String targetFileName = UUID.randomUUID()+"."+file.getOriginalFilename().split("\\.")[split.length-1];
            File targetFile = new File(fileStoragePath,targetFileName);
            try {
                file.transferTo(targetFile);
            } catch (IOException e) {
                throw new BizException(ErrorCode.FILE_STORAGE_ERROR);
            }
            targetFileNames.add(targetFileName);
        }
        return Result.success(targetFileNames);
    }

    @GetMapping
    public Result<Object> download(
            @RequestParam String fileName,
            @RequestParam(required = false) FileTypeEnum fileType,
            HttpServletRequest requst,
            HttpServletResponse response) throws IOException {
        File sourceFile = new File(fileStoragePath, fileName);
        if(!sourceFile.exists()){
            throw new BizException(ErrorCode.FILE_NOT_FOUND);
        }
        if (!FileTypeEnum.IMG.equals(fileType)) {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader(Constants.CONTENT_DISPOSITION,Constants.ATTACHMENT_FILENAME+fileName);
        }
        InputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
        ServletOutputStream outputStream = response.getOutputStream();

        byte[] bytes = new byte[1024];
        int i = 0;
        while((i=inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,i);
        }
        outputStream.flush();
        return null;
    }
}
