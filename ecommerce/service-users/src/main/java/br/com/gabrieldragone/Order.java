package br.com.gabrieldragone;

import java.math.BigDecimal;

public record Order(String orderId, BigDecimal amount, String email) { }
