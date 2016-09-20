package net.yamangs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.yamangs.vo.ArtclVO;

public class ArtclDaoImpl implements ArtclDao{

	@Override
	public List<ArtclVO> getArtclOf() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ARTCL","ARTCL");
			
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT	ARTCL_ID ");
			query.append("			, SBJ ");
			query.append(" 			, CONT ");
			query.append(" 			, CRT_DT ");
			query.append(" FROM		ARTCL ");
			query.append(" ORDER BY ARTCL_ID ");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			List<ArtclVO> artcls = new ArrayList<ArtclVO>();
			ArtclVO artclVO = null;
			
			while(rs.next()){
				artclVO = new ArtclVO();
				
				artclVO.setArtcl_Id(rs.getInt("ARTCL_ID"));
				artclVO.setSubject(rs.getString("SBJ"));
				artclVO.setContent(rs.getString("CONT"));
				artclVO.setCreatedDate(rs.getString("CRT_DT"));
				
				artcls.add(artclVO);
			}
			
			return artcls;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
