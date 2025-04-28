package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.BuyList;
import com.ruoyi.system.domain.vo.ProductVo;

/**
 * 清单列表Mapper接口
 * 
 * @author admin
 * @date 2025-04-24
 */
public interface ProductMapper extends BaseMapper<Product>
{

    /**
     * 查询清单列表
     * 
     * @param ID 清单列表主键
     * @return 清单列表
     */
    public Product selectProductByID(String ID);

    /**
     * 查询清单列表列表
     * 
     * @param product 清单列表
     * @return 清单列表集合
     */
    public List<Product> selectProductList(Product product);

    public List<BuyList> selectByProductId(String productId);
    /**
     * 新增清单列表
     *
     * @param product 清单列表
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改清单列表
     *
     * @param product 清单列表
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 删除清单列表
     *
     * @param ID 清单列表主键
     * @return 结果
     */
    public int deleteProductByID(String ID);

    /**
     * 批量删除清单列表
     *
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductByIDs(String[] IDs);

    /**
     * 批量删除采购清单
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuyListByIDs(String[] IDs);
    
    /**
     * 批量新增采购清单
     * 
     * @param buyListList 采购清单列表
     * @return 结果
     */
    public int batchBuyList(List<BuyList> buyListList);
    

    /**
     * 通过清单列表主键删除采购清单信息
     * 
     * @param ID 清单列表ID
     * @return 结果
     */
    public int deleteBuyListByID(String ID);
}
