package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.CodeResultItem;
import com.hummerrisk.base.domain.CodeResultItemExample;
import com.hummerrisk.base.domain.CodeResultItemWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeResultItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    long countByExample(CodeResultItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int deleteByExample(CodeResultItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int insert(CodeResultItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int insertSelective(CodeResultItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    List<CodeResultItemWithBLOBs> selectByExampleWithBLOBs(CodeResultItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    List<CodeResultItem> selectByExample(CodeResultItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    CodeResultItemWithBLOBs selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int updateByExampleSelective(@Param("record") CodeResultItemWithBLOBs record, @Param("example") CodeResultItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") CodeResultItemWithBLOBs record, @Param("example") CodeResultItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int updateByExample(@Param("record") CodeResultItem record, @Param("example") CodeResultItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int updateByPrimaryKeySelective(CodeResultItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(CodeResultItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_result_item
     *
     * @mbg.generated Fri Aug 26 07:57:01 CST 2022
     */
    int updateByPrimaryKey(CodeResultItem record);
}