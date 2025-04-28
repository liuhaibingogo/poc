package com.ruoyi.system.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.vo.ProductVo;
import com.ruoyi.system.mapper.BuyListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.BuyList;
import com.ruoyi.system.mapper.ProductMapper;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.service.IProductService;

/**
 * 清单列表Service业务层处理
 * 
 * @author admin
 * @date 2025-04-24
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService
{
    @Autowired
    private BuyListMapper buyListMapper;

    /**
     * 查询清单列表
     * 
     * @param ID 清单列表主键
     * @return 清单列表
     */
    @Override
    public Product selectProductByID(String ID)
    {
        return baseMapper.selectProductByID(ID);
    }

    /**
     * 查询清单列表列表
     * 
     * @param product 清单列表
     * @return 清单列表
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return baseMapper.selectProductList(product);
    }

    @Override
    public List<BuyList> selectBuyListByProductId(String productId) {
        return baseMapper.selectByProductId(productId);
    }

    /**
     * 新增清单列表
     * 
     * @param product 清单列表
     * @return 结果
     */
    @Transactional
    @Override
    public int insertProduct(Product product)
    {
        int rows = baseMapper.insertProduct(product);
        insertBuyList(product);
        return rows;
    }

    @Override
    @Transactional
    public int insertProduct(List<ProductVo> productVos,String buyListId) {
        int rows = 0;
        List<BuyList> buyLists = new ArrayList<>();
        Product product = new Product();
        product.setID(generateId());
        product.setStatus("1");
        product.setMAKER(buyListId);
        baseMapper.insertProduct(product);
        productVos.forEach(productVo -> {
            BuyList buyList = new BuyList();
            buyList.setID(UUID.randomUUID().toString().replace("-",""));
            buyList.setProductId(product.getID());
            buyList.setProductCode(productVo.getProductCode());
            buyList.setAssetType(productVo.getAssetType());
            buyList.setMAKER(productVo.getMAKER());
            buyList.setModDatetime(productVo.getModDatetime());
            buyList.setCHECKER(productVo.getCHECKER());
            buyList.setSTATUS("1");
            buyLists.add(buyList);
        });
        try {
            rows=baseMapper.batchBuyList(buyLists);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    private static int counter = 1;

    public static synchronized String generateId() {
        String id = String.format("%s%05d", "B", counter);
        counter++;
        return id;
    }
    /**
     * 修改清单列表
     * 
     * @param product 清单列表
     * @return 结果
     */
    @Transactional
    @Override
    public int updateProduct(Product product)
    {
        baseMapper.deleteBuyListByID(product.getID());
        insertBuyList(product);
        return baseMapper.updateById(product);
    }

    /**
     * 批量删除清单列表
     * 
     * @param IDs 需要删除的清单列表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteProductByIDs(String[] IDs)
    {
        baseMapper.deleteBuyListByIDs(IDs);
        return baseMapper.deleteProductByIDs(IDs);
    }

    /**
     * 删除清单列表信息
     * 
     * @param ID 清单列表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteProductByID(String ID)
    {
        baseMapper.deleteBuyListByID(ID);
        return baseMapper.deleteProductByID(ID);
    }

    /**
     * 新增采购清单信息
     * 
     * @param product 清单列表对象
     */
    public void insertBuyList(Product product)
    {
        List<BuyList> buyListList = product.getBuyListList();
        String ID = product.getID();
        if (StringUtils.isNotNull(buyListList))
        {
            List<BuyList> list = new ArrayList<BuyList>();
            for (BuyList buyList : buyListList)
            {
                buyList.setID(ID);
                list.add(buyList);
            }
            if (!list.isEmpty())
            {
                baseMapper.batchBuyList(list);
            }
        }
    }
}
