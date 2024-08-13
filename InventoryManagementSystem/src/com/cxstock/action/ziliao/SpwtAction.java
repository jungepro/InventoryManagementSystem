package com.cxstock.action.ziliao;


import com.cxstock.action.BaseAction;
import com.cxstock.biz.ziliao.SpwtBiz;
import com.cxstock.biz.ziliao.dto.SpwtDTO;
import com.cxstock.utils.pubutil.Page;

@SuppressWarnings("serial")
public class SpwtAction extends BaseAction {

    private SpwtBiz khBiz;

    private Integer khid;
    private String khname;
    private String lxren;
    private String lxtel;
    private String address;
    private String bz;

    /**
     * 分页查询客户列表
     */
    public String findPageKh() {
        try {
            Page page = new Page();
            page.setStart(this.getStart());
            page.setLimit(this.getLimit());
            khBiz.findPageKh(page);
            this.outPageString(page);
        } catch (Exception e) {
            e.printStackTrace();
            this.outError();
        }
        return null;
    }

    /**
     * 保存/修改客户
     */
    public String saveOrUpdateKh() {
        try {
            SpwtDTO dto = new SpwtDTO(khid, khname, lxren, lxtel, address, bz);
            khBiz.saveOrUpdateKh(dto);
            if (khid == null) {
                this.outString("{success:true,message:'保存成功!'}");
            } else {
                this.outString("{success:true,message:'修改成功!'}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.outError();
        }
        return null;
    }

    /**
     * 删除客户
     */
    public String deleteKh() {
        try {
            khBiz.deleteKh(khid);
            this.outString("{success:true}");
        } catch (Exception e) {
            e.printStackTrace();
            this.outError();
        }
        return null;
    }

    /**
     * 客户下拉列表
     */
    public String findKhComb() {
        try {
            this.outListString(khBiz.findKhComb());
        } catch (Exception e) {
            e.printStackTrace();
            this.outError();
        }
        return null;
    }

    public void setKhBiz(SpwtBiz khBiz) {
        this.khBiz = khBiz;
    }

    public void setKhid(Integer khid) {
        this.khid = khid;
    }

    public void setKhname(String khname) {
        this.khname = khname;
    }

    public void setLxren(String lxren) {
        this.lxren = lxren;
    }

    public void setLxtel(String lxtel) {
        this.lxtel = lxtel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }


}
