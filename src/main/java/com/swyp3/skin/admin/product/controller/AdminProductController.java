package com.swyp3.skin.admin.product.controller;

import com.swyp3.skin.admin.product.dto.AdminProductCreateForm;
import com.swyp3.skin.admin.product.dto.AdminProductUpdateForm;
import com.swyp3.skin.admin.product.service.AdminProductService;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.domain.enums.ProductCategory;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;

    @GetMapping
    public String productPage(Model model) {
        List<Product> products = adminProductService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", ProductCategory.values());
        return "admin/product/index";
    }

    @GetMapping("/new")
    public String productCreatePage(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", AdminProductCreateForm.empty());
        }
        return "admin/product/form";
    }

    @PostMapping
    public String createProduct(
            @Valid @ModelAttribute("form") AdminProductCreateForm form,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "admin/product/form";
        }

        Long productId = adminProductService.create(form);
        redirectAttributes.addFlashAttribute("message", "상품 등록 완료 (ID=" + productId + ")");
        return "redirect:/admin/products";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable("id") Long productId,
            @Valid @ModelAttribute AdminProductUpdateForm form,
            RedirectAttributes redirectAttributes
    ) {
        adminProductService.update(productId, form);
        redirectAttributes.addFlashAttribute("message", "상품 수정 완료(ID=" + productId + ")");
        return "redirect:/admin/products";
    }


    @PostMapping("/{productId}/delete")
    public String delete(
            @PathVariable("productId") Long productId,
            RedirectAttributes redirectAttributes) {
        adminProductService.delete(productId);
        redirectAttributes.addFlashAttribute("message", "상품 삭제 완료(ID=" + productId + ")");
        return "redirect:/admin/products";
    }
}
