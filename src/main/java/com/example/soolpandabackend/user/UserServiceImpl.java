package com.example.soolpandabackend.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int MemberJoin(UserVO mamber) {
        int res = mapper.MemberJoin(mamber);
        return res;
    }

    @Override
    public int usercheck(UserVO member) {
        int res = mapper.usercheck(member);
        return res;
    }

    @Override
    public UserVO selectuser(UserVO member) {
        UserVO vo = mapper.selectuser(member);
        return vo;
    }

    @Override
    public int updateuser(UserVO member) {
        int res = mapper.updateuser(member);
        return res;
    }

    @Override
    public int DuplicateCheck(UserVO member) {
        int res = mapper.DuplicateCheck(member);
        return res;
    }

    @Override
    public void deleteUser(UserVO member) {
        System.out.println("회원탈퇴");
        mapper.deleteUser(member);
    }


    @Override
    public UserVO findId(UserVO user) {
        return mapper.findId(user);
    }

    @Override
    public UserVO findPw(UserVO user) {
        return mapper.findPw(user);
    }

    @Override
    public int DuplicateEmailCheck(UserVO member){
        int res = mapper.DuplicateEmailCheck(member);
        return res;
    }
}
