package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
@RequestMapping("/filedownloadlist")
public ModelAndView downloadlist() {
	//파일시스템정보=폴더와파일
	File f = new File("c:/kdt/upload/");
	String [] filearray = f.list();
	
	ModelAndView mv = new ModelAndView();
	mv.addObject("filearray", filearray);
	mv.setViewName("upload/downloadlist");
	return mv;
}

@RequestMapping("/filedownloadresult")
public void downloadresult(String filename, HttpServletResponse response) throws IOException {
	response.setContentType("application/download");
	response.setContentLength( (int)(new File("c:/kdt/upload/" + filename).length()  ))  ;
	response.setHeader("Content-Disposition", "attachment;filename=\"" +filename + "\"");
	
	OutputStream out = response.getOutputStream();
	FileInputStream fin = new FileInputStream(new File("c:/kdt/upload/" + filename));
	FileCopyUtils.copy(fin, out);
	fin.close();
	out.close();
}

}





