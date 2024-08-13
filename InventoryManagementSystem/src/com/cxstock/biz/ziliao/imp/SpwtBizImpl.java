package com.cxstock.biz.ziliao.imp;

import com.cxstock.biz.ziliao.SpwtBiz;
import com.cxstock.biz.ziliao.dto.SpwtDTO;
import com.cxstock.dao.BaseDAO;
import com.cxstock.pojo.Spwt;

import com.cxstock.utils.pubutil.ComboData;
import com.cxstock.utils.pubutil.Page;

import java.util.ArrayList;
import java.util.List;

public class SpwtBizImpl implements SpwtBiz {

    private BaseDAO baseDao;

    public void setBaseDao(BaseDAO baseDao) {
        this.baseDao = baseDao;
    }

    /*
     * 分页查询客户列表
     */
    @SuppressWarnings("unchecked")
    public void findPageKh(Page page) {
        List list = baseDao.listAll("Spwt", page.getStart(), page.getLimit());
        List dtoList = SpwtDTO.createDtos(list);
        int total = baseDao.countAll("Spwt");
        page.setRoot(dtoList);
        page.setTotal(total);
    }

    /*
     * 保存/修改客户
     */
    public void saveOrUpdateKh(SpwtDTO dto) {
        Spwt kh = new Spwt();
        if (dto.getKhid() != null) {
            kh = (Spwt) baseDao.loadById(Spwt.class, dto.getKhid());
        }
        kh.setKhname(dto.getKhname());
        kh.setLxren(dto.getLxren());
        kh.setLxtel(dto.getLxtel());
        kh.setAddress(dto.getAddress());
        kh.setBz(dto.getBz());
        baseDao.saveOrUpdate(kh);
    }

    /*
     * 删除客户
     */
    public void deleteKh(Integer khid) {
        baseDao.deleteById(Spwt.class, khid);
    }

    /*
     * 客户下拉列表
     */
    @SuppressWarnings("unchecked")
    public List findKhComb() {
        List<ComboData> list = new ArrayList<ComboData>();
        List<Spwt> gysList = baseDao.listAll("Spwt");
        for (Spwt kh : gysList) {
            ComboData comb = new ComboData();
            comb.setValue(kh.getKhid().toString());
            comb.setText(kh.getKhname());
            list.add(comb);
        }
        return list;
    }

}
