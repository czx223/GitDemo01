package com.hwua.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hwua.biz.ItemsBiz;
import com.hwua.entity.Items;
import com.hwua.entity.QueryVo;

@Controller
@RequestMapping("/items")
public class ItemController {
	// 调用业务逻辑层代码
	@Resource(name = "itemsBiz")
	private ItemsBiz ibiz;

	@RequestMapping("/{forName}")
	public String dynaicPage(@PathVariable String forName) {
		return forName;

	}

	@RequestMapping("/itemList")
	public ModelAndView getItemList() {
		List<Items> list = ibiz.getItemsList();
		ModelAndView mv = new ModelAndView("itemList");
		mv.addObject("itemList", list);
		// mv.setViewName("itemList");
		return mv;
	}

	@RequestMapping("/doedit")
	public ModelAndView doedit(HttpServletRequest request) {
		String strid = request.getParameter("id");
		Integer id = null;
		// 如果id有值则转换成int类型
		if (strid != null && !"".equals(strid)) {
			id = Integer.valueOf(strid);
		} else {
			// 出错
			return null;
		}
		Items item = ibiz.getItemById(id);
		ModelAndView mv = new ModelAndView("doedit");
		mv.addObject("item", item);
		return mv;
	}

	@RequestMapping("/doedit2")
	public String doedit2(Items items, MultipartFile pictureFile, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		// 非空判断 用户上传了图片才执行上传操作
		if (pictureFile != null && pictureFile.getOriginalFilename() != null
				&& pictureFile.getOriginalFilename().length() > 0) {
			// 图片上传成功后，将图片的地址写到数据库
			String filePath = "D:\\upload\\pic\\";
			// 上传文件原始名称
			String originalFilename = pictureFile.getOriginalFilename();
			// 给原始文件重新命名 +源文件的后缀
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 抽象文件
			File file = new File(filePath + newFileName);
			// 将内存中的文件写入磁盘
			pictureFile.transferTo(file);
			// 将新文件的路径 保存到items对象
			items.setPic(newFileName);
		}
		boolean flag = ibiz.updateItem(items);
		if (flag) {
			return "redirect:itemList.action";
		} else {
			pw.write("<script>alert('修改失败!');</script>");
			return null;
		}
	}

	@RequestMapping("/delone")
	public String delitem(Integer id, HttpServletResponse response) throws IOException {
		boolean flag = ibiz.delItem(id);
		if (flag) {
			return "redirect:itemList.action";
		} else {
			response.getWriter().println("<script>alert('删除失败!');</script>");
			return null;
		}

	}
	
	
	@RequestMapping("/delmore")
	public String delmore(QueryVo queryVo, String[] ids, HttpServletResponse response) throws IOException {
		System.out.println("-------------------");
		System.out.println(Arrays.toString(ids));
		boolean flag=ibiz.delItem(ids);
		if (flag) {
			return "redirect:itemList.action";
		} else {
			response.getWriter().println("<script>alert('删除失败!');</script>");
			return null;
		}
		
	}
	
	
	@RequestMapping(value = "/doadd2", method = RequestMethod.POST)
	public String additems(Items items, MultipartFile pictureFile, HttpServletResponse response)
			throws IllegalStateException, IOException {
		// 非空判断 用户上传了图片才执行上传操作
		if (pictureFile != null && pictureFile.getOriginalFilename() != null
				&& pictureFile.getOriginalFilename().length() > 0) {
			// 图片上传成功后，将图片的地址写到数据库
			String filePath = "D:\\upload\\pic\\";
			// 上传文件原始名称
			String originalFilename = pictureFile.getOriginalFilename();
			// 给原始文件重新命名 +源文件的后缀
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 抽象文件
			File file = new File(filePath + newFileName);
			// 将内存中的文件写入磁盘
			pictureFile.transferTo(file);
			// 将新文件的路径 保存到items对象
			items.setPic(newFileName);
		}
		// 执行添加功能
		boolean flag = ibiz.addItem(items);
		if (flag) {
			return "redirect:itemList.action";
		} else {
			response.getWriter().println("<script>alert('删除失败！');</script>");
			return null;
		}

	}

}
