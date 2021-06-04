package com.hrpp.persistence;

import org.springframework.data.repository.CrudRepository;

import com.hrpp.domain.GameBoard;

public interface GameBoardRepository 
	extends CrudRepository<GameBoard, Long>{

}
