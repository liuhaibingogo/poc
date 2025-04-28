package com.ruoyi.web.controller.product;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.BuyList;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.domain.vo.ProductVo;
import com.ruoyi.system.service.IBuyListService;
import com.ruoyi.system.service.IProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 清单列表Controller
 * 
 * @author admin
 * @date 2025-04-24
 */
@RestController
@RequestMapping("/system/product")
public class ProductController extends BaseController
{
    @Autowired
    private IProductService productService;
    @Autowired
    private IBuyListService buyListService;
    /**
     * 查询清单列表列表
     */
    @PreAuthorize("@ss.hasPermi('tool:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('tool:product:list')")
    @GetMapping("/buylist")
    public TableDataInfo buylist(String productId)
    {
        startPage();
        List<BuyList> list = productService.selectBuyListByProductId(productId);
        return getDataTable(list);
    }

    /**
     * 导出清单列表列表
     */
    @PreAuthorize("@ss.hasPermi('tool:product:export')")
    @Log(title = "清单列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        util.exportExcel(response, list, "清单列表数据");
    }

    /**
     * 获取清单列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('tool:product:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") String ID)
    {
        return success(productService.selectProductByID(ID));
    }

    /**
     * 新增清单列表
     */
    @PreAuthorize("@ss.hasPermi('tool:product:add')")
    @Log(title = "清单列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    @Log(title = "BuyList", businessType = BusinessType.INSERT)
    @PreAuthorize("@ss.hasPermi('tool:product:list')")
    @PostMapping("/save")
    public AjaxResult save(@RequestBody List<ProductVo> productVos)
    {
        return toAjax(productService.insertProduct(productVos, String.valueOf(getUserId())));
    }

    @Log(title = "BuyList", businessType = BusinessType.INSERT)
    @PreAuthorize("@ss.hasPermi('tool:product:list')")
    @PostMapping("/update")
    public AjaxResult update(@RequestBody List<ProductVo> productVos)
    {
        return toAjax(productService.insertProduct(productVos, String.valueOf(getUserId())));
    }
    /**
     * 修改清单列表
     */
    @PreAuthorize("@ss.hasPermi('tool:product:edit')")
    @Log(title = "清单列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除清单列表
     */
    @PreAuthorize("@ss.hasPermi('tool:product:remove')")
    @Log(title = "清单列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable String[] IDs)
    {
        return toAjax(productService.deleteProductByIDs(IDs));
    }
}
