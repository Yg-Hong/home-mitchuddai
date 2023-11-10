package com.whereismyhome.house.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.whereismyhome.house.member.dto.MemberDto;
import com.whereismyhome.house.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

    DBUtil dbUtil = DBUtil.getInstance();
    private static MemberDao instance = new MemberDaoImpl();

    private MemberDaoImpl() {}

    public static MemberDao getInstance() {
        return instance;
    }

    @Override
    public MemberDto getMember(String userId) throws Exception {
        MemberDto member = new MemberDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from members where user_id=?";

        try {
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if(rs.next()) {
                String id = rs.getString("user_id");
                String name = rs.getString("user_name");
                String pass = rs.getString("user_password");
                String emailId = rs.getString("email_id");
                String emailDomain = rs.getString("email_domain");
                String joinDate = rs.getString("join_date");

                member.setUserId(id);
                member.setUserName(name);
                member.setUserPassword(pass);
                member.setEmailId(emailId);
                member.setEmailDomain(emailDomain);
                member.setJoinDate(joinDate);
            }

        } finally {
            dbUtil.close(rs, pstmt, conn);
        }

        return member;
    }

    @Override
    public void registerMember(MemberDto member) throws Exception {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into members(user_id, user_name, user_password, email_id, email_domain, join_date) values(?, ?, ?, ?, ?,?)";

        try {
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserName());
            pstmt.setString(3, member.getUserPassword());
            pstmt.setString(4, member.getEmailId());
            pstmt.setString(5, member.getEmailDomain());
            pstmt.setString(6, member.getJoinDate());
            int res = pstmt.executeUpdate();
            System.out.println("등록된 행의 수: " + res);

        } finally {
            dbUtil.close(pstmt, conn);
        }
    }

    @Override
    public List<MemberDto> getMembers() throws Exception {
        List<MemberDto> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from members";

        try {
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while(rs.next()) {
                MemberDto member = new MemberDto();

                String userId = rs.getString("user_id");
                String userName = rs.getString("user_name");
                String userPassword = rs.getString("user_password");
                String emailId = rs.getString("email_id");
                String emailDomain = rs.getString("email_domain");
                String joinDate = rs.getString("join_date");

                member.setUserId(userId);
                member.setUserName(userName);
                member.setUserPassword(userPassword);
                member.setEmailId(emailId);
                member.setEmailDomain(emailDomain);
                member.setJoinDate(joinDate);

                list.add(member);
            }

        } finally {
            dbUtil.close(rs, pstmt, conn);
        }

        return list;
    }

    public MemberDto loginMember(String userId, String userPassword) throws Exception {
        MemberDto member = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select user_id, user_password from members where user_id=? AND user_password=?";

        try {
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPassword);

            rs = pstmt.executeQuery();

            if(rs.next()) {
                member = new MemberDto();
                String id = rs.getString("user_id");
                String pass = rs.getString("user_password");

                member.setUserId(id);
                member.setUserPassword(pass);
            }

        } finally {
            dbUtil.close(rs, pstmt, conn);
        }

        return member;
    }
}
