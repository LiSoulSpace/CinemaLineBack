package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.OrderDTO;
import xyz.soulspace.cinemaline.kafka.producer.OrderProducer;
import xyz.soulspace.cinemaline.service.OrderService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Controller
@RequestMapping("/cinemaline/order")
public class OrderController {
    @Autowired
    OrderProducer producer;
    @Autowired
    OrderService orderService;

    @Operation(summary = "test")
    @RequestMapping(value = "/testKafkaString", method = RequestMethod.GET)
    public ResponseEntity<?> testKafkaString(@RequestParam String send) {
        String s = producer.sendOrder(send);
        return ResponseEntity.ok(s);
    }

    @Operation(summary = "获取订单信息")
    @RequestMapping(value = "getOrder", method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@RequestParam Long orderId) {
        OrderDTO orderDTOByOrderId = orderService.getOrderDTOByOrderId(orderId);
        return ResponseEntity.ok(CommonResult.success(orderDTOByOrderId));
    }

}
