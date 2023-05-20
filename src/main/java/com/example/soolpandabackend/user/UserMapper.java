package com.example.soolpandabackend.user;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    //회원가입
    @Insert("INSERT INTO tb_user (user_id, user_pwd, user_name, user_code, user_tel, user_email, user_sns_push_yn, user_email_push_yn)"
            + " VALUES (#{user_id},#{user_pwd}, #{user_name}, #{user_code}, #{user_tel},#{user_email}, #{user_sns_push_yn}, #{user_email_push_yn})")
    public int MemberJoin(UserVO mamber);

    //회원가입 아이디 중복체크
    @Select("select count(*) from tb_user where user_id = #{user_id}")
    public int DuplicateCheck(UserVO member);

    //로그인 아이디 및 비밀번호 체크
    @Select("select count(*) from tb_user where user_id = #{user_id} and user_pwd = #{user_pwd} ")
    public int usercheck(UserVO member);

    //회원정보 수정
    @Update("update tb_user set user_pwd = #{user_pwd},user_tel = #{user_tel}, user_email = #{user_email}, user_sns_push_yn = #{user_sns_push_yn}, user_email_push_yn=#{user_email_push_yn} where user_id = #{user_id}")
    public int updateuser(UserVO member);

    //회원정보 수정시 기존 데이터 검색
    @Select("select * from tb_user where user_id = #{user_id}")
    public UserVO selectuser(UserVO member);

    // 회원 삭제
    @Delete("DELETE FROM tb_user WHERE user_id = #{user_id}")
    void deleteUser(UserVO user);

    // 아이디 찾기
    @Select("SELECT user_id FROM tb_user WHERE user_name = #{user_name} and user_email = #{user_email}")
    public UserVO findId(UserVO user);

    // 비밀번호 찾기
    @Select("SELECT user_pwd FROM tb_user WHERE user_id = #{user_id} and user_name = #{user_name} and user_email = #{user_email}")
    public UserVO findPw(UserVO user);

    @Select("select count(*) from tb_user where user_email = #{user_email}")
    public int DuplicateEmailCheck(UserVO member);
}
