package com.Bluewind.api.user;

import com.Bluewind.common.CartCommon;
import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.OdDetailDTO;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.OrderResponse;
import com.Bluewind.dto.admin.CartDTO;
import com.Bluewind.service.ICartService;
import com.Bluewind.service.OdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController(value = "orderCheckout")
public class OrderAPI {

    private final OdService odService;
    private final ICartService iCartService;
    private final CartCommon cartCommon;


    @PostMapping("/order")
    public OrderResponse checkout(
            @RequestParam("fullName") String fullName,
            @RequestParam("address") String address,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("status") String status,
            @RequestParam("accountId") String accountId,
            @RequestParam("discount") String discount
    ) {
        OrderRequest request = new OrderRequest();
        OdDTO odDTO = new OdDTO();
        odDTO.setFullName(fullName);
        odDTO.setAddress(address);
        odDTO.setPhoneNumber(phoneNumber);
        odDTO.setStatus(cartCommon.stringToNumber(status));
        odDTO.setAccountId(cartCommon.stringToNumber(accountId));
        odDTO.setDiscount(cartCommon.stringToNumber(discount));

        request.setOdDTO(odDTO);
        OrderResponse orderResponse = new OrderResponse();
        if (request.getOdDTO() != null && request.getOdDTO().getAccountId() != 0) {
            List<CartDTO> cartDTOList = iCartService.findAllByAccountID(request.getOdDTO().getAccountId());

            List<OdDetailDTO> odDetailDTOS = new ArrayList<>();
            if (!cartDTOList.isEmpty()) {
                for (CartDTO cartDTO : cartDTOList) {
                    OdDetailDTO odDetailDTO = new OdDetailDTO();
                    odDetailDTO.setProductDetailId(cartDTO.getProductID());
                    odDetailDTO.setQuantity(cartDTO.getQuantity());
                    odDetailDTOS.add(odDetailDTO);
                }
            }
            request.setOdDetailDTOS(odDetailDTOS);

            orderResponse = odService.saveOrder(request);
            if (orderResponse != null) {
                List<Integer> cartIds = cartDTOList.stream().map(CartDTO::getCartID).collect(Collectors.toList());
                iCartService.deleteById(cartIds);
            }
        }

        return orderResponse;
    }

}
