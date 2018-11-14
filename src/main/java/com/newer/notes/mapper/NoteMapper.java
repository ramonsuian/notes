package com.newer.notes.mapper;

import com.newer.notes.domian.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteMapper {

    List<Note> findAll(@Param("title")String title);

    int delById(Integer id);

    int addNote(Note note);

    int updNote(Note note);

    Note findById(@Param("id") Integer id);
}
