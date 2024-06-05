package com.example.myweb;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import com.example.myweb.board.BoardService;
import com.example.myweb.board.BoardVO;
import com.example.myweb.common.JDBCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	//@Autowired
	//private BasicDataSource ds;
	
	//@Autowired
	//private JDBCUtil jdbcUtil;
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Locale locale, Model model) throws SQLException {
		
		//System.out.println(ds.getConnection());
		//Connection conn = jdbcUtil.getConnection();
		//System.out.println(conn);
		
		List<BoardVO> boardList = boardService.getList(null);
		model.addAttribute("boardList", boardList);
		
		return "board_list";
	}
	
	@RequestMapping(value="/boardDetail", method=RequestMethod.GET)
	public String boardDetail(@RequestParam("seq") int seq, Model model) throws SQLException {
		//System.out.println("boardDetail >>>> seq : " + seq);
		
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardVO board = boardService.getOne(vo);
		model.addAttribute("board", board);
		
		return "board_detail";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.GET)
	public String boardUpdate(@RequestParam("seq") int seq, Model model) {
		
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardVO board = boardService.getOne(vo);
		model.addAttribute("board", board);
		
		return "board_update";
	}
	
	/*@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate2(@RequestParam Map<String, String> params, Model model) {
		
		Iterator it = params.entrySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		return "redirect:boardList";
	}*/
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate2(BoardVO vo, Model model) {
		
		//System.out.println(vo);
		boardService.update(vo);
		
		return "redirect:boardList";
	}
	
	// 설정페이지에서 view-controller 설정으로 대체
	/*@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public String boardWrite(BoardVO vo) {
		return "board_write";
	}*/
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWriteOk(BoardVO vo) {
		
		//System.out.println("vo ===> " + vo);
		
		boardService.insert(vo);
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.GET)
	public String boardDelete(BoardVO vo) {
		
		boardService.delete(vo);
		
		return "redirect:boardList";
	}
	
}