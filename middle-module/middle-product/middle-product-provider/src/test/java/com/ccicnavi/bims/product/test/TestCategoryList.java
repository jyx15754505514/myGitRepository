package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.pojo.CategoryDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-28 14:45
 */
public class TestCategoryList {

    /**
     * list去重
     */
    @Test
    public void testCategory(){
        List<String> cateGoryList=new ArrayList<String>();
        cateGoryList.add("gricultural_products_code-animal_vegetable_fat_oil_code-palm_oil_code-palm_oil_code-palm_oil_code");
        cateGoryList.add("gricultural_products_code-animal_vegetable_fat_oil_code-  animal_oil_code");

        List<String> cateList=new ArrayList<String>();

        List<String> cateListAll=new ArrayList<String>();


        String str[]=null;
        for (int i = 0; i <cateGoryList.size() ; i++) {
            cateListAll.addAll(Arrays.asList(cateGoryList.get(i).trim().split("-")));
        }

//        for (int i = 0; i < cateListAll.size(); i++) {
//            System.out.println(cateListAll.get(i));
//        }


        List disList=cateListAll.stream().distinct().collect(Collectors.toList());
//        for (int i = 0; i < disList.size(); i++) {
//            System.out.println(disList.get(i));
//        }


        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setProductCategoryUuidList(cateGoryList);

        for (int i = 0; i < categoryDTO.getProductCategoryUuidList().size(); i++) {
            System.out.println(categoryDTO.getProductCategoryUuidList().get(i));
        }

        System.out.println("--------------------------------------------");
        categoryDTO.setProductCategoryUuidList(disList);

        for (int i = 0; i < categoryDTO.getProductCategoryUuidList().size(); i++) {
            System.out.println(categoryDTO.getProductCategoryUuidList().get(i));
        }
    }
}
