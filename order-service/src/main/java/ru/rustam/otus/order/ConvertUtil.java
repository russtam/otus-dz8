package ru.rustam.otus.order;

import lombok.experimental.UtilityClass;
import ru.rustam.otus.order.db.OrderEntity;
import ru.rustam.otus.order.db.OrderItem;
import ru.rustam.otus.order.models.OrderDto;
import ru.rustam.otus.order.models.OrderItemDto;
import ru.rustam.otus.rabbitmq.model.OrderItemMessage;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class ConvertUtil {

    public static OrderEntity convertOrder(OrderDto src) {
        OrderEntity dst = new OrderEntity();
        dst.setOrderId(src.getOrderId());
        dst.setAmount(src.getAmount());
        dst.setContactPhone(src.getContactPhone());
        dst.setDeliveryAddress(src.getDeliveryAddress());
        dst.setItems(convertItemDtoList(src.getItems()));
        dst.setStatus(src.getStatus());
        return dst;
    }

    public static OrderItem convertItem(OrderItemDto src) {
        return new OrderItem(src.getItemId(), src.getCount());
    }

    public static List<OrderItem> convertItemDtoList(List<OrderItemDto> src) {
        if (src == null) {
            return null;
        }
        if (src.isEmpty()) {
            return Collections.emptyList();
        }
        return src.stream().map(ConvertUtil::convertItem).toList();
    }

    public static OrderDto convertOrder(OrderEntity src) {
        OrderDto dst = new OrderDto();
        dst.setOrderId(src.getOrderId());
        dst.setAmount(src.getAmount());
        dst.setContactPhone(src.getContactPhone());
        dst.setDeliveryAddress(src.getDeliveryAddress());
        dst.setItems(convertItemList(src.getItems()));
        dst.setStatus(src.getStatus());
        return dst;
    }

    public static OrderItemDto convertItem(OrderItem src) {
        return new OrderItemDto(src.getItemId(), src.getCount());
    }

    public static List<OrderItemDto> convertItemList(List<OrderItem> src) {
        if (src == null) {
            return null;
        }
        if (src.isEmpty()) {
            return Collections.emptyList();
        }
        return src.stream().map(ConvertUtil::convertItem).toList();
    }

    public static OrderItemMessage convertItemForMessage(OrderItem src) {
        return new OrderItemMessage(src.getItemId(), src.getCount());
    }

    public static List<OrderItemMessage> convertItemListForMessage(List<OrderItem> src) {
        if (src == null) {
            return null;
        }
        if (src.isEmpty()) {
            return Collections.emptyList();
        }
        return src.stream().map(ConvertUtil::convertItemForMessage).toList();
    }

}
