package com.hpe.action;




import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;




import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.hpe.dao.TendencyDao;
import com.opensymphony.xwork2.ActionSupport;

public class TendencyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 294893882981813659L;
	private String myData;	
	TendencyDao tendencyDao = new TendencyDao();
	public String execute(){
		myData = tendencyDao.mkData();
		System.out.println(myData);
		return SUCCESS;
	}
	public String getMyData() {
		return myData;
	}
	public void setMyData(String myData) {
		this.myData = myData;
	}
	
public String jsonString() throws Exception {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw  = response.getWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "zhang");
		map.put("sex", "ÄÐ");
		map.put("age", "22");
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "zhang1");
		map1.put("sex", "ÄÐ1");
		map1.put("age", "221");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "zhang111");
		map2.put("sex", "ÄÐ111");
		map2.put("age", "22111");
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(map);
		list.add(map1);
		list.add(map2);
		myData = JSONArray.fromObject(list).toString();
		System.out.println(myData);

		pw.write(myData);
		pw.flush();
		
		return null; 
	}
	/*public static void main(String[] args) {
		TendencyDao tendencyDao = new TendencyDao();
		String myData;
		myData = tendencyDao.mkData();
		System.out.println(myData);
	}*/

}
