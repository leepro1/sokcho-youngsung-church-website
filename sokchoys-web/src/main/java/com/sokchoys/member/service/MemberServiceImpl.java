package com.sokchoys.member.service;

import com.sokchoys.SokchoException;
import com.sokchoys.member.dao.MemberDao;
import com.sokchoys.member.dto.MemberDto;
import com.sokchoys.member.dto.MemberFormDto;
import com.sokchoys.member.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberDao memberDao;

    @Transactional(readOnly = true)
    public MemberDto findById(int id) {
        try {
            MemberDto find = memberDao.findById(id);
            if(find == null){
                throw new SokchoException("해당 회원이 존재하지 않습니다.");
            }
        }catch (Exception e){
            throw new SokchoException("회원 조회 중 에러 발생");
        }

        return null;
    }

    private MemberDto findByEmail(String email) {
        try {
            MemberDto find = memberDao.findByEmail(email);
            if(find == null){
                throw new SokchoException("해당 회원이 존재하지 않습니다.");
            }

            return find;
        }catch (Exception e){
            throw new SokchoException("회원 조회 중 에러 발생");
        }
    }

    @Override
    public List<MemberDto> findAll() {
        return null;
    }

    @Override
    public void createMember(MemberFormDto member) {
        try {
            MemberDto find = memberDao.findByEmail(member.getEmail());
            if(find != null){
                throw new SokchoException("해당 이메일이 이미 존재합니다.");
            }

            memberDao.createMember(member);
        }catch (Exception e){
            throw new SokchoException("회원 가입 중 에러 발생");
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public MemberInfoDto login(String email, String password) {
        try {
            MemberDto find = memberDao.findByEmail(email);
            if(find == null){
                throw new SokchoException("존재하지 않는 회원입니다.");
            } else if (!find.getPassword().equals(password)) {
                throw new SokchoException("비밀번호가 일치하지 않습니다.");
            }

            MemberInfoDto member = new MemberInfoDto();
            member.setEmail(find.getEmail());
            member.setName(find.getName());
            member.setRole(find.getRole());
            return member;
        } catch (SQLException e){
            throw new SokchoException("로그인 처리 중 에러 발생");
        }
    }
}
