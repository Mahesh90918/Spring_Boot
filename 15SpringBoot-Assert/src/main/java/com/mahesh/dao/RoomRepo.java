package com.mahesh.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.model.Room;

public interface RoomRepo extends JpaRepository<Room, Integer>{

}
