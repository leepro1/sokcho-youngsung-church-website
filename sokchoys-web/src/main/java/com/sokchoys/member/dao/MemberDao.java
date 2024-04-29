package com.sokchoys.member.dao;

import com.sokchoys.member.dto.MemberDto;
import com.sokchoys.member.dto.MemberFormDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface MemberDao {

    MemberDto findById(int id) throws SQLException;

    MemberDto findByEmail(String email) throws SQLException;

    List<MemberDto> findAll() throws SQLException;

    void createMember(MemberFormDto member) throws SQLException;

    // void updatePassword(MemberPwdDto memberPwdDto) throws SQLException;

    void deleteById(int id) throws SQLException;

}
