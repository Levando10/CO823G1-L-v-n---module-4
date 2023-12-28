package com.example.data.controller;

import com.example.data.dto.SongDto;
import com.example.data.model.Song;
import com.example.data.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class SongController {
    @Autowired
    ISongService iSongService;

    @RequestMapping("")
    public ModelAndView findAll( @RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "4") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Song> list = iSongService.findAll(pageable);
        return new ModelAndView("/home","list",list);
    }

    @ModelAttribute("songDto")
    public SongDto songDto(){
       return new SongDto();
    }

    @GetMapping("/showForm")
    public ModelAndView showFormCreate(){
       return new ModelAndView("/formCreate");
    }
    @GetMapping("/createSong")
    public ModelAndView createSong(@Valid @ModelAttribute("songDto") SongDto songDto , BindingResult bindingResult){
if (bindingResult.hasErrors()){
    return new ModelAndView("/formCreate");
}
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/update/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("/formEdit");
        SongDto songDto = new SongDto();
        Song song = iSongService.findById(id);
        BeanUtils.copyProperties(song,songDto);
        modelAndView.addObject("songEdit",songDto);

        return modelAndView;
    }

    @GetMapping("/updateSong")
    public ModelAndView updateSong(@Valid SongDto songDto,BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new  ModelAndView("/formEdit");
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);

        }
        return new ModelAndView("/");
    }





}
