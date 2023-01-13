package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.CloudNativeSourceRbacRelation;
import com.hummerrisk.base.domain.CloudNativeSourceRbacRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudNativeSourceRbacRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    long countByExample(CloudNativeSourceRbacRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int deleteByExample(CloudNativeSourceRbacRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int insert(CloudNativeSourceRbacRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int insertSelective(CloudNativeSourceRbacRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    List<CloudNativeSourceRbacRelation> selectByExample(CloudNativeSourceRbacRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    CloudNativeSourceRbacRelation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int updateByExampleSelective(@Param("record") CloudNativeSourceRbacRelation record, @Param("example") CloudNativeSourceRbacRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int updateByExample(@Param("record") CloudNativeSourceRbacRelation record, @Param("example") CloudNativeSourceRbacRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int updateByPrimaryKeySelective(CloudNativeSourceRbacRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_source_rbac_relation
     *
     * @mbg.generated Sat Jan 14 04:01:44 CST 2023
     */
    int updateByPrimaryKey(CloudNativeSourceRbacRelation record);
}