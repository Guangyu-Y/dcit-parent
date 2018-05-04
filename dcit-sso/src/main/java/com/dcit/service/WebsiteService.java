package com.dcit.service;

import java.util.List;
 
import com.dcit.pojo.Website;

public interface WebsiteService {
	List<Website> findAll(Website website);

	void deleteWebsite(String[] websiteIds);

	void saveWebsite(Website website);

	Website findWebsiteById(String websiteId);

	void updateWebsite(Website website);
	
	Website findWebsiteByCode(String webCode);
}
