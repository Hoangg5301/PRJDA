package com.Bluewind.controller.user;

import com.Bluewind.common.CartCommon;
import com.Bluewind.dto.CartProductDetail;
import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.OdDetailDTO;
import com.Bluewind.dto.OrderResponse;
import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.service.*;
import com.Bluewind.service.impl.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller(value = "orderControllerOfUser")
public class OrderController {

    private final IOrderService orderService;
    private final IOrderDetailService iOrderDetailService;
    private final ICartService iCartService;
    private final CartCommon cartCommon;
    private final OdService odService;
    private final OdDetailService odDetailService;

    public OrderController(OrderService orderService, IOrderDetailService iOrderDetailService, ICartService iCartService, CartCommon cartCommon, OdService odService, OdDetailService odDetailService) {
        this.orderService = orderService;
        this.iOrderDetailService = iOrderDetailService;
        this.iCartService = iCartService;
        this.cartCommon = cartCommon;
        this.odService = odService;
        this.odDetailService = odDetailService;
    }

//    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
//    public ModelAndView checkout(@RequestBody Integer accountId) {
//        ModelAndView mav = new ModelAndView("");
//        List<CartProductDetail> cartProductDetails = cartCommon.getCarts(accountId);
//        mav.addObject("cartProductDetails", cartProductDetails);
//        return mav;
//    }

    @GetMapping("/order-by-id")
    public ModelAndView order(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        String accountId = request.getParameter("accountId");
        List<OdDTO> orderDTOS = odService.findAllByAccountID(Integer.parseInt(accountId));
        List<Integer> orderIds = new ArrayList<>();

        if (!orderDTOS.isEmpty()) {
            for (OdDTO odDTO : orderDTOS) {
                orderIds.add(odDTO.getId());
            }
        }

        List<OrderResponse> orderResponses = new ArrayList<>();

        List<OdDetailDTO> orderDetailDTOS = odDetailService.findAllByProductIDIs(orderIds);
        if (!orderDetailDTOS.isEmpty()) {
            for (OdDTO dto : orderDTOS) {
                List<OdDetailDTO> detailDTOS = orderDetailDTOS.stream().filter(o -> Objects.equals(o.getOdId(), dto.getId())).collect(Collectors.toList());
                OrderResponse orderResponse = new OrderResponse();
                orderResponse.setOdDTO(dto);
                orderResponse.setOdDetailDTOS(detailDTOS);

                orderResponses.add(orderResponse);
            }
        }

        mav.addObject("orderResponses", orderResponses);
        return mav;
    }

    // tim kiem don hang theo so dien thoai
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public ModelAndView homePage(HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView("");
//        String phone = request.getParameter("phone");
//        List<OrderDTO> orderDTOS = odService.findByPhoneNumber(phone);
//        List<Integer> orderIds = new ArrayList<>();
//        if (!orderDTOS.isEmpty()) {
//            for (OrderDTO orderDTO : orderDTOS) {
//                orderIds.add(orderDTO.getOrderID());
//            }
//        }
//
//        List<OrderResponse> orderResponses = new ArrayList<>();
//
//        List<OrderDetailDTO> orderDetailDTOS = iOrderDetailService.findAllByProductIDIs(orderIds);
//        if (!orderDetailDTOS.isEmpty()) {
//            for (OrderDTO dto : orderDTOS) {
//                List<OrderDetailDTO> detailDTOS = orderDetailDTOS.stream().filter(o -> Objects.equals(o.getOrderID(), dto.getOrderID())).collect(Collectors.toList());
//                OrderResponse orderResponse = new OrderResponse();
//                orderResponse.setOdDTO(dto);
//                orderResponse.setOdDetailDTOS(detailDTOS);
//
//                orderResponses.add(orderResponse);
//            }
//        }
//
//        mav.addObject("orderResponses", orderResponses);
//        return mav;
//    }
}
