package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bluewind.convert.CartConvert;
import com.Bluewind.dto.admin.CartDTO;
import com.Bluewind.entity.CartEntity;
import com.Bluewind.repository.CartRepository;
import com.Bluewind.service.ICartService;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartConvert cartConvert;

    @Override
    public List<CartDTO> findAll() {
        List<CartDTO> listCartDTO = new ArrayList<>();
        List<CartEntity> listCartEntity = cartRepository.findAll();
        for (CartEntity cartEntity : listCartEntity) {
            CartDTO cartDTO = cartConvert.toDTO(cartEntity);
            listCartDTO.add(cartDTO);
        }

        return listCartDTO;
    }

    @Override
    public CartDTO findById(Integer id) {
        CartDTO cartDTO = cartConvert.toDTO(cartRepository.findOne(id));
        return cartDTO;
    }

    @Override
    @Transactional
    public CartDTO insert(CartDTO dto) {
        CartEntity cartEntity = cartConvert.toEntity(dto);
        cartEntity = cartRepository.save(cartEntity);

        return cartConvert.toDTO(cartEntity);
    }

    @Override
    @Transactional
    public CartDTO update(CartDTO dto) {
        CartEntity cartEntity = cartRepository.find(dto.getAccountID(), dto.getProductID());//finCartEntity(dto.getAccountID(), dto.getProductID());
        cartEntity = cartConvert.toEntity(dto, cartEntity);
        cartEntity = cartRepository.save(cartEntity);
        return cartConvert.toDTO(cartEntity);
    }

    @Override
    @Transactional
    public void delete(Integer accountID) {
        List<CartEntity> listCartEntity = cartRepository.findByAccountID(accountID);
        for (CartEntity cartEntity : listCartEntity) {
            cartRepository.delete(cartEntity);
        }
    }

    @Override
    public List<CartDTO> findAllByAccountID(Integer userID) {
        List<CartDTO> cartDTOList = new ArrayList<>();

        List<CartEntity> cartEntities = cartRepository.findAllByAccountID(userID);

        if (!cartEntities.isEmpty()) {
            for (CartEntity cart : cartEntities) {
                cartDTOList.add(cartConvert.toDTO(cart));
            }
        }
        return cartDTOList;
    }

}
