package upload;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
 // 업로드폼 화면 리턴
	@GetMapping("/fileupload")
	public String  uploadform() {
		return "upload/uploadform";
	}
	
 // 업로드 처리 결과 화면 리턴
	@PostMapping("/fileupload")
	public ModelAndView uploadresulty(UploadDTO dto) throws IOException{
		String savePath = "c:/kdt/upload/";
		//프로젝트 외부 경로 - 기본적 브라우저 url 접근 공간 x
		//프로젝트 외부 경로 - http://localhost:8071/first/upload/xxx.파일들
		
		
		MultipartFile file1 =  dto.getFile1();
		String newFilename1 = null;
		if(!file1.isEmpty()) {
		String originalname1 = file1.getOriginalFilename();
		String beforeext1 = originalname1.substring(0, originalname1.indexOf("."));//pom
		String ext1 = originalname1.substring(originalname1.indexOf("."));//xml
		newFilename1 = beforeext1 + "(" + UUID.randomUUID().toString() +  ")" +  ext1;
		file1.transferTo(new java.io.File(savePath + newFilename1 ));
		}//if 
		
		MultipartFile file2 =  dto.getFile2();
		String newFilename2 = null;
		if(!file2.isEmpty()) {
		String originalname2 = file2.getOriginalFilename();
		String beforeext2 = originalname2.substring(0, originalname2.indexOf("."));//pom
		String ext2 = originalname2.substring(originalname2.indexOf("."));//xml
		newFilename2 = beforeext2 + "(" + UUID.randomUUID().toString() +  ")" +  ext2;
		file2.transferTo(new java.io.File(savePath + newFilename2 ));
		}//if 
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("uploadresult", savePath + newFilename1  + " 파일에 저장했습니다.");
		mv.addObject("uploadresult2", savePath + newFilename2  + " 파일에 저장했습니다.");
		mv.setViewName("upload/uploadresult");
		return mv;
	}
}




