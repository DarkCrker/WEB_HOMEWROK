package net.yamang.dao;

import java.util.List;

import net.yamang.vo.CategoryVO;
import net.yamang.vo.JournalistVO;
import net.yamang.vo.NewsVO;

public interface NewsDao {
	
	public List<CategoryVO>getCategoriesOf(int parentCategoryId); //카테고리 기능가져오는것 하나가 만들어짐
	
	public boolean isCategoryLeafNode(int categoryId); //선택한 카테고리가 리프노드인지 확인 하기
	 
	public List<JournalistVO>getJournalists();  //모든 기자 가져오기
	
	public List<NewsVO>getNewsesOf(int categoryId);  //지정한 카테고리의 모든 기사 가져오기
	
	public boolean addNewNews(NewsVO newsVO);  // 새로운 기사를  등록 하기
	
	public NewsVO getNewsAt(int newsId);
	
	public void updateRecommendCount(int newsId);
	
	public void deleteNews(int newsId);
}
