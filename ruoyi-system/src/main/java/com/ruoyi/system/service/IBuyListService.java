package com.ruoyi.system.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.BuyList;

/**
 * 采购清单Service接口
 * 
 * @author ruoyi
 * @date 2025-04-23
 */
public interface IBuyListService extends IService<BuyList>
{
    /**
     * 查询采购清单
     * 
     * @param ID 采购清单主键
     * @return 采购清单
     */
    public BuyList selectBuyListByID(Long ID);

    /**
     * 查询采购清单列表
     * 
     * @param buyList 采购清单
     * @return 采购清单集合
     */
    public List<BuyList> selectBuyListList(BuyList buyList);

    /**
     * 新增采购清单
     * 
     * @param buyList 采购清单
     * @return 结果
     */
    public int insertBuyList(BuyList buyList);

    /**
     * 修改采购清单
     * 
     * @param buyList 采购清单
     * @return 结果
     */
    public int updateBuyList(BuyList buyList);

    /**
     * 批量删除采购清单
     * 
     * @param IDs 需要删除的采购清单主键集合
     * @return 结果
     */
    public int deleteBuyListByIDs(Long[] IDs);

    /**
     * 删除采购清单信息
     * 
     * @param ID 采购清单主键
     * @return 结果
     */
    public int deleteBuyListByID(Long ID);

    String uploadList(List<BuyList> buyLists, boolean updateSupport, String operName);
}
