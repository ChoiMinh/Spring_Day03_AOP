package com.example.myweb.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.example.myweb.board.BoardVO;
import com.example.myweb.common.JDBCUtil;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {
	@Resource(name="jdbcUtil")
	private JDBCUtil jdbcUtil;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	final String SQL_GET = "select * from board where seq=?";
	final String SQL_LIST = "select * from board order by seq desc";
	final String SQL_INSERT = "insert into board(seq, title, writer, content) " +
						"values((select nvl(max(seq),0)+1 from board),?,?,?)";
	final String SQL_UPDATE = "update board set title=?, content=? where seq=?";
	final String SQL_DELETE = "delete from board where seq=?";
	
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> insertBoard() 기능 처리");
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			int res = pstmt.executeUpdate();
			if(res>0) {
				conn.commit();
				System.out.println("입력 성공!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(null, pstmt, conn);
		}
	}
	
	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> updateBoard() 기능 처리");
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			int res = pstmt.executeUpdate();
			if(res>0) {
				conn.commit();
				System.out.println("수정 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(null, pstmt, conn);
		}
	}
	
	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> deleteBoard() 기능 처리");
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getSeq());
			int res = pstmt.executeUpdate();
			if(res>0) {
				conn.commit();
				System.out.println("데이터 삭제 성공!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(null, pstmt, conn);
		}
		
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> getBoard() 기능 처리");
		BoardVO board = null;
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegdate(rs.getString(5));
				board.setCnt(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs, pstmt, conn);
		}
		
		return board;
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegdate(rs.getString(5));
				board.setCnt(rs.getInt(6));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs, pstmt, conn);
		}
		
		return boardList;
	}
}