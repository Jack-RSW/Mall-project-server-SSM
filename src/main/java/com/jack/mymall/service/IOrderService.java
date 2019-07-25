package com.jack.mymall.service;

import com.github.pagehelper.PageInfo;
import com.jack.mymall.common.ServerResponse;
import com.jack.mymall.vo.OrderVo;

import java.util.List;
import java.util.Map;

public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);

    ServerResponse aliCallback(Map<String,String> params);

    ServerResponse<String> cancel(Integer userId,Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<String> manageSendGoods(Long orderNo);

}
