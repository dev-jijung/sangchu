package xyz.itwill.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill.dto.Favorite;
import xyz.itwill.dto.ProductFavoriteJoin;

public interface FavoriteMapper {
	int insertFavorite(Favorite favorite);
	int deleteFavorite(Favorite favorite);
	Favorite selectFavorite(String memberId);
	List<ProductFavoriteJoin> selectFavoriteList(String memberId);
	List<ProductFavoriteJoin> selectFavoritePaging(Map<String, Object> map);
	int selectCountFavorite(String memberId);
	int selectCountProductFavorite(Map<String, Object> map);
}
