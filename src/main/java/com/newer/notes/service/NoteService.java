package com.newer.notes.service;

import com.newer.notes.domian.Note;
import com.newer.notes.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteMapper noteMapper;

    /**
     * 模糊查询
     * @param title
     * @return
     */
    public List<Note> findAll(String title){
        return noteMapper.findAll(title);
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int delById(Integer id){
        return  noteMapper.delById(id);
    }

    /**
     * 添加
     * @param note
     * @return
     */
    public int addNote(Note note){
        return  noteMapper.addNote(note);
    }

    /**
     * 修改
     * @param note
     * @return
     */
    public int updNote(Note note){
        return noteMapper.updNote(note);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Note findById(Integer id){
        return  noteMapper.findById(id);
    }

}
