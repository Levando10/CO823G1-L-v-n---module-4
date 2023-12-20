package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
@Controller
public class DictionaryHandle {
    private static HashMap<String,String> map = new HashMap<>();

    static {
        map.put("hello","Xin chào");
        map.put("banana","Trái chuối");
        map.put("blue","Màu xanh");
        map.put("red","Màu Đỏ");
        map.put("apple","Trái Táo");
    }
    @GetMapping
public ModelAndView showDictionary(){
        return new ModelAndView("/index");
    }
    @GetMapping("/dictionary")
    public ModelAndView changeDictionary(@RequestParam String eng){
        String result = map.get(eng.toLowerCase());

        if (result == null){
            result = "Không tìm thấy!!!";
        }
        return new ModelAndView("/index","result", result);
    }

}
