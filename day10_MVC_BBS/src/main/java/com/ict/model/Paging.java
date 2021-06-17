package com.ict.model;

import org.springframework.stereotype.Service;

@Service
public class Paging {
	private int nowPage = 1; // 현재 페이지
	private int nowBlock = 1; // 현재 블록
	private int totalRecord = 0; // 전체 게시물의 수
	private int numPerPage = 3; // 현재 페이지에서 존재하는 게시물의 수
	private int pagePerBlock = 2; // 한 블록 안에 존재하는 페이지의 수
	private int totalBlock = 0; // 전체 블록의 수
	private int TotalPage = 0;
	
	// 실제 사용하는 것
	private int begin = 0; // 한 페이지의 게시물의 시작 번호
	private int end = 0; // 한 페이지의 게시물의 끝 번호
	private int beginBlock = 0; // 한 블록의 페이지 시작 번호
	private int endBlock = 0; // 한 블록의 페이지의 끝 번호
	
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNowBlock() {
		return nowBlock;
	}
	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getTotalPage() {
		return TotalPage;
	}
	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBeginBlock() {
		return beginBlock;
	}
	public void setBeginBlock(int beginBlock) {
		this.beginBlock = beginBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}
	
	
}
