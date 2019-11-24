package com.comduck.webstudy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.comduck.webstudy.service.BoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.comduck.common.Common;
import com.comduck.webstudy.vo.BoardParam;
import com.comduck.webstudy.vo.BoardVO;

@Controller
public class BoardController {

	@Inject
	private BoardServiceImpl boardService;
	
	//임시파일 저장위치
	private final String PATH_temp = "C:/Users/JeongHeiHyun/Documents/spring/eGovFrameDev/workspace/WebStudy_191026/src/main/webapp/WEB-INF/temp_upload";
	//진짜 저장될 파일 위치
	private final String PATH_final = "C:/Users/JeongHeiHyun/Documents/spring/eGovFrameDev/workspace/WebStudy_191026/src/main/webapp/WEB-INF/upload";
	
	
	@RequestMapping(value="submit.do",method=RequestMethod.POST)
	public ModelAndView createPost(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) {
        System.out.println(" Board 를 create 합니다. 입니다. POSt방식");
        System.out.println(Common.nullCheck(boardVO.toString(), "")+"  ,boardVO 입니다");
        boardService.inputList(boardVO);
        return new ModelAndView("redirect:/");
	}  
	
	@RequestMapping(value="detailList.do")
	public String detailList(@ModelAttribute("boardVO") BoardVO boardVO, BoardParam boardParam, ModelMap model){
		System.out.println("write");
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		
		int paramNumPk = boardParam.getPkNumber();
		paramMap.put("pkNumber", boardParam.getPkNumber());
		BoardVO boardvo = boardService.showDetail(paramMap);
		System.out.println(paramNumPk + ", paramNumPk");
		
		int boardnoInt = boardVO.getViewCount();
		paramMap.put("viewCount", boardnoInt);
		boardService.updateViewCnt(paramMap);
		System.out.println(boardnoInt + ", boardnoInt");

		model.addAttribute("detail", boardvo);
		return "/detailList";
	}
	
	@RequestMapping(value="updateboard.do")
	public ModelAndView updateboard(@ModelAttribute("boardVO")BoardVO boardVO, BoardParam boardParam, ModelMap model){
		System.out.println("/updateboard");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pkNumber", boardVO.getBoardNum());
		paramMap.put("title", boardVO.getTitle());
		paramMap.put("text", boardVO.getText());
		try {
			boardService.updateBoard(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping(value="deleteBoard.do")
	public ModelAndView deleteBoard(@ModelAttribute("boardVO")BoardVO boardVO){
		System.out.println("deleteBoard.do");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pkNumber", boardVO.getBoardNum());
		boardService.deleteBoard(paramMap);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="fileUpload.do")
	public ModelAndView fileUpload(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/PopfileUpload"); // 뷰의 이름
		mv.addObject("data", "12341234");
		  return mv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/tryupload.do",method=RequestMethod.POST, produces="text/plain")
	public String tryupload(MultipartHttpServletRequest request, ModelMap model) throws IOException{
		System.out.println("tryupload");
		String originFileName = "";
		long fileSize = 0;
		// 응답용 객체를 생성하고, jsonView 를 사용하도록 합니다.
		
		List<MultipartFile> fileList = request.getFiles("file");
		System.out.println(fileList + " , tryupload 에서 넘어온 파일들 이거 누르는 순간 임시파일에 저장 되는 걸로 알고 있음");
		
		for(MultipartFile mf : fileList) {
			originFileName = mf.getOriginalFilename();  //원본 파일명
			fileSize = mf.getSize(); //파일 사이즈
			System.out.println(originFileName + ",원본 파일명");
			System.out.println(fileSize + " , 파일 사이즈");
			
			String safeFile = PATH_final + System.currentTimeMillis() + originFileName;
			
			try {
				mf.transferTo(new File(safeFile));
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("originFileName", originFileName);
		return "tryupload";
	}
	
	@RequestMapping(value="PopfileUpload")
	public void PopfileUpload(Model model) {
//		return "";
	}
	@RequestMapping(value="/write.do")
	public void write(Model model) {
//		return "";
	}
	
}
