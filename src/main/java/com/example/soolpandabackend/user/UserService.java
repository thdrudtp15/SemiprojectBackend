package com.example.soolpandabackend.user;

public interface UserService {

    public int MemberJoin(UserVO mamber);

    public int usercheck(UserVO member);

    public UserVO selectuser(UserVO member);

    public int updateuser(UserVO member);

    public int DuplicateCheck(UserVO member);

    public void deleteUser(UserVO member);

    public UserVO findId(UserVO user);

    public UserVO findPw(UserVO user);

    public int DuplicateEmailCheck(UserVO member);
}
