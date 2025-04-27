package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BuyList;
import com.ruoyi.system.service.IBuyListService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 采购清单Controller
 * 
 * @author ruoyi
 * @date 2025-04-23
 */
@RestController
@RequestMapping("/system/buyList")
public class BuyListController extends BaseController
{
    @Autowired
    private IBuyListService buyListService;

    /**
     * 查询采购清单列表
     */
    @PreAuthorize("@ss.hasPermi('system:buyList:list')")
    @GetMapping("/list")
    public TableDataInfo list(BuyList buyList)
    {
        startPage();
        List<BuyList> list = buyListService.selectBuyListList(buyList);
        return getDataTable(list);
    }

    /**
     * 导出采购清单列表
     */
    @PreAuthorize("@ss.hasPermi('system:buyList:upload')")
    @Log(title = "导入采购清单", businessType = BusinessType.EXPORT)
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file,boolean updateSupport) throws Exception
    {
        ExcelUtil<BuyList> util = new ExcelUtil<BuyList>(BuyList.class);
        List<BuyList> buyLists = util.importExcel(file.getInputStream());
        buyLists.forEach(buyList -> {
            buyListService.insertBuyList(buyList);
        });
        String operName = getUsername();
        String message = buyListService.uploadList(buyLists, updateSupport, operName);
        return success();
    }
    /**
     * 导出采购清单列表
     */
    @PreAuthorize("@ss.hasPermi('system:buyList:export')")
    @Log(title = "采购清单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyList buyList)
    {
        List<BuyList> list = buyListService.selectBuyListList(buyList);
        ExcelUtil<BuyList> util = new ExcelUtil<BuyList>(BuyList.class);
        util.exportExcel(response, list, "采购清单数据");
    }

    /**
     * 获取采购清单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:buyList:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") Long ID)
    {
        return success(buyListService.selectBuyListByID(ID));
    }

    /**
     * 新增采购清单
     */
    @PreAuthorize("@ss.hasPermi('system:buyList:add')")
    @Log(title = "采购清单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyList buyList)
    {
        return toAjax(buyListService.insertBuyList(buyList));
    }

    /**
     * 新增采购清单
     */
//    @PreAuthorize("@ss.hasPermi('system:buyList:add')")
//    @Log(title = "采购清单", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    public AjaxResult save(@RequestBody BuyList buyList)
    {
        return toAjax(buyListService.insertBuyList(buyList));
    }

    /**
     * 修改采购清单
     */
    @PreAuthorize("@ss.hasPermi('system:buyList:edit')")
    @Log(title = "采购清单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyList buyList)
    {
        return toAjax(buyListService.updateBuyList(buyList));
    }

    /**
     * 删除采购清单
     */
    @PreAuthorize("@ss.hasPermi('system:buyList:remove')")
    @Log(title = "采购清单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable Long[] IDs)
    {
        return toAjax(buyListService.deleteBuyListByIDs(IDs));
    }
}
