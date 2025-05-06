package com.ruoyi.system.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.BuyList;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.domain.vo.ProductVo;

/**
 * 清单列表Service接口
 * 
 * @author admin
 * @date 2025-04-24
 */
public interface IProductService extends IService<Product>
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


    public List<BuyList> selectBuyListByProductId(String Id);

    /**
     * 新增清单列表
     * 
     * @param product 清单列表
     * @return 结果
     */
    public int insertProduct(Product product);

    public int insertProduct(List<ProductVo> productVos,String buyListId);
    /**
     * 修改清单列表
     * 
     * @param product 清单列表
     * @return 结果
     */
    public int updateProduct(Product product);

    public int updateProduct(List<ProductVo> productVos,String buyListId);

    /**
     * 批量删除清单列表
     * 
     * @param IDs 需要删除的清单列表主键集合
     * @return 结果
     */
    public int deleteProductByIDs(String[] IDs);

    /**
     * 删除清单列表信息
     * 
     * @param ID 清单列表主键
     * @return 结果
     */
    public int deleteProductByID(String ID);
}
