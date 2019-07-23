package com.js.cms.ishop.orm;

import com.js.cms.ishop.ormex.MealOptionValueEx;
import com.js.common.anno.TableAnno;

/**
 * 套餐与选项值关联，套餐Id即套餐选项值Id,选项值Id，查询的时候使用套餐选项值Id来查询
 */

@TableAnno(name = "oc_meal_option_value")
public class MealOptionValue extends MealOptionValueEx{



}
