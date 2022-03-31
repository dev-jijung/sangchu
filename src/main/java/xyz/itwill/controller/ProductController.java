package xyz.itwill.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill.dto.Comment;
import xyz.itwill.dto.Favorite;
import xyz.itwill.dto.Member;
import xyz.itwill.dto.Order;
import xyz.itwill.service.CommentService;
import xyz.itwill.service.FavoriteService;
import xyz.itwill.service.MemberService;
import xyz.itwill.service.OrderService;
import xyz.itwill.service.ProductService;
import xyz.itwill.util.Pager;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private FavoriteService favoriteService;
	
	@Autowired
	private MemberService memberSerivce;
	
	@RequestMapping(value = "/product_list" ,method = RequestMethod.GET)
	public String Product(@RequestParam(defaultValue = "1")int pageNum , @RequestParam(defaultValue = "") String category1,@RequestParam(defaultValue = "") String category2,@RequestParam(defaultValue = "") String searchKeyword ,Model model) {
		
		
		
		
			int pageSize = 6;
			int blockSize= 5;
			
			//Ű���尡 ������ : �˻��� ���
			if(!searchKeyword.equals("")) {
				
				int totalBoard = productService.getSearchCount(searchKeyword);
				
				
				Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
				Map<String, Object> mapPage = new HashMap<String, Object>();
				mapPage.put("startRow", pager.getStartRow());
				mapPage.put("endRow", pager.getEndRow());
				mapPage.put("searchKeyword",searchKeyword);
				
				model.addAttribute("productList",productService.getSearch(mapPage));
				model.addAttribute("searchKeyword",searchKeyword);
				model.addAttribute("pager", pager);
				model.addAttribute("total",totalBoard);
				
				return "product/product_list";
				
				
				
			}else {
				
				//ī�װ��� �Ѵ� ������ : ��ü�˻�  
				if(category1.equals("")&&category2.equals("")){
					int totalBoard =  productService.getAllCount();
					
					Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
					
				
					Map<String, Object> mapPage = new HashMap<String, Object>();
					mapPage.put("startRow", pager.getStartRow());
					mapPage.put("endRow", pager.getEndRow());
					mapPage.put("category1", null);
					mapPage.put("category2", null);
					
					model.addAttribute("productList",productService.getListProductTest(mapPage));
					model.addAttribute("pager",pager);
					model.addAttribute("total",totalBoard);
					
					
					//ī�װ��� �Ѵ� ������ : ū �׸� �˻�
				}else if (!category1.equals("")&&!category2.equals("")) {
					//pageCount ����
					Map<String, Object> pageCount = new HashMap<String, Object>();
					pageCount.put("category1", category1);
					pageCount.put("category2", category2);
					int totalBoard =  productService.getCountProductTest(pageCount);
					Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
					
					//map �� ����
					Map<String,Object> mapPage = new HashMap<String,Object>();
					mapPage.put("category1", category1);
					mapPage.put("category2", category2);
					mapPage.put("startRow", pager.getStartRow());
					mapPage.put("endRow", pager.getEndRow());
					
					model.addAttribute("productList",productService.getListProductTest(mapPage));
					model.addAttribute("pager",pager);
					model.addAttribute("total",totalBoard);
													
					//1�� ī�װ��� ���� �� : �����׸�1�˻�
					
				}else if(!category1.equals("")&&category2.equals("")) {
					Map<String, Object> pageCount = new HashMap<String, Object>();
					pageCount.put("category1", category1);
					pageCount.put("category2", null);
					
					
					int totalBoard = productService.getCountProductTest(pageCount);
					Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
					
					Map<String,Object> mapPage = new HashMap<String,Object>();
					mapPage.put("category1", category1);
					mapPage.put("category2",null);
					
					mapPage.put("startRow", pager.getStartRow());
					mapPage.put("endRow", pager.getEndRow());
					
					model.addAttribute("productList",productService.getListProductTest(mapPage));
					model.addAttribute("pager",pager);
					model.addAttribute("total",totalBoard);
					
					//2�� ī�װ��� ������ : �����׺� 2 �˻�
				}else if(category1.equals("")&&!category2.equals("")) {
					Map<String, Object> pageCount = new HashMap<String, Object>();
					pageCount.put("category1", null);
					pageCount.put("category2", category2);
					int totalBoard =  productService.getCountProductTest(pageCount);
					Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
					
					
					Map<String,Object> mapPage = new HashMap<String,Object>();
					mapPage.put("category2", category2);
					mapPage.put("category1", null);
					mapPage.put("startRow", pager.getStartRow());
					mapPage.put("endRow", pager.getEndRow());
					
					model.addAttribute("productList",productService.getListProductTest(mapPage));
					model.addAttribute("pager",pager);
					model.addAttribute("total",totalBoard);
				}
				
			model.addAttribute("category1",category1);
			return "product/product_list";
		
			}
			
			
						
			
		
	}
	@RequestMapping(value ="/product_list",method = RequestMethod.POST)
	public String Product(@RequestParam(defaultValue = "1")int pageNum ,@RequestParam String searchKeyword,Model model) {
		int totalBoard = productService.getSearchCount(searchKeyword);
		int pageSize = 6;
		int blockSize= 5;
		
		Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
		Map<String, Object> mapPage = new HashMap<String, Object>();
		mapPage.put("startRow", pager.getStartRow());
		mapPage.put("endRow", pager.getEndRow());
		mapPage.put("searchKeyword",searchKeyword);
		
		model.addAttribute("productList",productService.getSearch(mapPage));
		model.addAttribute("searchKeyword",searchKeyword);
		model.addAttribute("pager", pager);
		model.addAttribute("total",totalBoard);
		
		return "product/product_list";
		
	}
	
	
	@RequestMapping(value = "/product_detail", method = RequestMethod.GET)
	public String ProductDetail(Model model, @RequestParam int idx, HttpSession session) {
		Map<String, Object> fmap = new HashMap<String, Object>();
		Member member = (Member)session.getAttribute("loginMember");
		fmap.put("memberId", member.getId());
		fmap.put("productIdx", idx);
		model.addAttribute("productInfo", productService.getProduct(idx));
		model.addAttribute("commentList", commentService.getCommentProductIdx(idx));
		model.addAttribute("commentCount", commentService.getCommentCount(idx));
		model.addAttribute("favoriteTf", favoriteService.getCountProductFavorite(fmap));
		return "product/product_detail";
	}

	@RequestMapping(value = "/product_detail", method = RequestMethod.POST)
	public String ProductDetail(@ModelAttribute Favorite favorite ,@ModelAttribute Comment comment, Model model, @RequestParam int idx, @RequestParam(defaultValue = "0") int pStatus, HttpSession session) {
		if (comment.getStatus() == 1) {
			commentService.addComment(comment);
		} else if (comment.getStatus() == 2) {
			commentService.modifyComment(comment);
		} else if (comment.getStatus() == 9) {
			commentService.removeComment(comment);
		} else if (pStatus == 9) {
			productService.removeAdminProduct(idx);
			return "redirect:/product_list";
		} else if (pStatus == 8) {
			model.addAttribute("pStatus", pStatus);
			favoriteService.addFavorite(favorite);
		} else if (pStatus == 7) {
			model.addAttribute("pStatus", pStatus);
			favoriteService.removeFavorite(favorite);
		}
		Map<String, Object> fmap = new HashMap<String, Object>();
		Member member = (Member)session.getAttribute("loginMember");
		fmap.put("memberId", member.getId());
		fmap.put("productIdx", idx);
		model.addAttribute("productInfo", productService.getProduct(idx));
		model.addAttribute("commentList", commentService.getCommentProductIdx(idx));
		model.addAttribute("commentCount", commentService.getCommentCount(idx));
		model.addAttribute("favoriteTf", favoriteService.getCountProductFavorite(fmap));
		
//		favoriteService.addFavorite(favorite);
		
		return "product/product_detail";
		
	}
	
	
	
	@RequestMapping(value = "/order_detail", method = RequestMethod.GET)
	public String orderDetail(HttpSession session, Model model, @RequestParam int idx) {
		model.addAttribute("productInfo", productService.getProduct(idx));		
		return "product/order_detail";
	}
	
	@RequestMapping(value = "/order_detail", method = RequestMethod.POST)
	public String orderDetail(@ModelAttribute Order order, @RequestParam int idx, Model model, HttpSession session, @RequestParam int price) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		orderService.addOrder(order);
		
		
		//�����ϱ� ��ư�� ������ �ش� ��ǰ �÷��� ������ �̸� �߰�
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("buymember", loginMember.getId());
		map.put("idx", idx);
		
		productService.modifyJoinBuyBtn(map);
		
		Map<String, Object> coinMap = new HashMap<String, Object>();
		coinMap.put("id", loginMember.getId());
		coinMap.put("price", price);
		productService.coinMinus1(coinMap);
		
		session.setAttribute("loginMember", loginMember);
		
		return "redirect:/product_detail?idx="+idx;
	}
	
}
