package com.newer.notes.controller;

import com.newer.notes.domian.CustomErrorType;
import com.newer.notes.domian.Note;
import com.newer.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;


    @RequestMapping(value = "find",method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@RequestParam(value = "title",required = false)String title){
        List<Note> notes=noteService.findAll(title);
        if (notes!=null){
            return new ResponseEntity<>(notes,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new CustomErrorType("can not find"+title+"notes"),HttpStatus.OK);

        }
    }

    @RequestMapping(value = "del",method = RequestMethod.DELETE)
    public ResponseEntity<?> delNote(@RequestParam(name = "id")Integer id){
        int fluRow=noteService.delById(id);
        if (fluRow!=0){
            return new ResponseEntity<>(fluRow,HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomErrorType("delete fail"),HttpStatus.OK);
    }


    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ResponseEntity<?> addNote(Note note){
        int fluRow=noteService.addNote(note);
        if ((fluRow!=0)){
            return new ResponseEntity<>(fluRow,HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomErrorType("insert fail"),HttpStatus.OK);
    }

    @RequestMapping(value = "edit" ,method = RequestMethod.PUT)
    public ResponseEntity<?> updNote(Note note){
        int i =noteService.updNote(note);
        if(i!=0){
            return new ResponseEntity<>(i,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new CustomErrorType("update fail"),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@RequestParam("id")Integer id){
      Note note = noteService.findById(id);
        if(note!=null){
            return new ResponseEntity<>(note,HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomErrorType("can no find"+id+"patient"),HttpStatus.OK);
    }








}
