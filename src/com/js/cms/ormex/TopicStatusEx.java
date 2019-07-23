package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableFieldType;

public class TopicStatusEx {

    @PrimaryKey
    //@AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int topicId;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int indexStatus;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long updateTime;


}
