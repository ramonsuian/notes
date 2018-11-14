package com.newer.notes;

import com.newer.notes.domian.Note;
import com.newer.notes.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private NoteService noteService;
    @Test
    public void contextLoads() {
    }
    @Test
    public  void con(){
       List<Note> notes = noteService.findAll("爱");
   for (Note note:notes){
       System.out.println(note.getContent());
   }
    }
    @Test
    public void  con1(){
        Note note = new Note();
        note.setTitle("e");
        note.setContent("2");
        String data1="1999-9-3";
        Date date =null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date=sf.parse(data1);
          note.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int a = noteService.addNote(note);
        System.out.println(a);

    }

}
