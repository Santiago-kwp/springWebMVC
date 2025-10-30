package com.ssg.boardservice.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;


@Service
@Log4j2
public class FileService {

  @Value("${upload.path}") // application.properties 또는 application.yml에 upload.path 설정 필요
  private String uploadPath;

  // 파일 저장 및 저장된 파일 경로/이름 반환
  public String[] saveFile(MultipartFile file) throws IOException {
    if (file == null || file.isEmpty()) {
      return null;
    }

    String originalFileName = file.getOriginalFilename();
    String uuid = UUID.randomUUID().toString(); // 고유한 파일명 생성
    String savedFileName = uuid + "_" + originalFileName;

    Path targetPath = Paths.get(uploadPath, savedFileName);

    File uploadDir = new File(uploadPath);
    if (!uploadDir.exists()) {
      uploadDir.mkdirs(); // 디렉토리가 없으면 생성
    }

    file.transferTo(targetPath); // 파일 저장

    log.info("파일 저장 경로: " + targetPath.toString());
    return new String[]{targetPath.toString(), originalFileName}; // [저장된 전체 경로, 원본 파일명]
  }

  // 파일 삭제
  public boolean deleteFile(String filePath) {
    if (filePath == null || filePath.isEmpty()) {
      return false;
    }
    File file = new File(filePath);
    if (file.exists() && file.delete()) {
      log.info("파일 삭제 성공: " + filePath);
      return true;
    } else {
      log.warn("파일 삭제 실패 또는 파일 없음: " + filePath);
      return false;
    }
  }
}
