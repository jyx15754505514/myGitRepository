package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 客户联系人数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class LinkmanDaoImpl implements LinkmanDao {

    @Override
    public List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) {
        return new Eql().select("listLinkman").params(linkmanDO).execute();
    }

    @Override
    public int saveLinkman(LinkmanDO linkmanDO) {
        return new Eql().insert("insertLinkman").params(linkmanDO).execute();
    }

    @Override
    public int removeLinkman(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return new Eql().update("deleteLinkman").params(data).execute();
    }

    @Override
    public int updateLinkman(LinkmanDO linkmanDO) {
        return new Eql().update("updateLinkman").params(linkmanDO).execute();
    }

    @Override
    public LinkmanDO getLinkman(LinkmanDO linkmanDO) {
        return new Eql().selectFirst("listLinkman").params(linkmanDO).execute();
    }






}
