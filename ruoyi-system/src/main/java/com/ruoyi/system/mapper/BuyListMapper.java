package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BuyList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 采购清单Mapper接口
 * 
 * @author ruoyi
 * @date 2025-04-23
 */
public interface BuyListMapper extends BaseMapper<BuyList>
{

    /**
     * 查询采购清单列表
     * 
     * @param buyList 采购清单
     * @return 采购清单集合
     */
    public List<BuyList> selectBuyListList(BuyList buyList);

}
