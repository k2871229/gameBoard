package com.hrpp;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.hrpp.domain.GameBoard;
import com.hrpp.persistence.GameBoardRepository;

@SpringBootTest
class GameBoardApplicationTests {

	@Autowired
	private GameBoardRepository repo;
	
	@Test
	void contextCreate() {
		System.out.println("테이블 생성 확인");
	}
	
	@Test
	public void testInsert200() {
		for (int i=0; i<200; i++) {
			GameBoard board = new GameBoard();
			board.setTitle("제목..."+i);
			board.setContent("내용..."+i+"채우기");
			board.setWriter("user0"+(i%10));
			repo.save(board);
		}
	}
	
	@Test
	public void testByWriter() {
		Collection<GameBoard> result = repo.findByWriter("user00");
		result.forEach(GameBoard -> System.out.println(GameBoard));
		
		repo.findByWriter("user00").forEach(GameBoard -> System.out.println(GameBoard));
	}
	
	@Test
	public void testByContent() {
		List<GameBoard> results = repo.findByContent("내용...0채우기");
		results.forEach(GameBoard -> System.out.println(GameBoard));
	}
	
	@Test
	public void testByWriterContaining() {
		List<GameBoard> results = repo.findByWriterContaining("05");
		results.forEach(GameBoard -> System.out.println(GameBoard));
	}

	@Test
	public void testByTitleContaining() {
		List<GameBoard> results = repo.findByTitleContaining("7");
		results.forEach(GameBoard -> System.out.println(GameBoard));
	}
	
	@Test
	public void testByContentEndingWith() {
		List<GameBoard> results = repo.findByContentEndingWith("9채우기");
		results.forEach(GameBoard -> System.out.println(GameBoard));
	}
	
	@Test
	public void testByTitleOrContent() {
		List<GameBoard> results = repo.findByTitleContainingOrContentContaining("77", "55");
		results.forEach(GameBoard -> System.out.println(GameBoard));
	}
	
	@Test
	public void testByTitleAndBno() {
		List<GameBoard> results  = 
				repo.findByTitleContainingAndBnoGreaterThan("5", 100L);
		results.forEach(GameBoard -> System.out.println(GameBoard));
	}
	
	@Test
	public void testByBnoOrderByBno() {
		List<GameBoard> results  = 
				repo.findByBnoGreaterThanOrderByBnoDesc(90L);
		results.forEach(GameBoard -> System.out.println(GameBoard));
	}
	
	@Test
	public void testBnoOrderByPaging() {
		Pageable paing = PageRequest.of(0, 10);
		List<GameBoard> results  = 
				repo.findByBnoGreaterThanOrderByBnoDesc(0L, paing);
		results.forEach(board -> System.out.println(board));
	}


}





