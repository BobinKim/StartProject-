package kr.spring.board.customboard.service;

import java.util.List;
import java.util.Map;

import kr.spring.board.customboard.vo.CustomPostVO;

public interface CustomPostService {
	
	//최근 게시글 top3 목록
	public List<CustomPostVO> selectTop3PostList();
	//추천 10개 이상인 게시글 top2 목록
	public List<CustomPostVO> custom_hotPostTop2();
	//게시글 목록
	public List<CustomPostVO> selectPostList(Map<String, Object> map); 
	//페이징처리를 위한 글 count
	public int selectRowCount(Integer board_num);
	//자바빈 얻기
	public CustomPostVO selectCustomPost(Integer post_num);
	//게시글 삭제
	public void deletePost(Integer post_num);
	//게시글 작성
	public void insertPost(CustomPostVO postVO);
	//게시글 수정
	public void customPostUpdate(CustomPostVO postVO);
	//게시판에 달린 게시글 번호
	public List<Integer> selectPostNum(int board_num);
}
