package com.util.uni.producerService.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DbConnect {
	private Connection conn;
	private PreparedStatement stmt;
	
	@PostConstruct
	public void setupDbConnection() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		try {
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "SYSTEM", "MANAGER");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<BabyNames> getRecords() throws SQLException {
		List<BabyNames> dataRecordsList = new ArrayList<BabyNames>();
		stmt = conn.prepareStatement("select * from BABY_NAMES_DUMP where BABYNAME like 'v%'");
		ResultSet rs = stmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				BabyNames dataRec = new BabyNames();
				dataRec.setRecordid(rs.getString("RECORDID"));
				dataRec.setBabyname(rs.getString("BABYNAME"));
				dataRec.setMeaning(rs.getString("MEANING"));
				dataRec.setGender(rs.getString("GENDER"));
				dataRec.setReligion(rs.getString("RELIGION"));
				dataRec.setOrigin(rs.getString("ORIGIN"));
				dataRec.setNakshatra(rs.getString("NAKSHATRA"));
				dataRecordsList.add(dataRec);
			}
		}
		return dataRecordsList;
	}
}
