package com.ssg.boardservice.service;


import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.domain.Criteria;
import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.dto.BoardRegisterDTO;
import com.ssg.boardservice.mapper.BoardMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

  private final BoardMapper boardMapper;
  private final ModelMapper modelMapper;
  private final FileService fileService;

  public List<BoardDTO> getList(Criteria criteria){
    return boardMapper.getPage(criteria).stream()
        .map(vo -> modelMapper.map(vo, BoardDTO.class)).collect(Collectors.toList());
  }

  public int getTotal(Criteria criteria){

    return boardMapper.getTotal(criteria);
  }

  // 게시글 등록
  public void create(BoardRegisterDTO dto) throws IOException {


    // 파일 처리
    String originalFileName = "";
    String savedFilePath = "";
    if (dto.getFile() != null && !dto.getFile().isEmpty()) {
      String[] fileInfo = fileService.saveFile(dto.getFile());
      savedFilePath = fileInfo[0];
      originalFileName = fileInfo[1];
    }

    // 3. 파일 정보 수동 생성 - 빌더패턴
    BoardVO vo = BoardVO.builder()
            .title(dto.getTitle())
            .content(dto.getContent())
            .writer(dto.getWriter())
            .password(dto.getPassword())
            .originalFileName(originalFileName)
            .filePath(savedFilePath)
            .build();

    boardMapper.insert(vo);
  }

  @Override
  @Transactional
  public BoardDTO getBoard(Long bno) {
    boardMapper.increaseHits(bno); // 조회수 증가
    return modelMapper.map(boardMapper.findById(bno), BoardDTO.class); // 게시글 조회
  }


  @Override
  public void remove(Long bno) {
    boardMapper.delete(bno);
  }

  @Override
  public void modify(BoardDTO boardDTO) {
    BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
    boardMapper.update(boardVO);
  }




}
