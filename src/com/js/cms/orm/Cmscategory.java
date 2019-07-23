package com.js.cms.orm;

/**
 * last update time:"17-01-08 22:16:16" 
 * last update user:pku
 */

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.js.cms.ormex.CmscategoryEx;
import com.js.common.anno.TableAnno;

@TableAnno(name="cms_cmscategory")
public class Cmscategory extends CmscategoryEx{

   
	 List<Cmscategory> children= new ArrayList();

	    public List<Cmscategory> getChildren() {
	        return children;
	    }

	    public void setChildren(List<Cmscategory> children) {
	        this.children = children;
	    }
	
    
}