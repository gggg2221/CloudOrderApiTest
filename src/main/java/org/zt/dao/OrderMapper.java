package org.zt.dao;

import org.apache.ibatis.annotations.*;
import org.zt.pojo.Order;

@Mapper
public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_biz_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_biz_order
     *
     * @mbggenerated
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_biz_order
     *
     * @mbggenerated
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_biz_order
     *
     * @mbggenerated
     */
    Order selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_biz_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_biz_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Order record);


//    @Select("select * from cs_biz_order where ORDER_NO = #{orderNo}")
    Order selectOrderByno(String orderno);

//    @Select("select * from user where userName = #{userName}")
//    public List<User> selectUserByName(String userName);
//
//    @Insert("insert into user(userName,userAge,userAddress) values (#{userName},#{userAge},#{userAddress})")
//    public void addUser(User user);
//
//    @Update("update user set userName=#{userName},userAge=#{userAge},userAddress=#{userAddress} where id=#{id}")
//    public void updateUser(User user);
//
//    @Delete("delete from user where id=#{id}")
//    public void deleteUser(int id);


}