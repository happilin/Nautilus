package com.nautilus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nautilus.mapper.BoardMapper;
import com.nautilus.vo.Board;

//220825 오후 10:32 
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardMapper dao;
	
	//Read
	@GetMapping("")
	public String getList(Model model)
	{
		List<Board> list = dao.getList();
		model.addAttribute("list", list);
		return "board/boardList";
	}
	
	//제목클릭->글 내용 보기 a
	@GetMapping("/detail/{num}")
	public String getBoard(@PathVariable("num")int num, Model model) {
		Board board = dao.getInfoByDeptno(num);
		model.addAttribute("board", board);
		return"/board/detail";
	}
	
	//Create
	@GetMapping("/create")
	public String create() {
		return "board/boardInputForm";
	}
	//글쓴거 db에 추가
	@PostMapping("/add")
	@ResponseBody
	public Map<String, Object> add(
			Board board) 
	{
		/*System.out.println("add()");
		Board board = new Board();
		board.setNum(num);
		board.setTitle(title);
		board.setContents(contents);
		board.setAuthor(author);
		board.setPcode(pcode);
		System.out.println("title="+title);
		System.out.println("contetns="+contents);
		System.out.println("author="+author);
		System.out.println("pcode="+pcode);*/
		
		dao.add(board);
		
		Map<String,Object> map = new HashMap<>();
		map.put("added", board.getNum());
		return map;
	}
	
	//Update
	@GetMapping("/edit/{num}")
	public String edit(@PathVariable("num")int num,Model model)
	{
		Board board = dao.getInfoByDeptno(num);
		model.addAttribute("board",board);
		System.out.println("board:"+board);
		
		return "/board/boardEdit";
	}
	//편집창->수정하기
		@PostMapping("/update")
		@ResponseBody
		public Map<String,Boolean> update(Board board )
		{
			
			boolean updated = dao.update(board);
			
			Map<String,Boolean> map = new HashMap<>();
			map.put("updated", updated);
			System.out.println("updated:"+updated);
			return map;
		}
		
	//Delete
	@GetMapping("/delete/{num}")
	@ResponseBody
	public Map<String,Boolean> delete(@PathVariable("num")int num) {
		System.out.println("num="+num);
		//int board = new Board();
		Boolean deleted = dao.delete(num);
		System.out.println("deleted="+deleted);
		
		Map<String,Boolean> map = new HashMap<>();
		map.put("deleted", deleted);
		return map;
	}
	
	//Search
	@PostMapping("/search")
	public String search(@RequestParam("key")String keyword,
						@RequestParam("category")String category,
						@RequestParam(name="psize", defaultValue="5")int pageSize,
						@RequestParam(name="page", defaultValue="1")int page
									  ,Model model)
	{
		Map<String,String> map = new HashMap<>();
		map.put("category", category);
		map.put("key",keyword);
		
		PageHelper.startPage(page, pageSize);	//페이지 정보초기화, 
		//시작 페이지를 page,에 가져와서 한 
		//page : 가져올 페이지, 
		//pageSize:가져올 페이지 수
		
		PageInfo<Board> pageInfo = new PageInfo<>(dao.search(map));	//검색한 목록 가져와서 페이지정보에 넣음
		model.addAttribute("category",category);
		model.addAttribute("key",keyword);// 폼에서 넘어온 키와 카테고리를 다시 jsp에 넘어감. 페이지를 넘기면 값이 사라지니까(page가 리프레쉬 되고, 검색 창이 사라짐) 안사라지게끔 하는 것.
		model.addAttribute("pageInfo",pageInfo);
		
		//List<Board> list = dao.search(key,category);
		//model.addAttribute("list", list);
		return "board/search";
	}
	
	 /*@GetMapping("/page")
	 public String page(Model model) {
		 
	     PageHelper.startPage(1, 3);
	     PageInfo<Board> pageInfo = new PageInfo<>(dao.getList());
	     List<Board> list= pageInfo.getList();
	     System.out.println(list);
	     model.addAttribute("pageInfo", pageInfo);
	      
	      return "board/list_page";
	   }*/
	
}
