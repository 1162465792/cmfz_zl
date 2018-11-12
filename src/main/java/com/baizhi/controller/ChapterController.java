package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/insertChapter")
    public @ResponseBody Map<String,Object> insertChapter(Chapter chapter, MultipartFile ff, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try {
            String realPaths = request.getSession().getServletContext().getRealPath("back/banner");
            ff.transferTo(new File(realPaths,ff.getOriginalFilename()));
            chapter.setTitle(ff.getOriginalFilename());
            chapter.setSize(ff.getSize()/1024/1024+"");
            realPaths+="/"+ff.getOriginalFilename();
            chapter.setDuration("/back/banner/"+ff.getOriginalFilename());
            int audioLength = getAudioLength(realPaths);
            chapter.setDownPath(audioLength+"");
            chapterService.add(chapter);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/download")
    public @ResponseBody Map<String,Object> download(String fileName,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<>();
        ServletOutputStream os=null;
        FileInputStream is=null;
        try {
            String realPath = request.getSession().getServletContext().getRealPath("back/banner");
            is = new FileInputStream(new File(realPath,fileName));
            response.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(fileName,"UTF-8"));
            os = response.getOutputStream();
            IOUtils.copy(is,os);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }finally{
            is.close();
            os.close();
        }
        return map;
    }
    /*获取音频时长方法*/
    public static int getAudioLength(String audioPath) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        //读取要解析的问文件
        File file=new File(audioPath);
        int s=0;
        MP3File f = (MP3File)AudioFileIO.read(file);
        MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
        s =audioHeader.getTrackLength();
        return s;
    }
}
