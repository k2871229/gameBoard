package com.hrpp.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.hrpp.domain.GameBoard;

public interface GameBoardRepository 
	extends CrudRepository<GameBoard, Long>{

	//findBy~
	//title 조건으로 검색
	//where title = ?
	public List<GameBoard> findByTitle(String title);
	//writer 조건으로 검색
	//where writer=?
	public Collection<GameBoard> findByWriter(String writer);
	
	public List<GameBoard> findByContent(String content);
	
	//writer의 like 구문 처리
	public List<GameBoard> findByWriterContaining(String writer);
	
	//title에 '7'이 들어가 있는 레코드 검색
	public List<GameBoard> findByTitleContaining(String title);
	
	//content에 '9채우기'로 끝나는 레코드 검색
	public List<GameBoard> findByContentEndingWith(String content);
	
	// OR조건의 처리 ? title like '%title%' or content like '%content%'
	public List<GameBoard> findByTitleContainingOrContentContaining
	(String title, String content);
	
	//title like '%title%' and bno >
	// bno값이 100보다는 크고 title에는 5가 들어가게 검색
	public List<GameBoard> findByTitleContainingAndBnoGreaterThan
	(String title,Long bno);
	
	//bno > ? order by bno desc
	// bno값이 90보다 크게
	public List<GameBoard> findByBnoGreaterThanOrderByBnoDesc(Long bno);
	
	//bno > ? order by bno desc limit ? , ?
	//import org.springframework.data.domain.Pageable;
	//페이징 처리를 위해 10개씩 보이게 처리
	public List<GameBoard> findByBnoGreaterThanOrderByBnoDesc
	(Long bno, Pageable paging);
	
}
