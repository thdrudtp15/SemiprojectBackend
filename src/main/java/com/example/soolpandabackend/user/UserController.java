package com.example.soolpandabackend.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserServiceImpl memberservice;

    public UserController(UserServiceImpl memberservice) {
        this.memberservice = memberservice;
    }

    //회원가입
    @RequestMapping("/Memberjoin")
    public int MemberJoin(@RequestBody UserVO member) {
        int res = memberservice.MemberJoin(member);
        return res;
    }

    //로그인
    @RequestMapping("/usercheck")
    public int usercheck(@RequestBody UserVO member) {
        int res = memberservice.usercheck(member);
        return res;
    }

    //회원정보 수정 - 회원데이터 조회
    @RequestMapping("/selectuser")
    public UserVO selectuser(@RequestBody UserVO member) {
        UserVO vo = memberservice.selectuser(member);
        return vo;
    }

    //회원정보 수정
    @RequestMapping("/updateuser")
    public int updateuser(@RequestBody UserVO member) {
        int res = memberservice.updateuser(member);
        System.out.println(member.getUser_id());
        return res;
    }

    //아이디 중복체크
    @RequestMapping("/DuplicateCheck")
    public int DuplicateCheck(@RequestBody UserVO member) {
        int res = memberservice.DuplicateCheck(member);
        return res;
    }


    // 회원 탈퇴
    @RequestMapping("/deleteuser")
    public void deleteUser(@RequestBody UserVO member) {
        memberservice.deleteUser(member);
    }

    //아이디 찾기
    @RequestMapping("/user/find/id")
    public String findId(@RequestBody UserVO user) {
        if (memberservice.findId(user) == null) {
            return "이 정보로 가입한 아이디가 없습니다.";
        } else {
            UserVO vo = memberservice.findId(user);
            return vo.getUser_id();
        }
    }

    // 비밀번호 찾기
    @RequestMapping("/user/find/pw")
    public String findPw(@RequestBody UserVO user) {
        if (memberservice.findPw(user) == null) {
            return "찾으시는 정보가 없습니다.";
        } else {
            UserVO vo = memberservice.findPw(user);
            return vo.getUser_pwd();
        }
    }

    @RequestMapping("/DuplicateEmailCheck")
    public int DuplicateEmailCheck(@RequestBody UserVO member) {
        System.out.println(member);
        int res = memberservice.DuplicateEmailCheck(member);
        return res;
    }


}
