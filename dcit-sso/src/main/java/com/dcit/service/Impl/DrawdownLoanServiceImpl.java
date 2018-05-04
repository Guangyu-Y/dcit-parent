package com.dcit.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.service.BaseService;
import com.dcit.mapper.DrawdownLoanMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.DrawdownLoan;
import com.dcit.pojo.Website;
import com.dcit.service.DrawdownLoanService;
import com.dcit.service.WebsiteService;


@Service
public class DrawdownLoanServiceImpl  extends BaseService<DrawdownLoan> implements DrawdownLoanService{
	@Autowired
	private DrawdownLoanMapper drawdownLoanMapper;
	@Autowired
	private WebsiteService websiteService;

	@Override
	public List<DrawdownLoan> findAll() {
		List<DrawdownLoan> list=this.queryAll();
		if(list.isEmpty())
			return null;
		return list;
	}

	@Override
	public DrawdownLoan queryDrawdownLoanByPrimary(String loancode) {
		DrawdownLoan drawdownLoan= new DrawdownLoan();
		System.out.println("server"+loancode);
		drawdownLoan.setLoancode(loancode);
//		System.out.println(drawdownLoan.getLoancode()+"\n"+drawdownLoan.getWebsitecode()+"\n"+drawdownLoan.getBankcard()+"\n"+drawdownLoan.getDddate()+"\n"+drawdownLoan.getFfnumber());
		List<DrawdownLoan> list=drawdownLoanMapper.select(drawdownLoan);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteDrawdownLoan(String[] loancode) {
		if(loancode==null||loancode.length==0)
			return;
		drawdownLoanMapper.deleteByIDS(loancode);
		
	}

	@Override
	public void webCodeFindwebName(DrawdownLoan drawdownLoan) {
		if(drawdownLoan==null)
			return;
		String webCode=drawdownLoan.getWebsitecode();
		Website website=websiteService.findWebsiteByCode(webCode);
		if(website!=null){
			String webName=website.getName();
			drawdownLoan.setWebName(webName);
		}
	}

	@Override
	public void addDrawdownLoan(DrawdownLoan drawdownLoan) {
		
		drawdownLoanMapper.insert(drawdownLoan);
	}

	

	
}
