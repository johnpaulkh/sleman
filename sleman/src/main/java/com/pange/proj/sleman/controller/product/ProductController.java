package com.pange.proj.sleman.controller.product;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pange.proj.sleman.dto.ProductDto;
import com.pange.proj.sleman.model.ProductSearchBuilder;
import com.pange.proj.sleman.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = ProductControllerPath.BASE)
@Api(value = "Product API")
public class ProductController {

  @Autowired
  private ProductService productService;
  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(value = ProductControllerPath.FIND_BY_ID)
  @ApiOperation(value = "find product by id")
  public ProductDto findById(@RequestParam String id) {
    return modelMapper.map(productService.findById(id), ProductDto.class);
  }

  @GetMapping(value = ProductControllerPath.FIND_BY_SEARCH)
  @ApiOperation(value = "find product by search")
  public List<ProductDto> findBySearch(@RequestParam String productSearch) {
    return productService
        .findBySearch(new ProductSearchBuilder().withProductCode(productSearch)
            .withProductName(productSearch).build())
        .stream().map(e -> modelMapper.map(e, ProductDto.class)).collect(Collectors.toList());
  }

}
