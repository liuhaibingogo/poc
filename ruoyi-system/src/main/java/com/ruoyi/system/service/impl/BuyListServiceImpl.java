package com.ruoyi.system.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BuyListMapper;
import com.ruoyi.system.domain.BuyList;
import com.ruoyi.system.service.IBuyListService;

/**
 * 采购清单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-23
 */
@Service
public class BuyListServiceImpl extends ServiceImpl<BuyListMapper, BuyList> implements IBuyListService
{

    private final BuyListMapper buyListMapper;

    public BuyListServiceImpl(BuyListMapper buyListMapper) {
        this.buyListMapper = buyListMapper;
    }

    /**
     * 查询采购清单
     * 
     * @param ID 采购清单主键
     * @return 采购清单
     */
    @Override
    public BuyList selectBuyListByID(String ID)
    {
        return baseMapper.selectById(ID);
    }

    /**
     * 查询采购清单列表
     * 
     * @param buyList 采购清单
     * @return 采购清单
     */
    @Override
    public List<BuyList> selectBuyListList(BuyList buyList)
    {
        return baseMapper.selectBuyListList(buyList);
    }

    /**
     * 新增采购清单
     * 
     * @param buyList 采购清单
     * @return 结果
     */
    @Override
    public int insertBuyList(BuyList buyList)
    {
        return baseMapper.insert(buyList);
    }

    /**
     * 修改采购清单
     * 
     * @param buyList 采购清单
     * @return 结果
     */
    @Override
    public int updateBuyList(BuyList buyList)
    {
        return baseMapper.updateById(buyList);
    }

    /**
     * 批量删除采购清单
     * 
     * @param IDs 需要删除的采购清单主键
     * @return 结果
     */
    @Override
    public int deleteBuyListByIDs(Long[] IDs)
    {
        return baseMapper.deleteByIds(Arrays.asList(IDs));
    }

    /**
     * 删除采购清单信息
     * 
     * @param ID 采购清单主键
     * @return 结果
     */
    @Override
    public int deleteBuyListByID(Long ID)
    {
        return baseMapper.deleteById(ID);
    }

    @Override
    public String uploadList(List<BuyList> buyLists, boolean updateSupport, String operName) {
        if (StringUtils.isNull(buyLists) || buyLists.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        buyLists.forEach(buyList -> {
            try {
                buyList.setMAKER(operName);
                buyList.setModDatetime(new Date());
                buyListMapper.insert(buyList);
                successMsg.append("<br/>" + successNum +" 导入成功");
            }catch (Exception e) {
                failureMsg.append("<br/>" + failureNum +" 导入失败");
            }
        });
        return successMsg.toString();
    }
}
