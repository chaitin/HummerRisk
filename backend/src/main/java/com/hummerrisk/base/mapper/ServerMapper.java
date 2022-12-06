package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.Server;
import com.hummerrisk.base.domain.ServerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    long countByExample(ServerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int deleteByExample(ServerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int insert(Server record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int insertSelective(Server record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    List<Server> selectByExampleWithBLOBs(ServerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    List<Server> selectByExample(ServerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    Server selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int updateByExampleSelective(@Param("record") Server record, @Param("example") ServerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") Server record, @Param("example") ServerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int updateByExample(@Param("record") Server record, @Param("example") ServerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int updateByPrimaryKeySelective(Server record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(Server record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server
     *
     * @mbg.generated Wed Sep 21 14:57:57 CST 2022
     */
    int updateByPrimaryKey(Server record);
}
