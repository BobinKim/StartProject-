package kr.spring.timetable.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.vo.MemberVO;
import kr.spring.timetable.common.TimesMaker;
import kr.spring.timetable.service.TimetableService;
import kr.spring.timetable.vo.CustomSubjectVO;
import kr.spring.timetable.vo.SubjectVO;
import kr.spring.timetable.vo.TimesVO;
import kr.spring.timetable.vo.TimetableVO;

@Controller
public class TimetableController {
	//프로퍼티
	@Resource
	private TimetableService timetableService;
	@Resource
	private TimesMaker timesMaker;
	
	//로그 처리(로그 대상 지정)
	private Logger log = Logger.getLogger(this.getClass());
	
	//게시판 폼 호출
	@RequestMapping("/timetable/timetableView.do")
	public ModelAndView getList(@RequestParam(value="semester", defaultValue="2020-2", required=false) String semester,
								@RequestParam(value="t_num", defaultValue="", required=false) String t_num,
								HttpSession session) {

		TimetableVO vo = null;
		List<SubjectVO> subjectList = null;
		List<CustomSubjectVO> customSubjectList = null;
		
		int selectedT_num = 0;
		int tableCredit = 0;
		
		List<TimetableVO> timetableList = null; //해당 학기의 시간표 목록
		List<TimesVO> timesList = null;
		
		//세션에 저장된 회원 정보 반환
		MemberVO member = (MemberVO)session.getAttribute("user");
		
		TimetableVO timetable = new TimetableVO();
		timetable.setMem_num(member.getMem_num());
		timetable.setSemester(semester);
		
		//해당 학기의 시간표 개수
		int count = timetableService.selectTimetableCountOfUser(timetable);
		if(log.isDebugEnabled()) {
			log.debug("<<timetableCount>> : "+ count);	
		}

		//시간표가 존재하지 않는 경우 기본시간표 생성
		if(count <= 0) {	
			timetable.setIsPrimary(1);
			
			timetable.setT_name("시간표1");
			timetableService.insertTimetable(timetable);	//시간표 추가
			count++;
		}
		//시간표가 존재하는 경우
		if(count > 0) {
			timetableList = timetableService.selectList(timetable);
			
			if(log.isDebugEnabled()) {
				log.debug("<<timetableList>> : "+ timetableList);	
			}
			//t_num 정보가 넘어왔다면 시간표에 저장된 과목(+커스텀추가과목) 가져오기
			if(!t_num.equals("")) { //t_num정보가 넘어왔다면 해당 시간표의 정보, 해당 시간표의 과목
				vo = timetableService.selectTimetable(Integer.parseInt(t_num));

				subjectList = timetableService.selectSubjectOfTimetable(Integer.parseInt(t_num));
				customSubjectList = timetableService.selectCustomSubjectList(Integer.parseInt(t_num));
				
			}else {	// t_num 정보가 존재하지 않으면 기본시간표정보, 기본시간표의 과목 가져오기
				vo = timetableService.selectPrimaryTimetable(timetable);
				
				subjectList = timetableService.selectSubjectOfTimetable(vo.getT_num());
				customSubjectList = timetableService.selectCustomSubjectList(vo.getT_num());
			}
			timesList = timesMaker.makeTimesVO(subjectList, customSubjectList);
			selectedT_num = vo.getT_num();	
		}
		
		if(subjectList != null) {
			for(int i=0; i<subjectList.size(); i++) {
				tableCredit += subjectList.get(i).getSub_credit();			
			}
		}
		
		
		ModelAndView mav = new ModelAndView();
		//뷰이름설정
		mav.setViewName("timetableView");
		//데이터 저장
		mav.addObject("timetableCount", count);
		mav.addObject("timetableList", timetableList);
		mav.addObject("timetable", vo);
		mav.addObject("timetableCredit", tableCredit);
		mav.addObject("semester", semester);
		
		mav.addObject("timesList", timesList);	//시간표매핑
		mav.addObject("selectedT_num", selectedT_num);	//선택된 시간표번호
		
		return mav;
	}
	
}
