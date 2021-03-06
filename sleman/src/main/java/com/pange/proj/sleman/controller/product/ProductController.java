package com.pange.proj.sleman.controller.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pange.proj.sleman.dto.ProductBaseDto;
import com.pange.proj.sleman.dto.ProductDto;
import com.pange.proj.sleman.dto.base.ListDto;
import com.pange.proj.sleman.dto.base.SingleDto;
import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Product;
import com.pange.proj.sleman.model.ProductSearchBuilder;
import com.pange.proj.sleman.service.ProductService;
import com.pange.proj.sleman.validator.ProductValidator;

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
  public SingleDto<ProductDto> findById(@RequestParam String id) {
    return new SingleDto<>(modelMapper.map(productService.findById(id), ProductDto.class));
  }

  @GetMapping(value = ProductControllerPath.FIND_BY_SEARCH)
  @ApiOperation(value = "find product by search")
  public ListDto<ProductBaseDto> findBySearch(@RequestParam String productSearch) {
    return new ListDto<>(productService
        .findBySearch(
            new ProductSearchBuilder().withProductCode(productSearch)
                .withProductName(productSearch).build()).stream()
        .map(e -> modelMapper.map(e, ProductBaseDto.class)).collect(Collectors.toList()));
  }

  @PostMapping(value = ProductControllerPath.CREATE)
  @ApiOperation(value = "create")
  public SingleDto<ProductDto> create(@RequestBody ProductDto request) throws ApplicationException {
    ProductValidator.validateForCreate(request);
    return new SingleDto<>(modelMapper.map(
        productService.create(modelMapper.map(request, Product.class)), ProductDto.class));
  }

  @PostMapping(value = ProductControllerPath.UPDATE)
  @ApiOperation(value = "update")
  public SingleDto<ProductDto> update(@RequestBody ProductDto request) throws ApplicationException {
    ProductValidator.validateForUpdate(request);
    return new SingleDto<>(modelMapper.map(
        productService.update(modelMapper.map(request, Product.class)), ProductDto.class));
  }

}
