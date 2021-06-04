package com.usian.service;


import com.usian.vo.CartTermVO;

import java.util.List;

public interface CartService {
    void addItem(Long userId, Long itemId);

    List<CartTermVO> getCart(Long userId);
}
