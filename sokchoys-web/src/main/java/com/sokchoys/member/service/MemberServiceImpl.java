package com.sokchoys.member.service;

import com.sokchoys.SokchoException;
import com.sokchoys.member.constant.Role;
import com.sokchoys.member.dao.MemberDao;
import com.sokchoys.member.dto.MemberDto;
import com.sokchoys.member.dto.MemberFormDto;
import com.sokchoys.member.dto.MemberInfoDto;
import com.sokchoys.member.dto.MemberPwdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    @Transactional(readOnly = true)
    public MemberDto findById(int id) {
        try {
            MemberDto find = memberDao.findById(id);
            if (find == null) {
                throw new SokchoException("해당 회원이 존재하지 않습니다.");
            }
        } catch (Exception e) {
            throw new SokchoException("회원 조회 중 에러 발생");
        }

        return null;
    }

    private MemberDto findByEmail(String email) {
        try {
            MemberDto find = memberDao.findByEmail(email);
            if (find == null) {
                throw new SokchoException("해당 회원이 존재하지 않습니다.");
            }

            return find;
        } catch (Exception e) {
            throw new SokchoException("회원 조회 중 에러 발생");
        }
    }

    @Transactional(readOnly = true)
    public List<MemberDto> findAll() {
        try {
            return memberDao.findAll();
        } catch (Exception e) {
            throw new SokchoException("회원 조회 중 에러 발생");
        }
    }

    @Override
    public void createMember(MemberFormDto member) {
        try {
            MemberDto find = memberDao.findByEmail(member.getEmail());
            if (find != null) {
                throw new SokchoException("해당 이메일이 이미 존재합니다.");
            }
            member.setPassword(Encrypt(member.getPassword()));
            memberDao.createMember(member);
        } catch (Exception e) {
            throw new SokchoException("회원 가입 중 에러 발생");
        }
    }

    @Override
    public void updatePassword(MemberPwdDto memberPwdDto) {
        try {
            memberPwdDto.setNewPwd(Encrypt(memberPwdDto.getNewPwd()));
            memberDao.updatePassword(memberPwdDto);
        } catch (Exception e) {
            throw new SokchoException("비밀번호 변경 중 에러 발생");
        }
    }

    @Override
    public void deleteById(int id) {
    }

    @Transactional(readOnly = true)
    public MemberInfoDto login(String email, String password) {
        try {
            MemberDto find = memberDao.findByEmail(email);
            if (find == null) {
                throw new SokchoException("존재하지 않는 회원입니다.");
            } else if (!find.getPassword().equals(Encrypt(password))) {
                throw new SokchoException("비밀번호가 일치하지 않습니다.");
            }

            MemberInfoDto member = new MemberInfoDto();
            member.setEmail(find.getEmail());
            member.setName(find.getName());
            member.setRole(find.getRole());
            return member;
        } catch (Exception e) {
            throw new SokchoException("로그인 처리 중 에러 발생");
        }
    }

    @Transactional
    public void auth(int id, Role role) {
        try {
            if (role.equals(Role.ADMIN)) {
                MemberDto member = new MemberDto();
                member.setId(id);
                member.setRole(Role.USER);
                memberDao.auth(member);
            } else {
                MemberDto member = new MemberDto();
                member.setId(id);
                member.setRole(Role.ADMIN);
                memberDao.auth(member);
            }
        } catch (Exception e) {
            throw new SokchoException("권한 처리 중 에러 발생");
        }
    }

    private String Encrypt(String password) throws Exception {
        return getEncrypt_keystretching(getEncrypt_keystretching(password));
    }

    private String getEncrypt_keystretching(String pwd) throws Exception {

        StringBuffer sb;
        // 1. SHA256 알고리즘 객체 생성
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // 2. pwd 문자열에 SHA 256 적용
        md.update(pwd.getBytes());
        byte[] pwdResult = md.digest();
        sb = new StringBuffer();
        for (byte b : pwdResult) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

}
