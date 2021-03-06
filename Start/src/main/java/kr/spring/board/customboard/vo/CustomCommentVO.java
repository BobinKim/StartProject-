package kr.spring.board.customboard.vo;

public class CustomCommentVO {

	private int comment_num;
	private int post_num;
	private int mem_num;
	private String content;
	private String reg_date;
	private int anonymous;
	
	private String photoname; //프로필 사진 - 댓글
	private int post_mem_num; //게시글 작성자 회원번호 - 댓글
	private String id; 
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(int anonymous) {
		this.anonymous = anonymous;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPost_mem_num() {
		return post_mem_num;
	}
	public void setPost_mem_num(int post_mem_num) {
		this.post_mem_num = post_mem_num;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	
}

