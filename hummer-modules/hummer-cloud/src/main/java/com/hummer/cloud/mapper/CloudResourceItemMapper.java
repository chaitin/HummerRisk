package com.hummer.cloud.mapper;

import com.hummer.common.core.domain.CloudResourceItem;
import com.hummer.common.core.domain.CloudResourceItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudResourceItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    long countByExample(CloudResourceItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int deleteByExample(CloudResourceItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int insert(CloudResourceItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int insertSelective(CloudResourceItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    List<CloudResourceItem> selectByExampleWithBLOBs(CloudResourceItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    List<CloudResourceItem> selectByExample(CloudResourceItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    CloudResourceItem selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int updateByExampleSelective(@Param("record") CloudResourceItem record, @Param("example") CloudResourceItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int updateByExampleWithBLOBs(@Param("record") CloudResourceItem record, @Param("example") CloudResourceItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int updateByExample(@Param("record") CloudResourceItem record, @Param("example") CloudResourceItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int updateByPrimaryKeySelective(CloudResourceItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int updateByPrimaryKeyWithBLOBs(CloudResourceItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_resource_item
     *
     * @mbg.generated Thu Aug 17 17:57:31 CST 2023
     */
    int updateByPrimaryKey(CloudResourceItem record);
}