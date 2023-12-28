package com.example.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private Integer id;
    @NotBlank(message = "Khong duoc de trong!!")
    @Size(max = 800,message = "It hon 800 ki tu!")
    @Pattern(regexp = "^[\\w+\\s*]+$", message = "ban da su dung tu khong dung!!")

    private String name;
    @NotBlank(message = "Khong duoc de trong!!")
    @Size(max = 300,message = "It hon 800 ki tu!")
    @Pattern(regexp = "^[\\w+\\s*]+$", message = "ban da su dung tu khong dung!!")
    private String singer;
    @NotBlank(message = "Khong duoc de trong!!")
    @Size(max = 1000,message = "It hon 800 ki tu!")
    @Pattern(regexp = "^[\\w+[\\s\\,]*]+$", message = "khond duoc phep chua ki tu dac biet ngoai tru dau phay!!")
    private String type;

    public SongDto(Integer id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public SongDto() {
    }

    public SongDto(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
