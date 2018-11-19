package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.LogDao;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.pojo.LogDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 日志管理
 * @Date 16:28 2018/11/14
 */
@Slf4j
@Service
public class LogDaoImpl implements LogDao {

    /* *
     * @Author MengZiJie
     * @Description 查询日志
     * @Date 16:28 2018/11/14
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.system.pojo.LogDTO>
     */
    @Override
    public PageBean<LogDTO> listLog(PageParameter<LogDTO> pageParameter) {
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<LogDTO> log = new Eql("DEFAULT").select("listLog").params(pageParameter.getParameter()).returnType(LogDTO.class).limit(eqlPage).execute();
        return new PageBean<>(eqlPage.getTotalRows(),eqlPage.getTotalPages(),eqlPage.getCurrentPage(),eqlPage.getPageRows(),eqlPage.getStartIndex(),log);
    }

    /* *
     * @Author MengZiJie
     * @Description 获取指定日志
     * @Date 16:31 2018/11/14
     * @Param [logDTO]
     * @Return com.ccicnavi.bims.system.pojo.LogDTO
     */
    @Override
    public LogDTO getLog(LogDTO logDTO) {
        return EqlUtils.getInstance("DEFAULT").selectFirst("getLog").params(logDTO).returnType(LogDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 添加日志
     * @Date 16:34 2018/11/14
     * @Param [logDTO]
     * @Return int
     */
    @Override
    public Integer insertLog(LogDTO logDTO, EqlTran tran) {
        return EqlUtils.getInstance("DEFAULT").useTran(tran).insert("insertLog").params(logDTO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志
     * @Date 16:35 2018/11/14
     * @Param [logDTO]
     * @Return int
     */
    @Override
    public Integer updateLog(LogDTO logDTO,EqlTran tran) {
        return EqlUtils.getInstance("DEFAULT").useTran(tran).update("updateLog").params(logDTO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 16:37 2018/11/14
     * @Param [logDTO]
     * @Return int
     */
    @Override
    public Integer deleteLog(LogDTO logDTO,EqlTran tran) {
        return EqlUtils.getInstance("DEFAULT").useTran(tran).delete("deleteLog").params(logDTO).returnType(Integer.class).execute();
    }
}
