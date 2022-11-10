package com.example.erp.controller;


import com.example.erp.common.Result;
import com.example.erp.mapper.GoodsMapper;
import com.example.erp.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;

import com.example.erp.service.IGoodsService;
import com.example.erp.entity.Goods;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JHJ
 * @since 2022-11-01
 */
@RestController
@RequestMapping("//goods")
        public class GoodsController {

    @Resource
    private IGoodsService goodsService;
    @Resource
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public Result save(@RequestBody Goods goods) {
        goodsService.saveOrUpdate(goods);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        goodsService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        goodsService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(goodsService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(goodsService.getById(id));
    }

    @GetMapping("/getall")
    public List<Goods> getall() {
        return goodsService.list();

    }

    @GetMapping("/getone/{id}")
    public Goods getone(@PathVariable int id) {
        return goodsService.getById(id);
    }

    //分页查询
    // 接口路径： /user/page?pageNum=1&pageSize=10
    // @RequestParam接受
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Goods> data = goodsMapper.selectPage(pageNum, pageSize);
        Integer total = goodsMapper.selectTotal();
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //相邻算法
    @GetMapping("/adjacent/{id}")
    public List<Goods> adjacentList(@PathVariable int id) {
        List<Goods> allGoods = goodsService.list();
        List<Goods> resultList = new ArrayList<>();
        Goods ajwGood = goodsService.getById(id);
        Goods tmpGood,tmpGood1, tmpGood2;
        float maxDisP = 0;
        float maxDisT = 0;
        float tmpDisP;
        float tmpDisT;
        int i, j;
        for (i = 0; i < allGoods.size(); i++) {
            for (j = 0; j < allGoods.size(); j++) {
                tmpGood1 = goodsService.getById(i + 1);
                tmpGood2 = goodsService.getById(j + 1);
                if (Math.abs(tmpGood1.getPrice() - tmpGood2.getPrice()) > maxDisP) {
                    maxDisP = Math.abs(tmpGood1.getPrice() - tmpGood2.getPrice());
                }
            }
        }
        for (i = 0; i < allGoods.size(); i++) {
            for (j = 0; j < allGoods.size(); j++) {
                tmpGood1 = goodsService.getById(i + 1);
                tmpGood2 = goodsService.getById(j + 1);
                if (Math.abs(tmpGood1.getType() - tmpGood2.getType()) > maxDisT) {
                    maxDisT = Math.abs(tmpGood1.getPrice() - tmpGood2.getPrice());
                }
            }
        }
        for (i = 0; i < allGoods.size(); i++) {
            if (id != i + 1) {
                tmpGood = goodsService.getById(i + 1);
                tmpDisP = Math.abs(ajwGood.getPrice() - tmpGood.getPrice()) / maxDisP;
                tmpDisT = Math.abs(ajwGood.getType() - tmpGood.getType()) / maxDisT;
                if (Math.sqrt(tmpDisP * tmpDisP + tmpDisT * tmpDisT) < 0.4) {
                    resultList.add(tmpGood);
                }
            }
        }
        if (resultList.size() == 0) {
            for (i = 0; i < allGoods.size(); i++) {
                int allgoodssum = goodsMapper.querySumSold();
                if ((float) goodsService.getById(i + 1).getSold() / allgoodssum > 0.15) {
                    resultList.add(goodsService.getById(i + 1));
                }
            }

        }
        return resultList;

    }

    //热销商品
    @GetMapping("/hot")
    public List<Goods> hotsold() {
        return goodsMapper.hotsold();
    }

    //关联查询
    @GetMapping("/correlation/{id}")
    public List<Goods> correlation(@PathVariable Integer id) {
        Integer thisOrderNum = orderMapper.findNumByID(id);
        Integer allOrderNum = orderMapper.findAllOrderNum();
        Float thisSupport = (float) thisOrderNum / (float) allOrderNum;

        List<Goods> otherGoods = goodsMapper.findOtherGoods(id);
        List<Goods> result = new LinkedList<>();

        Iterator<Goods> iterator = otherGoods.iterator();
        while (iterator.hasNext()) {
            Goods thisGood = iterator.next();
            Integer GoodOrderNum = orderMapper.findNumByID(thisGood.getId());
            Float GoodSupport = (float) GoodOrderNum / (float) allOrderNum;
            if(GoodSupport > 0.3) {
                Float twoGoodSupport = (float) orderMapper.findNumByTwoId(id, thisGood.getId()) / (float) allOrderNum;
                Float certificate = twoGoodSupport / thisSupport;

                if (certificate > 0.5) {
                    result.add(thisGood);
                }
            }
        }

        return result;
    }

//    //关联查询
//    @GetMapping("/correlation/{id}")
//    public List<Goods> correlation(@PathVariable int id) {
//        List<Orders> allorderList = orderService.list();
//        List<Goods> allgoodsList = goodsService.list();
//        List<Orders> ajwList = orderMapper.queryOneOften(id);
//        List<Goods> resultList = new ArrayList<>();
//        List<Orders> tList;
//        float ajwSupport = (float) ajwList.size() / allorderList.size();
//        if (ajwSupport > 0.2) {
//            int i;
//            for (i = 0; i < allgoodsList.size(); i++) {
//                if (id != i + 1) {
//                    List<Orders> tOrder = orderMapper.queryOneOften(i + 1);
//                    if ((float) tOrder.size() / allorderList.size() > 0.2) {
//                        tList = orderMapper.query(id, i + 1);
//                        float tSupport = (float) tList.size() / allorderList.size();
//                        if (tSupport / ajwSupport > 0.6) {
//                            resultList.add(goodsService.getById(i + 1));
//                        }
//                    }
//                }
//            }
//        }
//        if (resultList.size() == 0) {
//            int i;
//            int allgoods = goodsMapper.querySumSold();
//            for (i = 0; i < allgoodsList.size(); i++) {
//                if ((float) goodsService.getById(i + 1).getSold() / allgoods > 0.15) {
//                    resultList.add(goodsService.getById(i + 1));
//                }
//            }
//        }
//        return resultList;
//    }

    @GetMapping("/correlationInterest/{id}")
    public List<Goods> correlationInterest(@PathVariable Integer id) {//兴趣度算法
        Integer thisOrderNum = orderMapper.findNumByID(id);
        Integer allOrderNum = orderMapper.findAllOrderNum();
        Float thisSupport = (float) thisOrderNum / (float) allOrderNum;

        List<Goods> otherGoods = goodsMapper.findOtherGoods(id);
        List<Goods> result = new LinkedList<>();

        Iterator<Goods> iterator = otherGoods.iterator();
        while (iterator.hasNext()) {
            Goods thisGood = iterator.next();
            Integer GoodOrderNum = orderMapper.findNumByID(thisGood.getId());
            Float GoodSupport = (float) GoodOrderNum / (float) allOrderNum;
            if(GoodSupport > 0.3){
                Float twoGoodSupport = (float) orderMapper.findNumByTwoId(id, thisGood.getId()) / (float) allOrderNum;
                Float interest = twoGoodSupport / (thisSupport * GoodSupport);

                if (interest > 1) {
                    result.add(thisGood);
                }
            }
        }

        return result;
    }

}



