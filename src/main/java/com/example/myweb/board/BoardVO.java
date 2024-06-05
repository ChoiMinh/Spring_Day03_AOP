package com.example.myweb.board;

public class BoardVO {
	private int seq;		//SEQ DECIMAL(5) NO PRI NULL 
	private String title;	//TITLE VARCHAR(200) YES  NULL 
	private String writer;	//WRITER VARCHAR(20) YES  NULL 
	private String content;	//CONTENT VARCHAR(2000) YES  NULL 
	private String regdate;	//REGDATE DATE(10) YES  CURRENT_TIMESTAMP 
	private int cnt;		//CNT DECIMAL(5) YES  0
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int seq, String title, String writer, String content, String regdate, int cnt) {
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}
	
}